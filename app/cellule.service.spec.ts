import { TestBed, inject } from '@angular/core/testing';

import { CelluleService } from './cellule.service';

describe('CelluleService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CelluleService]
    });
  });

  it('should be created', inject([CelluleService], (service: CelluleService) => {
    expect(service).toBeTruthy();
  }));
});
