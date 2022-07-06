import { TestBed } from '@angular/core/testing';

import { HttpSemesterService } from './http-semester.service';

describe('HttpSemesterService', () => {
  let service: HttpSemesterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpSemesterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
