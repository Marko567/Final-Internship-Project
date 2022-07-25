import { TestBed } from '@angular/core/testing';

import { HttpEngagementService } from './http-engagement.service';

describe('HttpEngagementService', () => {
  let service: HttpEngagementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpEngagementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
