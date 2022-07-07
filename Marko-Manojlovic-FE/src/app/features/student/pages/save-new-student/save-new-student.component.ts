import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { City, Student } from 'src/app/core/models';
import { HttpCityService } from 'src/app/core/services/http-city.service';
import { StudentService } from 'src/app/core/services/student.service';

@Component({
  selector: 'app-save-new-student',
  templateUrl: './save-new-student.component.html',
  styleUrls: ['./save-new-student.component.css']
})
export class SaveNewStudentComponent implements OnInit {
  studentForm?: FormGroup;
  cities?: City[];

  constructor(private fb: FormBuilder, private cityService: HttpCityService,
     private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {
    this.buildForm();
    this.cityService.getAll().subscribe(response => this.cities = response);
  }

  onSubmit() {
    if(this.studentForm?.invalid) {
      return;
    }
    const formData =  this.studentForm?.getRawValue() as Student;
    this.studentService.saveStudent(formData).subscribe({
      next: response => {
        console.log("response", response);
      },
      error: error => {
        console.log("Error occured while saving student...", error);
      }
    })
    this.router.navigate(['/student/student-list']);
  }

  buildForm() {
    this.studentForm = this.fb.group({
      studentId: [''],
      firstname: ['', [Validators.required, Validators.minLength(3)]],
      lastname: ['', [Validators.required, Validators.minLength(3)]],
      indexNumber: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(4)]],
      indexYear: ['', [Validators.required, Validators.min(2000), Validators.max(2100)]],
      email: ['', Validators.email],
      address: ['', Validators.minLength(3)],
      postalCode: ['', Validators.required],
      currentYearOfStudy: ['', Validators.required]
    })
  }

  hasErrors(componentName: string, errorCode?: string) {
    return  (this.studentForm?.get(componentName)?.dirty || this.studentForm?.get(componentName)?.touched) &&
    ((!errorCode && this.studentForm?.get(componentName)?.errors ) ||
    (errorCode && this.studentForm?.get(componentName)?.hasError(errorCode)));
  }
}
