import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonReservationsComponent } from './person-reservations.component';

describe('PersonReservationsComponent', () => {
  let component: PersonReservationsComponent;
  let fixture: ComponentFixture<PersonReservationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PersonReservationsComponent]
    });
    fixture = TestBed.createComponent(PersonReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
