import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ExamPeriod, Professor, Subject } from 'src/app/core/models';
import { HttpExamPeriodService } from 'src/app/core/services/http-exam-period.service';
import { HttpExamService } from 'src/app/core/services/http-exam.service';
import { HttpProfessorService } from 'src/app/core/services/http-professor.service';
import { HttpSubjectService } from 'src/app/core/services/http-subject.service';

@Component({
  selector: 'app-new-exam',
  templateUrl: './new-exam.component.html',
  styleUrls: ['./new-exam.component.css']
})
export class NewExamComponent implements OnInit {
  selectedSubject?: Subject;
  subjects?: Subject[];
  professors?: Professor[];
  activeExamPeriod?: ExamPeriod;
  examPeriods?: ExamPeriod[];
  examForm?: FormGroup;

  constructor(private httpSubject: HttpSubjectService, private httpExamPeriod: HttpExamPeriodService,
    private httpProfessor: HttpProfessorService, private fb: FormBuilder,
    private router: Router, private httpExam: HttpExamService) { }

  ngOnInit(): void {
    this.loadSubjects();
    this.loadActiveExamPeriod();
    this.loadExamPeriods();
    this.buildForm();
  }

  loadSubjects() {
    this.httpSubject.getSubjects().subscribe(response => this.subjects = response);
  }

  loadActiveExamPeriod() {
    this.httpExamPeriod.getActiveExamPeriod().subscribe({
      next: response => {
        this.activeExamPeriod = response
      },
      error: error => {
        console.log("Error", error);
      }
    });
  }

  loadExamPeriods() {
    this.httpExamPeriod.getExamPeriods().subscribe(response => this.examPeriods = response);
  }

  loadProfessors() {
    if(this.selectedSubject?.subjectId != null) {

      this.httpProfessor.getProfessorsEngagedOnSubject(this.selectedSubject?.subjectId).subscribe({
        next: response => {
          this.professors = response;
        },
        error: error => {
          console.log("Error", error);
        }
      });
    }
  }
  onSubjectSelect() {
    this.loadProfessors();
  }

  onSubmit() {
    if(this.examForm?.invalid) {
      return;
    }
    const formData =  this.examForm?.getRawValue();

    const payload = { examPeriodId: formData.examPeriod.id as number,
      professorId: formData.professor.professorId as number,
      subjectId: formData.subject.subjectId as number,
      date: formData.date as Date};

    this.httpExam.saveExam(payload).subscribe({
      next: response => {
        console.log("response", response);
      },
      error: error => {
        console.log("An error occured while saving the exam period...", error);
      }
    })
    this.router.navigate(['/home/test/general-overview']);
  }

  buildForm() {
    this.examForm = this.fb.group({
      subject: [''],
      professor: [''],
      examPeriod: [''],
      date: [''],
    })
  }
}
