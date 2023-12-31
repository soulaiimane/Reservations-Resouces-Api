import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit{
  reservations:any

  constructor(private http:HttpClient,private router:Router) {
  }
  ngOnInit(): void {
    this.http.get("http://localhost:9999/reservation-service/reservations").subscribe({
      next:(data)=>{
        this.reservations=data
      },error:(err)=>{
        console.log(err.message)
      }
    })
  }

  handleDeleteReservation(reservationId: number) {
    this.http.delete("http://localhost:8082/reservations/"+reservationId).subscribe({
      next:(data)=>{
        alert("The Reservation With Id= " + reservationId+" Was Deleted SuccessFully")
        this.ngOnInit()
      }, error: (err) => {
        console.log(err.message)
      }
    })
  }

}
