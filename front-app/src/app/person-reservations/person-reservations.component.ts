import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-person-reservations',
  templateUrl: './person-reservations.component.html',
  styleUrls: ['./person-reservations.component.css']
})
export class PersonReservationsComponent implements OnInit{
  public reservations:any
  public personId!:number
  constructor(private route:ActivatedRoute,private http:HttpClient) {
  this.personId=route.snapshot.params['personId']
  }
  ngOnInit(): void {
    this.http.get("http://localhost:9999/reservation-service/reservations/Person/"+this.personId).subscribe({
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
