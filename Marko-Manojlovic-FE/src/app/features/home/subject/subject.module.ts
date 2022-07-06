import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SubjectRoutingModule } from './subject-routing.module';
import { SubjectListComponent } from './pages/subject-list/subject-list.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { SaveNewSubjectComponent } from './pages/save-new-subject/save-new-subject.component';


@NgModule({
  declarations: [
    SubjectListComponent,
    SaveNewSubjectComponent
  ],
  imports: [
    CommonModule,
    SubjectRoutingModule,
    SharedModule
  ]
})
export class SubjectModule { }
