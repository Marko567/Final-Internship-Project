import { Component, OnInit } from '@angular/core';
import { ExamPeriod, Professor, Subject } from 'src/app/core/models';
import { HttpExamPeriodService } from 'src/app/core/services/http-exam-period.service';
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

  constructor(private httpSubject: HttpSubjectService, private httpExamPeriod: HttpExamPeriodService) { }

  ngOnInit(): void {
    this.loadSubjects();
    this.loadActiveExamPeriod();
    this.loadExamPeriods();
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
}
