import { TestBed } from '@angular/core/testing';

import { HttpExamPeriodStatusService } from './http-exam-period-status.service';

describe('HttpExamPeriodStatusService', () => {
  let service: HttpExamPeriodStatusService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpExamPeriodStatusService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
