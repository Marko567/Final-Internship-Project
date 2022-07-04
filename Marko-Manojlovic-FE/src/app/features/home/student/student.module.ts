import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentRoutingModule } from './student-routing.module';
import { StudentListComponent } from './pages/student-list/student-list.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { SaveNewStudentComponent } from './pages/save-new-student/save-new-student.component';

@NgModule({
  declarations: [
    StudentListComponent,
    SaveNewStudentComponent
  ],
  imports: [
    CommonModule,
    StudentRoutingModule,
    SharedModule
  ]
})
export class StudentModule { }
