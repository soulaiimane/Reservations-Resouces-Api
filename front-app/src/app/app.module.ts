import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ResourcesComponent } from './resources/resources.component';
import {HttpClientModule} from "@angular/common/http";
import { ReservationsComponent } from './reservations/reservations.component';

@NgModule({
  declarations: [
    AppComponent,
    ResourcesComponent,
    ReservationsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
