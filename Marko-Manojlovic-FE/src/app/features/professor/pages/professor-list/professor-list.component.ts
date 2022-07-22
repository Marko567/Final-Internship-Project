import { Component, OnDestroy, OnInit, QueryList, ViewChildren } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { ConfirmOption } from 'src/app/core/enums';
import { PageRequest, Professor } from 'src/app/core/models';
import { HttpProfessorService } from 'src/app/core/services/http-professor.service';
import { ToastService } from 'src/app/core/services/toast.service';
import { ConfirmDialogComponent } from 'src/app/shared/components/confirm-dialog/confirm-dialog.component';
import { DetailsProfessorComponent } from 'src/app/shared/components/details-professor/details-professor.component';
import { EditProfessorComponent } from 'src/app/shared/components/edit-professor/edit-professor.component';
import { SortableHeaderDirective, SortEvent } from 'src/app/shared/directives/sortable-header.directive';

@Component({
  selector: 'app-professor-list',
  templateUrl: './professor-list.component.html',
  styleUrls: ['./professor-list.component.css']
})
export class ProfessorListComponent implements OnInit, OnDestroy {
  professors?: Professor[];
  subscriptions = new Subscription();
  pageInfo: PageRequest = {pageNo: 1, pageSize:2, totalItems: 10, sortBy: 'firstname', sortOrder:'asc'}
  availablePageSizes = [2, 3, 5, 10, 15,20 , 25, 30]

  @ViewChildren(SortableHeaderDirective)
  headers?:QueryList<SortableHeaderDirective>;

  constructor(private professorService: HttpProfessorService, private activeRoute: ActivatedRoute,
     private modalService: NgbModal, private toastService: ToastService) { }

  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

  onPageChange(pageNo: number) {
    this.loadProfessors();
  }

  onPageSizeChange() {
    this.pageInfo.pageNo = 1;
    this.loadProfessors();
  }
  ngOnInit(): void {
    const pageNoParam = Number(this.activeRoute.snapshot.queryParamMap.get('pageNo'));

    if(pageNoParam) {
      this.pageInfo.pageNo = pageNoParam;
      this.pageInfo.pageSize = Number(this.activeRoute.snapshot.queryParamMap.get('pageSize'));
    }
    this.loadProfessors();
  }

  onEditProfessor(professor: Professor) {
    const modalRef = this.modalService.open(EditProfessorComponent);
    modalRef.componentInstance.professor = professor;

    modalRef.result.then((yes) => {
      console.log("YES:", yes);
      this.loadProfessors();
    },
    (cancel) => {console.log("X click")})
  }
  onDetails(professor: Professor) {
    const modalRef = this.modalService.open(DetailsProfessorComponent);
    modalRef.componentInstance.professor = professor;

  }
  onDelete(professor: Professor) {
    const modalRef = this.modalService.open(ConfirmDialogComponent);
    modalRef.componentInstance.message = `Are you sure you want to delete professor <strong> ${professor.firstname + ' ' + professor.lastname} </strong>`;
    modalRef.componentInstance.headerText = `Deleting professor`;
    modalRef.result.then(
      result => result === ConfirmOption.OK && this.deleteSelectedProfessor(professor)
    )
  }
  deleteSelectedProfessor(professor: Professor) {
    this.professorService.deleteProfessor(professor).subscribe({
      next: response => {
        this.toastService.showToast({header: 'Deleting professor', message: 'Professor deleted successfully', className:'bg-success'});
        this.loadProfessors();
        console.log("Professor with ID ", professor.professorId," sucessfully deleted!");
      },
      error: error => this.toastService.showToast({header: 'Deleting professor', message: 'Professor was not deleted', className:'bg-danger'})
    })
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
    this.loadProfessors();
  }

  loadProfessors() {
    this.subscriptions.add(
      this.professorService.getByPage(this.pageInfo)
      .subscribe(cityPage => {
        this.professors = cityPage.content;
        this.pageInfo.totalItems = cityPage.totalElements;
        this.pageInfo.pageSize = cityPage.size;
        this.pageInfo.pageNo = cityPage.number + 1;
      })
    );
  }
}
