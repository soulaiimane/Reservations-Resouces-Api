import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ResourcesComponent} from "./resources/resources.component";
import {ReservationsComponent} from "./reservations/reservations.component";
import {PersonsComponent} from "./persons/persons.component";
import {NewPersonComponent} from "./new-person/new-person.component";
import {PersonReservationsComponent} from "./person-reservations/person-reservations.component";
import {ResourceReservationsComponent} from "./resource-reservations/resource-reservations.component";
import {AuthGuard} from "./guards/auth.guard";
import {NewReservationComponent} from "./new-reservation/new-reservation.component";

const routes: Routes = [
  {
    path:"resources", component:ResourcesComponent,
  },
  {
    path:"reservations", component:ReservationsComponent
  },
  {
    path:"persons",component:PersonsComponent
  },
  {
    path:"newPerson",component:NewPersonComponent
  },
  {
    path:"personReservations/:personId",component:PersonReservationsComponent
  },
  {
    path:"personReservations/:personId",component:PersonReservationsComponent
  },
  {
    path:"resourceReservations/:resourceId",component:ResourceReservationsComponent
  },
  {
    path:"newReservation/:personId",component:NewReservationComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
