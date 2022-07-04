import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SaveNewStudentComponent } from './pages/save-new-student/save-new-student.component';
import { StudentListComponent } from './pages/student-list/student-list.component';

const routes: Routes = [
  {path: 'student-list', component: StudentListComponent },
  {path: 'add-new-student', component: SaveNewStudentComponent},
  {path: '', pathMatch: 'full', redirectTo: 'student-list'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
