import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Subject } from 'src/app/core/models';

@Component({
  selector: 'app-details-subject',
  templateUrl: './details-subject.component.html',
  styleUrls: ['./details-subject.component.css']
})
export class DetailsSubjectComponent implements OnInit {

  subject?: Subject;

  constructor(public modal: NgbActiveModal) { }

  ngOnInit(): void {
  }
}
