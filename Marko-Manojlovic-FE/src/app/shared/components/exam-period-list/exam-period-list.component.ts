import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ExamPeriod } from 'src/app/core/models';
import { HttpExamPeriodService } from 'src/app/core/services/http-exam-period.service';

@Component({
  selector: 'app-exam-period-list',
  templateUrl: './exam-period-list.component.html',
  styleUrls: ['./exam-period-list.component.css']
})
export class ExamPeriodListComponent implements OnInit {
  examPeriodList?: ExamPeriod[];

  constructor(private httpExamPeriod: HttpExamPeriodService, public modal: NgbActiveModal) { }

  ngOnInit(): void {
    console.log("Exam period list from Modal: ", this.examPeriodList);
  }

  setActive(examPeriod: ExamPeriod) {
    let status = {statusId: 1, name: "Active"}

    const modifiedExamPeriod: ExamPeriod = {
      id: examPeriod?.id as number,
      name: examPeriod?.name as string,
      startDate: examPeriod?.startDate as Date,
      endDate: examPeriod?.endDate as Date,
      examPeriodStatus: status
    }

    this.httpExamPeriod.updateExamPeriod(modifiedExamPeriod).subscribe({
      next: response => {
        console.log("response", response),
        this.modal.close('yes');
      },
      error: error => {
        console.log("Error", error);
      }
    })
  }
}
