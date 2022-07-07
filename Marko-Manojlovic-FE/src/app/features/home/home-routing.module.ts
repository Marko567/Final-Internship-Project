import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { NewExamPeriodComponent } from './pages/new-exam-period/new-exam-period.component';

const routes: Routes = [
  {path:'test', component: HomePageComponent,
  children: [
    {path: 'define-new-exam-period', component: NewExamPeriodComponent}
  ]},
  {path:'', pathMatch: 'full', redirectTo: 'test'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
