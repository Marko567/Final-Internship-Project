import { AbstractControl, ValidatorFn } from "@angular/forms";
import { ExamPeriod } from "src/app/core/models";

export function activeExamPeriodValidator(activeExamPeriod: ExamPeriod | undefined): ValidatorFn {
  return (control: AbstractControl): {[key: string]: any} | null => {
    console.log("ACTIVE EXAM PERIOD:", activeExamPeriod);

    if(activeExamPeriod !== null && control.value.statusId === 1) {
      console.log(activeExamPeriod);
      return {'activeExamPeriods': true};
    } else return null;
  }
}
