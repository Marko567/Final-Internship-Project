import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { City, Student } from 'src/app/core/models';
import { HttpCityService } from 'src/app/core/services/http-city.service';
import { StudentService } from 'src/app/core/services/student.service';

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css']
})
export class EditStudentComponent implements OnInit, OnDestroy {

  student?: Student;
  studentForm?: FormGroup;
  cities?: City[];
  subsciptions = new Subscription();

  constructor(private cityService: HttpCityService, public modal: NgbActiveModal,
     private fb: FormBuilder,
     private studentService: StudentService) { }

  ngOnInit(): void {
    this.loadCities();
    this.buildForm(this.student);
  }
  ngOnDestroy(): void {
    this.subsciptions.unsubscribe();
  }
  loadCities() {
    this.subsciptions.add(
      this.cityService.getAll().subscribe(cities => this.cities = cities)
    );
  }
  buildForm(student: Student | undefined) {
    this.studentForm = this.fb.group({
      studentId: [student?.studentId],
      firstname: [student?.firstname, Validators.required],
      lastname: [student?.lastname],
      indexNumber: [student?.indexNumber],
      indexYear: [student?.indexYear],
      email: [student?.email],
      address: [student?.address],
      postalCode: [student?.postalCode.zipCode, Validators.required],
      currentYearOfStudy: [student?.currentYearOfStudy, Validators.required]
    })
  }

  onSubmit() {
    if(this.studentForm?.invalid) {
      return;
    }
    const formData = this.studentForm?.getRawValue() as Student;
    this.studentService.updateStudent(formData).subscribe({
      next: response => {
        this.modal.close('yes');
        console.log("RESPONSE:", response);
      },
      error: error => {
        console.log("Error: ", error);
      }
    });
  }
}
