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
      firstname: ['', Validators.required],
      lastname: [''],
      indexNumber: [''],
      indexYear: [''],
      email: [''],
      address: [''],
      postalCode: ['', Validators.required],
      currentYearOfStudy: ['', Validators.required]
    })
  }
}
