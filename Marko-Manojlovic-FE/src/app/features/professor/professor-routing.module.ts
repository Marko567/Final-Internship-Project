import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfessorListComponent } from './pages/professor-list/professor-list.component';
import { SaveNewProfessorComponent } from './pages/save-new-professor/save-new-professor.component';

const routes: Routes = [
  {path: 'professor-list', component: ProfessorListComponent },
  {path: 'add-new-professor', component: SaveNewProfessorComponent},
  {path: '', pathMatch: 'full', redirectTo: 'professor-list'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfessorRoutingModule { }
