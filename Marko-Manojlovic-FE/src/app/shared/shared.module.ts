import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgbDropdownModule, NgbModalModule, NgbNavModule, NgbPaginationModule, NgbToastModule, NgbTooltipModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './components/header/header.component';
import { BootstrapSetupIconsModule } from './bootstrap-setup-icons/bootstrap-setup-icons.module';
import { EditStudentComponent } from './components/edit-student/edit-student.component';
import { DetailsStudentComponent } from './components/details-student/details-student.component';
import { DetailsProfessorComponent } from './components/details-professor/details-professor.component';
import { EditProfessorComponent } from './components/edit-professor/edit-professor.component';
import { DetailsSubjectComponent } from './components/details-subject/details-subject.component';
import { EditSubjectComponent } from './components/edit-subject/edit-subject.component';
import { ExamPeriodListComponent } from './components/exam-period-list/exam-period-list.component';
import { ConfirmDialogComponent } from './components/confirm-dialog/confirm-dialog.component';
import { GlobalToastComponent } from './components/global-toast/global-toast.component';


@NgModule({
  declarations: [
    HeaderComponent,
    EditStudentComponent,
    DetailsStudentComponent,
    DetailsProfessorComponent,
    EditProfessorComponent,
    DetailsSubjectComponent,
    EditSubjectComponent,
    ExamPeriodListComponent,
    ConfirmDialogComponent,
    GlobalToastComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,

    NgbTooltipModule,
    NgbPaginationModule,
    NgbToastModule,
    NgbModalModule,
    NgbNavModule,
    NgbDropdownModule,

    BootstrapSetupIconsModule,
  ], exports:[
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,

    NgbTooltipModule,
    NgbPaginationModule,
    NgbToastModule,
    NgbModalModule,
    NgbNavModule,
    NgbDropdownModule,

    HeaderComponent,
    DetailsProfessorComponent,
    DetailsSubjectComponent,
    BootstrapSetupIconsModule,
    ConfirmDialogComponent,
    GlobalToastComponent
  ]
})
export class SharedModule { }
