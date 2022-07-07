import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ExamPeriodStatus } from 'src/app/core/models';
import { HttpExamPeriodStatusService } from 'src/app/core/services/http-exam-period-status.service';

@Component({
  selector: 'app-new-exam-period',
  templateUrl: './new-exam-period.component.html',
  styleUrls: ['./new-exam-period.component.css']
})
export class NewExamPeriodComponent implements OnInit {
  examPeriodForm?: FormGroup;
  examPeriodStatuses: ExamPeriodStatus[] = [];

  constructor(private httpExamPeriodStatus: HttpExamPeriodStatusService) { }

  ngOnInit(): void {
    this.httpExamPeriodStatus.getAll().subscribe(response => this.examPeriodStatuses = response);
  }

  hasErrors(componentName: string, errorCode?: string) {
    console.log("hasErrors(componentName, errorCode):", componentName, errorCode);

    return  (this.examPeriodForm?.get(componentName)?.dirty || this.examPeriodForm?.get(componentName)?.touched) &&
    ((!errorCode && this.examPeriodForm?.get(componentName)?.errors ) ||
    (errorCode && this.examPeriodForm?.get(componentName)?.hasError(errorCode)));
  }
  onSubmit() {
    if(this.examPeriodForm?.invalid) {
      return;
    }
    const formData =  this.examPeriodForm?.getRawValue();


    // this.subjectService.saveSubject(formData).subscribe({
    //   next: response => {
    //     console.log("response", response);
    //   },
    //   error: error => {
    //     console.log("An error occured while saving the subject...", error);
    //   }
    // })
    // this.router.navigate(['/subject/subject-list']);
  }
}
