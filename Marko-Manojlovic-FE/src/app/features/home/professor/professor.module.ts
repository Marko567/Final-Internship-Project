import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfessorRoutingModule } from './professor-routing.module';
import { ProfessorListComponent } from './pages/professor-list/professor-list.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { SaveNewProfessorComponent } from './pages/save-new-professor/save-new-professor.component';


@NgModule({
  declarations: [
    ProfessorListComponent,
    SaveNewProfessorComponent
  ],
  imports: [
    CommonModule,
    ProfessorRoutingModule,
    SharedModule
  ]
})
export class ProfessorModule { }
