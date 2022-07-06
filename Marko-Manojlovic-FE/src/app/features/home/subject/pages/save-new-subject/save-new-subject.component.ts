import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Semester } from 'src/app/core/models';
import { HttpSemesterService } from 'src/app/core/services/http-semester.service';
import { HttpSubjectService } from 'src/app/core/services/http-subject.service';

@Component({
  selector: 'app-save-new-subject',
  templateUrl: './save-new-subject.component.html',
  styleUrls: ['./save-new-subject.component.css']
})
export class SaveNewSubjectComponent implements OnInit {
  subjectForm?: FormGroup;
  semesters?: Semester[];

  constructor(private fb: FormBuilder, private semesterService: HttpSemesterService,
     private subjectService: HttpSubjectService, private router: Router) { }

  ngOnInit(): void {
    this.buildForm();
    this.semesterService.getAll().subscribe(response => this.semesters = response);
  }

  onSubmit() {
    if(this.subjectForm?.invalid) {
      return;
    }
    const formData =  this.subjectForm?.getRawValue();

    const semesterName = formData.semesterName;
    formData.semesterName = semesterName.semesterName;
    formData.semesterEntityId = semesterName.semesterEntityId;


    this.subjectService.saveSubject(formData).subscribe({
      next: response => {
        console.log("response", response);
      },
      error: error => {
        console.log("An error occured while saving the subject...", error);
      }
    })
    this.router.navigate(['/subject/subject-list']);
  }

  buildForm() {
    this.subjectForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      description: [''],
      noOfEsp: ['', Validators.required],
      yearOfStudy: ['', Validators.required],
      semesterName: ['', Validators.required],
    })
  }

  hasErrors(componentName: string, errorCode?: string) {
    return  (this.subjectForm?.get(componentName)?.dirty || this.subjectForm?.get(componentName)?.touched) &&
    ((!errorCode && this.subjectForm?.get(componentName)?.errors ) ||
    (errorCode && this.subjectForm?.get(componentName)?.hasError(errorCode)));
  }
}
