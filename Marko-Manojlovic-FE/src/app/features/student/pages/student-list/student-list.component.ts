import { Component, OnDestroy, OnInit, QueryList, ViewChildren } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { ConfirmOption } from 'src/app/core/enums';
import { PageRequest, Student } from 'src/app/core/models';
import { StudentService } from 'src/app/core/services/student.service';
import { ToastService } from 'src/app/core/services/toast.service';
import { ConfirmDialogComponent } from 'src/app/shared/components/confirm-dialog/confirm-dialog.component';
import { DetailsStudentComponent } from 'src/app/shared/components/details-student/details-student.component';
import { EditStudentComponent } from 'src/app/shared/components/edit-student/edit-student.component';
import { SortableHeaderDirective, SortEvent } from 'src/app/shared/directives/sortable-header.directive';

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

  @ViewChildren(SortableHeaderDirective)
  headers?:QueryList<SortableHeaderDirective>;

  constructor(private httpStudent: StudentService, private activeRoute: ActivatedRoute,
     private modalService: NgbModal, private toastService: ToastService) { }


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
    const modalRef = this.modalService.open(ConfirmDialogComponent);
    modalRef.componentInstance.message = `Are you sure you want to delete student <strong> ${student.firstname + ' ' + student.lastname} </strong>`;
    modalRef.componentInstance.headerText = `Deleting student`;
    modalRef.result.then(
      result => result === ConfirmOption.OK && this.deleteSelectedStudent(student)
    )
  }

  deleteSelectedStudent(student: Student) {
    this.httpStudent.deleteStudent(student).subscribe({
      next: response => {
        this.toastService.showToast({header: 'Deleting student', message: 'Student deleted successfully', className:'bg-success'});
        this.loadStudents();
        console.log("Student ", student.studentId, " successfully deleted!");
      },
      error: error => this.toastService.showToast({header: 'Deleting student', message: 'Student was not deleted', className:'bg-danger'})
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

  onSort(event: SortEvent) {
    console.log(event);
    // Resetujemo vrednost direction attributa colona na koje nije kliknuto
    this.headers?.forEach( sortableDirective =>
      (sortableDirective.sortable != event.column)  && (sortableDirective.direction = '')
     )

    this.pageInfo.pageNo = 1;
    this.pageInfo.sortBy = event.column;
    this.pageInfo.sortOrder = event.direction;
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
