import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ResourcesComponent } from './resources/resources.component';
import {HttpClientModule} from "@angular/common/http";
import { ReservationsComponent } from './reservations/reservations.component';
import { PersonsComponent } from './persons/persons.component';
import {ReactiveFormsModule} from "@angular/forms";
import { NewPersonComponent } from './new-person/new-person.component';
import { PersonReservationsComponent } from './person-reservations/person-reservations.component';
import { ResourceReservationsComponent } from './resource-reservations/resource-reservations.component';
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
import { NewReservationComponent } from './new-reservation/new-reservation.component';
export function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'sdia-realm',
        clientId: 'sdia-angular-client'
      },
      initOptions: {
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri:
          window.location.origin + '/assets/silent-check-sso.html'
      }
    });
}
@NgModule({
  declarations: [
    AppComponent,
    ResourcesComponent,
    ReservationsComponent,
    PersonsComponent,
    NewPersonComponent,
    PersonReservationsComponent,
    ResourceReservationsComponent,
    NewReservationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    KeycloakAngularModule
  ],
  providers: [
    {provide : APP_INITIALIZER, deps : [KeycloakService],useFactory : initializeKeycloak, multi : true}],
  bootstrap: [AppComponent]
})

export class AppModule { }
