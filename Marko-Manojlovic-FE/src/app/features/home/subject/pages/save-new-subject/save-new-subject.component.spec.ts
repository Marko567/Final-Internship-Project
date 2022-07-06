import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveNewSubjectComponent } from './save-new-subject.component';

describe('SaveNewSubjectComponent', () => {
  let component: SaveNewSubjectComponent;
  let fixture: ComponentFixture<SaveNewSubjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaveNewSubjectComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SaveNewSubjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
