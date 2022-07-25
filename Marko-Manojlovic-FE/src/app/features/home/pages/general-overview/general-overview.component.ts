import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Exam, ExamPeriod, ExamPeriodStatus } from 'src/app/core/models';
import { HttpExamPeriodService } from 'src/app/core/services/http-exam-period.service';
import { HttpExamService } from 'src/app/core/services/http-exam.service';
import { ExamPeriodListComponent } from 'src/app/shared/components/exam-period-list/exam-period-list.component';

@Component({
  selector: 'app-general-overview',
  templateUrl: './general-overview.component.html',
  styleUrls: ['./general-overview.component.css']
})
export class GeneralOverviewComponent implements OnInit {
  activeExamPeriod?: ExamPeriod;
  examPeriodList?: ExamPeriod[];
  exams?: Exam[] = [];

  constructor(private httpExamPeriod: HttpExamPeriodService,  private modalService: NgbModal,
    private httpExam: HttpExamService) { }

  ngOnInit(): void {
    this.loadActiveExamPeriod();
    this.loadExamPeriodList();
    this.loadExamsFromActiveExamPeriod();
  }

  loadActiveExamPeriod() {
    this.httpExamPeriod.getActiveExamPeriod().subscribe({
      next: response => {
        this.activeExamPeriod = response
      },
      error: error => {
        console.log("Error", error);
      }
    });
  }
  loadExamsFromActiveExamPeriod() {
    this.httpExam.getExamsFromActiveExamPeriod().subscribe(response => this.exams = response);
  }

  loadExamPeriodList() {
    this.httpExamPeriod.getExamPeriods().subscribe(response => this.examPeriodList = response);
  }

  changeExamPeriodStatus() {
    var status = {statusId: 2, name: "Inactive"};
    const aep: ExamPeriod = {
      id: this.activeExamPeriod?.id as number,
      name: this.activeExamPeriod?.name as string,
      startDate: this.activeExamPeriod?.startDate as Date,
      endDate: this.activeExamPeriod?.endDate as Date,
      examPeriodStatus: status
    }

    this.httpExamPeriod.updateExamPeriod(aep).subscribe({
      next: response => {
        this.loadActiveExamPeriod();
        this.loadExamPeriodList();
        this.loadExamsFromActiveExamPeriod();
      },
      error: error => {
        console.log("Error", error);
      }
    })
  }
  setActiveExamPeriod() {
    const modalRef = this.modalService.open(ExamPeriodListComponent);
    modalRef.componentInstance.examPeriodList = this.examPeriodList;

    modalRef.result.then((yes) => {
      console.log("yes:", yes);
      this.loadActiveExamPeriod();
      this.loadExamsFromActiveExamPeriod();
    },
    (cancel) => {console.log("cancel click")})
  }
}
