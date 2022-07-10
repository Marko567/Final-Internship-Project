import { Component, Input, OnInit } from '@angular/core';
import { Exam, Professor, Subject } from 'src/app/core/models';
import { HttpProfessorService } from 'src/app/core/services/http-professor.service';
import { HttpSubjectService } from 'src/app/core/services/http-subject.service';

@Component({
  selector: 'app-exam-card',
  templateUrl: './exam-card.component.html',
  styleUrls: ['./exam-card.component.css']
})
export class ExamCardComponent implements OnInit {

  @Input() exam?: Exam;
  professor?: Professor;
  subject?: Subject;


  constructor(private httpProfessor: HttpProfessorService, private httpSubject: HttpSubjectService) { }

  ngOnInit(): void {
    this.httpProfessor.getById(this.exam?.professorId as number).subscribe(response => this.professor = response);
    this.httpSubject.getById(this.exam?.subjectId as number).subscribe(response => this.subject = response);
  }
}
