import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { PageDto, PageRequest, Student } from 'src/app/core/models';
import { StudentService } from 'src/app/core/services/student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit, OnDestroy {

  students?: Student[];
  subscriptions = new Subscription();

  pageInfo: PageRequest = {pageNo: 1, pageSize:2, totalItems: 10, sortBy: 'name', sortOrder:'asc'}
  availablePageSizes = [2, 3, 5, 10, 15,20 , 25, 30]


  constructor(private httpStudent: StudentService, private activeRoute: ActivatedRoute) { }


  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

  onPageChange(pageNo: number) {
    this.loadStudents;
  }

  onPageSizeChange() {
    this.pageInfo.pageNo = 1;
    this.loadStudents();
  }

  onDelete(student: Student) {

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
