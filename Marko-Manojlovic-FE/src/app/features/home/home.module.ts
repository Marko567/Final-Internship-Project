import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { HomeRoutingModule } from './home-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { NewExamPeriodComponent } from './pages/new-exam-period/new-exam-period.component';
import { GeneralOverviewComponent } from './pages/general-overview/general-overview.component';
import { NewExamComponent } from './pages/new-exam/new-exam.component';
import { ExamCardComponent } from './pages/exam-card/exam-card.component';



@NgModule({
  declarations: [
    HomePageComponent,
    NewExamPeriodComponent,
    GeneralOverviewComponent,
    NewExamComponent,
    ExamCardComponent,
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    SharedModule
  ]
})
export class HomeModule { }
