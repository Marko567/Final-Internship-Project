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
    this.loadSemesters();
    this.buildForm();
  }
  loadSemesters() {
    this.semesterService.getAll().subscribe({
      next: response =>  {
         this.semesters = response;
         console.log(response);
      },
      error: error => {
        console.log("Error ocured while loading semesters...", error);
      }
    });
  }
  onSubmit() {
    if(this.subjectForm?.invalid) {
      return;
    }
    let formData =  this.subjectForm?.getRawValue();

    console.log(formData);

    const semesterId = formData.semester;

    let semester;
    if(this.semesters) {
      semester = this.semesters.find(x => x.id === semesterId);
    }

    formData.semester = semester;

    console.log("Form data pred slanje serveru", formData);

    // formData.semesterName = semesterName.semesterName;
    // formData.semesterEntityId = semesterName.semesterEntityId;


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
      semester: ['', Validators.required],
    })
  }

  hasErrors(componentName: string, errorCode?: string) {
    return  (this.subjectForm?.get(componentName)?.dirty || this.subjectForm?.get(componentName)?.touched) &&
    ((!errorCode && this.subjectForm?.get(componentName)?.errors ) ||
    (errorCode && this.subjectForm?.get(componentName)?.hasError(errorCode)));
  }
}
