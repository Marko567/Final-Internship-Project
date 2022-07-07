import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveNewProfessorComponent } from './save-new-professor.component';

describe('SaveNewProfessorComponent', () => {
  let component: SaveNewProfessorComponent;
  let fixture: ComponentFixture<SaveNewProfessorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaveNewProfessorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SaveNewProfessorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
