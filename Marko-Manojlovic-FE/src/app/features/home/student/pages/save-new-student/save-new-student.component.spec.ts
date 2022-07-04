import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveNewStudentComponent } from './save-new-student.component';

describe('SaveNewStudentComponent', () => {
  let component: SaveNewStudentComponent;
  let fixture: ComponentFixture<SaveNewStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaveNewStudentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SaveNewStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
