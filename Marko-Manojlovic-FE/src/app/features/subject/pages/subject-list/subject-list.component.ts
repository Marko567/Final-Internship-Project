import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { ConfirmOption } from 'src/app/core/enums';
import { PageRequest, Subject } from 'src/app/core/models';
import { HttpSubjectService } from 'src/app/core/services/http-subject.service';
import { ToastService } from 'src/app/core/services/toast.service';
import { ConfirmDialogComponent } from 'src/app/shared/components/confirm-dialog/confirm-dialog.component';
import { DetailsSubjectComponent } from 'src/app/shared/components/details-subject/details-subject.component';
import { EditSubjectComponent } from 'src/app/shared/components/edit-subject/edit-subject.component';

@Component({
  selector: 'app-subject-list',
  templateUrl: './subject-list.component.html',
  styleUrls: ['./subject-list.component.css']
})
export class SubjectListComponent implements OnInit {

  subjects?: Subject[];
  subscriptions = new Subscription();

  pageInfo: PageRequest = {pageNo: 1, pageSize:2, totalItems: 10, sortBy: 'name', sortOrder:'asc'}
  availablePageSizes = [2, 3, 5, 10, 15,20 , 25, 30]


  constructor(private httpSubject: HttpSubjectService, private activeRoute: ActivatedRoute,
     private modalService: NgbModal, private toastService: ToastService) { }


  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

  onPageChange(pageNo: number) {
    this.loadSubjects();
  }

  onPageSizeChange() {
    this.pageInfo.pageNo = 1;
    this.loadSubjects();
  }

  onEditSubject(subject: Subject) {
    const modalRef = this.modalService.open(EditSubjectComponent);
    modalRef.componentInstance.subject = subject;

    modalRef.result.then((yes) => {
      console.log('Yes click');
      console.log("YES:", yes);
      this.loadSubjects();
    },
    (cancel) => {console.log("cancel click")})
  }

  onDetails(subject: Subject) {
    const modalRef = this.modalService.open(DetailsSubjectComponent);
    modalRef.componentInstance.subject = subject;
  }
  onDelete(subject: Subject) {
    const modalRef = this.modalService.open(ConfirmDialogComponent);
    modalRef.componentInstance.message = `Are you sure you want to delete subject <strong> ${subject.name} </strong>`;
    modalRef.componentInstance.headerText = `Deleting subject`;
    modalRef.result.then(
      result => result === ConfirmOption.OK && this.deleteSelectedSubject(subject)
    )
  }

  deleteSelectedSubject(subject: Subject) {
    this.httpSubject.deleteSubject(subject).subscribe({
      next: response => {
        this.toastService.showToast({header: 'Deleting subject', message: 'Subject deleted successfully', className:'bg-success'});
        this.loadSubjects();
        console.log("Subject ", subject.subjectId, " successfully deleted!");
      },
      error: error => this.toastService.showToast({header: 'Deleting subject', message: 'Subject was not deleted', className:'bg-danger'})
    })
  }

  ngOnInit(): void {
    const pageNoParam = Number(this.activeRoute.snapshot.queryParamMap.get('pageNo'));

    if(pageNoParam) {
      this.pageInfo.pageNo = pageNoParam;
      this.pageInfo.pageSize = Number(this.activeRoute.snapshot.queryParamMap.get('pageSize'));
    }
    this.loadSubjects();
    console.log(this.subjects);
  }

  loadSubjects() {
    this.subscriptions.add(
      this.httpSubject.getByPage(this.pageInfo)
      .subscribe(cityPage => {
        this.subjects = cityPage.content;
        this.pageInfo.totalItems = cityPage.totalElements;
        this.pageInfo.pageSize = cityPage.size;
        this.pageInfo.pageNo = cityPage.number + 1;
      })
    );
  }
}
