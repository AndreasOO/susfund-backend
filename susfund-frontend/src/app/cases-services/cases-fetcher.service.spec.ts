import { TestBed } from '@angular/core/testing';

import { CasesFetcherService } from './cases-fetcher.service';

describe('CasesFetcherService', () => {
  let service: CasesFetcherService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CasesFetcherService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
