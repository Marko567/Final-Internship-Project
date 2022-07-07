import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SaveNewSubjectComponent } from './pages/save-new-subject/save-new-subject.component';
import { SubjectListComponent } from './pages/subject-list/subject-list.component';

const routes: Routes = [
  {path: 'subject-list', component: SubjectListComponent },
  {path: 'add-new-subject', component: SaveNewSubjectComponent},
  {path: '', pathMatch: 'full', redirectTo: 'subject-list'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SubjectRoutingModule { }
