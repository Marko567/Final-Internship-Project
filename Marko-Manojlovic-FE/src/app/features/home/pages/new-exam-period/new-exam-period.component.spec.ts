import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewExamPeriodComponent } from './new-exam-period.component';

describe('NewExamPeriodComponent', () => {
  let component: NewExamPeriodComponent;
  let fixture: ComponentFixture<NewExamPeriodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewExamPeriodComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewExamPeriodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
