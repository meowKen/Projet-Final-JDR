import { TestBed, inject } from '@angular/core/testing';

import { InventaireService } from './inventaire.service';

describe('InventaireService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InventaireService]
    });
  });

  it('should be created', inject([InventaireService], (service: InventaireService) => {
    expect(service).toBeTruthy();
  }));
});
