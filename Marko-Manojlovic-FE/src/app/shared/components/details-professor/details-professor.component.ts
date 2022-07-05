import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Professor } from 'src/app/core/models';

@Component({
  selector: 'app-details-professor',
  templateUrl: './details-professor.component.html',
  styleUrls: ['./details-professor.component.css']
})
export class DetailsProfessorComponent implements OnInit {
  professor?: Professor;

  constructor(public modal: NgbActiveModal) { }

  ngOnInit(): void {
  }

}
