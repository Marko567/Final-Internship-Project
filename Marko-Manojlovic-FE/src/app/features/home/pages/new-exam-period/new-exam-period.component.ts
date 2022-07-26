import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ExamPeriod, ExamPeriodStatus } from 'src/app/core/models';
import { HttpExamPeriodStatusService } from 'src/app/core/services/http-exam-period-status.service';
import { HttpExamPeriodService } from 'src/app/core/services/http-exam-period.service';
import { activeExamPeriodValidator } from 'src/app/shared/validators/active-exam-period.validator';

@Component({
  selector: 'app-new-exam-period',
  templateUrl: './new-exam-period.component.html',
  styleUrls: ['./new-exam-period.component.css']
})
export class NewExamPeriodComponent implements OnInit {
  examPeriodForm?: FormGroup;
  examPeriodStatuses: ExamPeriodStatus[] = [];
  activeExamPeriod?: ExamPeriod;

  constructor(private httpExamPeriodStatus: HttpExamPeriodStatusService,
    private fb: FormBuilder, private httpExamPeriod: HttpExamPeriodService,
    private router: Router) {}

  ngOnInit(): void {
    this.loadActiveExamPeriod();
    this.httpExamPeriodStatus.getAll().subscribe(response => this.examPeriodStatuses = response);
    this.buildForm();
  }

  loadActiveExamPeriod() {
    this.httpExamPeriod.getActiveExamPeriod().subscribe({
      next: response => {
        this.activeExamPeriod = response;
        console.log("Response: ", response);
      },
      error: error=> {
        console.log("Error", error);
      }
    });
  }

  hasErrors(componentName: string, errorCode?: string) {
    console.log("hasErrors(componentName, errorCode):", componentName, errorCode);

    return  (this.examPeriodForm?.get(componentName)?.dirty || this.examPeriodForm?.get(componentName)?.touched) &&
    ((!errorCode && this.examPeriodForm?.get(componentName)?.errors ) ||
    (errorCode && this.examPeriodForm?.get(componentName)?.hasError(errorCode)));
  }
  buildForm() {
    this.examPeriodForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      startDate: [''],
      endDate: ['', Validators.required],
      examPeriodStatus: ['', [Validators.required]],
    })
  }

  onSubmit() {
    if(this.examPeriodForm?.invalid) {
      return;
    }
    const formData =  this.examPeriodForm?.getRawValue();


    this.httpExamPeriod.saveExamPeriod(formData).subscribe({
      next: response => {
        console.log("response", response);
      },
      error: error => {
        console.log("An error occured while saving the exam period...", error);
      }
    })
    this.router.navigate(['/home']);
  }
}
