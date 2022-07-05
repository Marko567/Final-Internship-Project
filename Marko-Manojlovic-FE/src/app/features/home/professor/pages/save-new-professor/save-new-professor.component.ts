import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { City, Professor, Subject, Title } from 'src/app/core/models';
import { HttpCityService } from 'src/app/core/services/http-city.service';
import { HttpProfessorService } from 'src/app/core/services/http-professor.service';
import { HttpSubjectService } from 'src/app/core/services/http-subject.service';
import { HttpTitleService } from 'src/app/core/services/http-title.service';

@Component({
  selector: 'app-save-new-professor',
  templateUrl: './save-new-professor.component.html',
  styleUrls: ['./save-new-professor.component.css']
})
export class SaveNewProfessorComponent implements OnInit {
  professorForm?: FormGroup;
  cities?: City[];
  titles?: Title[];
  selectedSubject?: Subject;
  subjects?: Subject[];
  selectedSubjects?: Subject[];

  constructor(private fb: FormBuilder, private cityService: HttpCityService,
     private professorService: HttpProfessorService, private router: Router,
     private titleService: HttpTitleService, private subjectService: HttpSubjectService) { }

  ngOnInit(): void {
    this.buildForm();
    this.cityService.getAll().subscribe(response => this.cities = response);
    this.titleService.getAll().subscribe(response  => this.titles = response);
    this.subjectService.getSubjects().subscribe(response => this.subjects = response);
    this.selectedSubjects = [];
  }

  onSubmit() {
    if(this.professorForm?.invalid) {
      return;
    }
    const formData =  this.professorForm?.getRawValue() as Professor;
    console.log("FORM DATA: ", formData);

    this.professorService.saveProfessor(formData).subscribe({
      next: response => {
        console.log("response", response);
      },
      error: error => {
        console.log("Error occured while saving student...", error);
      }
    })
    this.router.navigate(['/professor/professor-list']);
  }

  addSubject() {
    if(this.selectedSubject) {
      this.selectedSubjects?.push(this.selectedSubject);
      console.log(this.selectedSubject);
      console.log("SELECTED SUBJECTS:", this.selectedSubjects);
    }
  }

  removeSubject(i: number) {
    this.selectedSubjects?.splice(i, 1);
  }

  buildForm() {
    this.professorForm = this.fb.group({
      professorId: [''],
      firstname: ['', Validators.required],
      lastname: [''],
      email: [''],
      address: [''],
      postalCode: ['', Validators.required],
      title: ['', Validators.required],
      phone: ['', Validators.required],
      reelectionDate: ['']
    })
  }
}
