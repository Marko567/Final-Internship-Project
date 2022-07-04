import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Student } from 'src/app/core/models';

@Component({
  selector: 'app-details-student',
  templateUrl: './details-student.component.html',
  styleUrls: ['./details-student.component.css']
})
export class DetailsStudentComponent implements OnInit {
  student?: Student;

  constructor(public modal: NgbActiveModal) { }

  ngOnInit(): void {
  }

}
