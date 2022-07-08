import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GeneralOverviewComponent } from './pages/general-overview/general-overview.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { NewExamPeriodComponent } from './pages/new-exam-period/new-exam-period.component';
import { NewExamComponent } from './pages/new-exam/new-exam.component';

const routes: Routes = [
  {path:'test', component: HomePageComponent,
  children: [
    {path: 'define-new-exam-period', component: NewExamPeriodComponent},
    {path: 'general-overview', component: GeneralOverviewComponent},
    {path: 'define-new-exam', component: NewExamComponent}
  ]},
  {path:'', pathMatch: 'full', redirectTo: 'test'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
