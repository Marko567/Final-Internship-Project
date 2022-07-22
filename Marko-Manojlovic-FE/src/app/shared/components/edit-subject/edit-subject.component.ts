import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { Semester, Subject } from 'src/app/core/models';
import { HttpSemesterService } from 'src/app/core/services/http-semester.service';
import { HttpSubjectService } from 'src/app/core/services/http-subject.service';

@Component({
  selector: 'app-edit-subject',
  templateUrl: './edit-subject.component.html',
  styleUrls: ['./edit-subject.component.css']
})
export class EditSubjectComponent implements OnInit {
  subject?: Subject;
  subjectForm?: FormGroup;
  semesters?: Semester[];
  subsciptions = new Subscription();

  constructor(public modal: NgbActiveModal,
     private fb: FormBuilder,
     private subjectService: HttpSubjectService,
     private semesterService: HttpSemesterService) { }

  ngOnInit(): void {
    this.loadSemesters();

    this.buildForm(this.subject);
  }
  ngOnDestroy(): void {
    this.subsciptions.unsubscribe();
  }
  loadSemesters() {
    this.subsciptions.add(
      this.semesterService.getAll().subscribe(semesters => this.semesters = semesters)
    );
  }

  buildForm(subject: Subject | undefined) {
    this.subjectForm = this.fb.group({
      subjectId: [subject?.subjectId],
      name: [subject?.name,  [Validators.required, Validators.minLength(3)]],
      description: [subject?.description],
      noOfEsp: [subject?.noOfEsp, Validators.required],
      yearOfStudy: [subject?.yearOfStudy, Validators.required],
      semester: [subject?.semester.id, Validators.required],
    })
  }

  onSubmit() {
    if(this.subjectForm?.invalid) {
      return;
    }
    const formData = this.subjectForm?.getRawValue();

    let semesterId = formData.semester;

    let semester;
    if(this.semesters) {
      semester = this.semesters.find(x => x.id === semesterId);
    }

    // zbog izmene u SubjectDto, mora ovako
    const customizedFormData = {name: formData.name, description: formData.description,
       noOfEsp: formData.noOfEsp, subjectId: formData.subjectId,
        yearOfStudy: formData.yearOfStudy, semester: semester} as Subject;

    this.subjectService.updateSubject(customizedFormData).subscribe({
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
    return  (this.subjectForm?.get(componentName)?.dirty || this.subjectForm?.get(componentName)?.touched) &&
    ((!errorCode && this.subjectForm?.get(componentName)?.errors ) ||
    (errorCode && this.subjectForm?.get(componentName)?.hasError(errorCode)));
  }
}
