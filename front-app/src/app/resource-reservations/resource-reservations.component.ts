import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-resource-reservations',
  templateUrl: './resource-reservations.component.html',
  styleUrls: ['./resource-reservations.component.css']
})
export class ResourceReservationsComponent implements OnInit{
  public reservations:any
  public resourceId!:number
  constructor(private route:ActivatedRoute,private http:HttpClient) {
    this.resourceId=route.snapshot.params['resourceId']
  }
  ngOnInit(): void {
    this.http.get("http://localhost:9999/reservation-service/reservations/resources/"+this.resourceId).subscribe({
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
