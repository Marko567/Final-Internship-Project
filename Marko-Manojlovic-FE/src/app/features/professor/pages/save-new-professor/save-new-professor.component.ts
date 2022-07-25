import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { City, Engagement, Professor, Subject, Title } from 'src/app/core/models';
import { HttpCityService } from 'src/app/core/services/http-city.service';
import { HttpEngagementService } from 'src/app/core/services/http-engagement.service';
import { HttpProfessorService } from 'src/app/core/services/http-professor.service';
import { HttpSubjectService } from 'src/app/core/services/http-subject.service';
import { HttpTitleService } from 'src/app/core/services/http-title.service';
import { ToastService } from 'src/app/core/services/toast.service';

@Component({
  selector: 'app-save-new-professor',
  templateUrl: './save-new-professor.component.html',
  styleUrls: ['./save-new-professor.component.css']
  //providers: [HttpCityService]
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
     private titleService: HttpTitleService, private subjectService: HttpSubjectService,
     private engagementService: HttpEngagementService, private toastService: ToastService) { }

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
        this.toastService.showToast({header: 'Saving professor', message: `Professor ${response.firstname} ${response.lastname} is successfully saved!`, className:'bg-success'});
        let engagements: Engagement[] = [];
        if(this.selectedSubjects && this.selectedSubjects.length > 0) {
          for(let i = 0; i < this.selectedSubjects.length; i++) {
            engagements.push({professorId: response.professorId, subjectId: this.selectedSubjects[i].subjectId} as Engagement);
          }

          console.log("Engagements of professor: ", engagements);

          this.saveEngagements(engagements);
        }
      },
      error: error => {
        console.log("Error occured while saving professor...", error);
        this.toastService.showToast({header: 'Saving professor', message: 'Professor is not saved, error occured during saving!', className:'bg-danger'});
      }
    })

  }

  saveEngagements(engagements: Engagement[]) {
    this.engagementService.saveEngagements(engagements).subscribe({
      next: response2 => {
        console.log("response2", response2);
        this.toastService.showToast({header: 'Saving engagements', message: 'Professor\'s engagements are successfully saved', className:'bg-success'})
        this.router.navigate(['/professor/professor-list']);
      },
      error: error => {
        console.log("Error ocured while saving engagements", error);
        this.toastService.showToast({header: 'Saving engagements', message: 'An error occured during saving professor\'s engagements', className:'bg-danger'})
      }
    });
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
      firstname: ['', [Validators.required, Validators.minLength(3)]],
      lastname: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', Validators.email],
      address: ['', Validators.minLength(3)],
      postalCode: ['', Validators.required],
      title: ['', Validators.required],
      phone: ['', Validators.minLength(9)],
      reelectionDate: ['', Validators.required]
    })
  }

  hasErrors(componentName: string, errorCode?: string) {

    return  (this.professorForm?.get(componentName)?.dirty || this.professorForm?.get(componentName)?.touched) &&
    ((!errorCode && this.professorForm?.get(componentName)?.errors ) ||
    (errorCode && this.professorForm?.get(componentName)?.hasError(errorCode)));
  }
}
