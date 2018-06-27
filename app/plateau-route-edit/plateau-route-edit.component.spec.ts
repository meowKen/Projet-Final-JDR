import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlateauRouteEditComponent } from './plateau-route-edit.component';

describe('PlateauRouteEditComponent', () => {
  let component: PlateauRouteEditComponent;
  let fixture: ComponentFixture<PlateauRouteEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlateauRouteEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlateauRouteEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
