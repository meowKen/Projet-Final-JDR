import { TestBed, inject } from '@angular/core/testing';

import { PlateauService } from './plateau.service';

describe('PlateauService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PlateauService]
    });
  });

  it('should be created', inject([PlateauService], (service: PlateauService) => {
    expect(service).toBeTruthy();
  }));
});
