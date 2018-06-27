import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlateauEditComponent } from './plateau-edit.component';

describe('PlateauEditComponent', () => {
  let component: PlateauEditComponent;
  let fixture: ComponentFixture<PlateauEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlateauEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlateauEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
