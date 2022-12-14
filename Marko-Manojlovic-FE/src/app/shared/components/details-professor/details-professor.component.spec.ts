import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsProfessorComponent } from './details-professor.component';

describe('DetailsProfessorComponent', () => {
  let component: DetailsProfessorComponent;
  let fixture: ComponentFixture<DetailsProfessorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsProfessorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailsProfessorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
