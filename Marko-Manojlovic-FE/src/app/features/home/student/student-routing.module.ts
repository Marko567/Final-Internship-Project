import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentListComponent } from './pages/student-list/student-list.component';

const routes: Routes = [
  {path: 'student-list', component: StudentListComponent },
  {path: '', pathMatch: 'full', redirectTo: 'student-list'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
