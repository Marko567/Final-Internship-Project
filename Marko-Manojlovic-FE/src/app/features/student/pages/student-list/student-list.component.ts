import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { PageRequest, Student } from 'src/app/core/models';
import { StudentService } from 'src/app/core/services/student.service';
import { DetailsStudentComponent } from 'src/app/shared/components/details-student/details-student.component';
import { EditStudentComponent } from 'src/app/shared/components/edit-student/edit-student.component';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit, OnDestroy {

  students?: Student[];
  subscriptions = new Subscription();

  pageInfo: PageRequest = {pageNo: 1, pageSize:2, totalItems: 10, sortBy: 'firstname', sortOrder:'asc'}
  availablePageSizes = [2, 3, 5, 10, 15,20 , 25, 30]


  constructor(private httpStudent: StudentService, private activeRoute: ActivatedRoute, private modalService: NgbModal) { }


  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

  onPageChange(pageNo: number) {
    this.loadStudents();
  }

  onPageSizeChange() {
    this.pageInfo.pageNo = 1;
    this.loadStudents();
  }
  onEditStudent(student: Student) {
    const modalRef = this.modalService.open(EditStudentComponent);
    modalRef.componentInstance.student = student;

    modalRef.result.then((yes) => {
      console.log('Yes click');
      console.log("YES:", yes);
      this.loadStudents();
    },
    (cancel) => {console.log("cancel click")})
  }
  onDetails(student: Student) {
    const modalRef = this.modalService.open(DetailsStudentComponent);
    modalRef.componentInstance.student = student;

  }
  onDelete(student: Student) {
    this.httpStudent.deleteStudent(student).subscribe({
      next: response => {
        this.loadStudents();
        console.log("Student ", student.studentId, " successfully deleted!");
      },
      error: error => {
        console.log("error", error);
      }
    })
  }
  ngOnInit(): void {
    const pageNoParam = Number(this.activeRoute.snapshot.queryParamMap.get('pageNo'));

    if(pageNoParam) {
      this.pageInfo.pageNo = pageNoParam;
      this.pageInfo.pageSize = Number(this.activeRoute.snapshot.queryParamMap.get('pageSize'));
    }
    this.loadStudents();
  }

  loadStudents() {
    this.subscriptions.add(
      this.httpStudent.getByPage(this.pageInfo)
      .subscribe(cityPage => {
        this.students = cityPage.content;
        this.pageInfo.totalItems = cityPage.totalElements;
        this.pageInfo.pageSize = cityPage.size;
        this.pageInfo.pageNo = cityPage.number + 1;
      })
    );
  }
}