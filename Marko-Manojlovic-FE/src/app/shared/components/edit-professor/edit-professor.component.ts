import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { City, Professor, Title } from 'src/app/core/models';
import { HttpCityService } from 'src/app/core/services/http-city.service';
import { HttpProfessorService } from 'src/app/core/services/http-professor.service';
import { HttpTitleService } from 'src/app/core/services/http-title.service';

@Component({
  selector: 'app-edit-professor',
  templateUrl: './edit-professor.component.html',
  styleUrls: ['./edit-professor.component.css']
})
export class EditProfessorComponent implements OnInit, OnDestroy {
  professor?: Professor;
  professorForm?: FormGroup;
  cities?: City[];
  titles?: Title[];
  subsciptions = new Subscription();

  constructor(private cityService: HttpCityService, public modal: NgbActiveModal,
     private fb: FormBuilder,
     private professorService: HttpProfessorService,
     private titleService: HttpTitleService) { }

  ngOnInit(): void {
    this.loadCities();
    this.loadTitles();

    this.buildForm(this.professor);
  }
  ngOnDestroy(): void {
    this.subsciptions.unsubscribe();
  }
  loadCities() {
    this.subsciptions.add(
      this.cityService.getAll().subscribe(cities => this.cities = cities)
    );
  }
  loadTitles() {
    this.subsciptions.add(
      this.titleService.getAll().subscribe(titles => this.titles = titles)
    );
  }
  buildForm(professor: Professor | undefined) {
    this.professorForm = this.fb.group({
      professorId: [professor?.professorId],
      firstname: [professor?.firstname, [Validators.required, Validators.minLength(3)]],
      lastname: [professor?.lastname, [Validators.required, Validators.minLength(3)]],
      email: [professor?.email, Validators.email],
      address: [professor?.address, Validators.minLength(3)],
      postalCode: [professor?.postalCode.zipCode, Validators.required],
      title: [professor?.title?.name, Validators.required],
      phone: [professor?.phone, Validators.minLength(9)],
      reelectionDate: [professor?.reelectionDate, Validators.required]
    })
  }

  onSubmit() {
    if(this.professorForm?.invalid) {
      return;
    }
    const formData = this.professorForm?.getRawValue() as Professor;
    this.professorService.updateProfessor(formData).subscribe({
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
    return  (this.professorForm?.get(componentName)?.dirty || this.professorForm?.get(componentName)?.touched) &&
    ((!errorCode && this.professorForm?.get(componentName)?.errors ) ||
    (errorCode && this.professorForm?.get(componentName)?.hasError(errorCode)));
  }
}
