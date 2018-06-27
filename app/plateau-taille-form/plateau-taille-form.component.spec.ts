import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlateauTailleFormComponent } from './plateau-taille-form.component';

describe('PlateauTailleFormComponent', () => {
  let component: PlateauTailleFormComponent;
  let fixture: ComponentFixture<PlateauTailleFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlateauTailleFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlateauTailleFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
