import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResourceReservationsComponent } from './resource-reservations.component';

describe('ResourceReservationsComponent', () => {
  let component: ResourceReservationsComponent;
  let fixture: ComponentFixture<ResourceReservationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ResourceReservationsComponent]
    });
    fixture = TestBed.createComponent(ResourceReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
