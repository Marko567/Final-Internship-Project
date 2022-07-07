import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { PageRequest, Professor } from 'src/app/core/models';
import { HttpProfessorService } from 'src/app/core/services/http-professor.service';
import { DetailsProfessorComponent } from 'src/app/shared/components/details-professor/details-professor.component';
import { EditProfessorComponent } from 'src/app/shared/components/edit-professor/edit-professor.component';

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


  constructor(private professorService: HttpProfessorService, private activeRoute: ActivatedRoute, private modalService: NgbModal) { }

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
      console.log('Yes click');
      console.log("YES:", yes);
      this.loadProfessors();
    },
    (cancel) => {console.log("cancel click")})
  }
  onDetails(professor: Professor) {
    const modalRef = this.modalService.open(DetailsProfessorComponent);
    modalRef.componentInstance.professor = professor;

  }
  onDelete(professor: Professor) {
    this.professorService.deleteProfessor(professor).subscribe({
      next: response => {
        this.loadProfessors();
        console.log("Professor with ID ", professor.professorId," sucessfully deleted!");
      },
      error: error => {
        console.log("error", error);
      }
    })
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
