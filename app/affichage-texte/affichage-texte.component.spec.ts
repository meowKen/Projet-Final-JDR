import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AffichageTexteComponent } from './affichage-texte.component';

describe('AffichageTexteComponent', () => {
  let component: AffichageTexteComponent;
  let fixture: ComponentFixture<AffichageTexteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AffichageTexteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AffichageTexteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
