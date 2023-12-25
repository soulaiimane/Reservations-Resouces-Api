import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ResourcesComponent} from "./resources/resources.component";
import {ReservationsComponent} from "./reservations/reservations.component";

const routes: Routes = [
  {
    path:"resources", component:ResourcesComponent,

  },
  {
    path:"reservations", component:ReservationsComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
