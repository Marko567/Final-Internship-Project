import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { City, Student } from 'src/app/core/models';
import { HttpCityService } from 'src/app/core/services/http-city.service';
import { StudentService } from 'src/app/core/services/student.service';
import { StudentRoutingModule } from 'src/app/features/student/student-routing.module';

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css']
})
export class EditStudentComponent implements OnInit, OnDestroy {

  student: Student = {studentId: 0, firstname: "f", lastname: "l", indexNumber: "0000",
   indexYear: 2001, email: "f.l@c.com", address: "mvn jjijgq 76",
    postalCode: {zipCode: "11000", name: "Beograd"}, currentYearOfStudy: 1};

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
  buildForm(student: Student) {
    this.studentForm = this.fb.group({
      studentId: [student?.studentId],
      firstname: [student?.firstname, [Validators.required, Validators.minLength(3)]],
      lastname: [student?.lastname, [Validators.required, Validators.minLength(3)]],
      indexNumber: [student?.indexNumber, [Validators.required, Validators.minLength(4), Validators.maxLength(4)]],
      indexYear: [student?.indexYear, [Validators.required, Validators.min(2000), Validators.max(2100)]],
      email: [student?.email, Validators.email],
      address: [student?.address, Validators.minLength(3)],
      postalCode: [student.postalCode.zipCode, Validators.required],
      currentYearOfStudy: [student?.currentYearOfStudy, Validators.required]
    });
  }

  onSubmit() {
    if(this.studentForm?.invalid) {
      return;
    }
    let formData = this.studentForm?.getRawValue();

    let zipCode = formData.postalCode;
    let city;
    if(this.cities) {
      city = this.cities.find(x => x.zipCode === zipCode);
    }
    formData.postalCode = city;

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

  hasErrors(componentName: string, errorCode?: string) {
    return  (this.studentForm?.get(componentName)?.dirty || this.studentForm?.get(componentName)?.touched) &&
    ((!errorCode && this.studentForm?.get(componentName)?.errors ) ||
    (errorCode && this.studentForm?.get(componentName)?.hasError(errorCode)));
  }
}
