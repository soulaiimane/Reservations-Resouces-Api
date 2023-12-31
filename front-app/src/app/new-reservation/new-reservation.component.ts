import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-new-reservation',
  templateUrl: './new-reservation.component.html',
  styleUrls: ['./new-reservation.component.css']
})
export class NewReservationComponent implements OnInit{
  newReservationFormGroup! :FormGroup
  personId!:number

  constructor(private fb:FormBuilder,private http:HttpClient, private router:Router,private route:ActivatedRoute) {
    this.personId=route.snapshot.params['personId']
  }
  ngOnInit(): void {
    this.newReservationFormGroup=this.fb.group({
      name:this.fb.control(null),
      context:this.fb.control(null),
      resourceId:this.fb.control(null),
      resourceName:this.fb.control(null),
      durationPerDay:this.fb.control(null),

    })
  }
  handleNewReservation() {
    let reservationDto:any=this.newReservationFormGroup.value
    this.http.post("http://localhost:9999/reservation-service/reservations/newReservations/"+this.personId,reservationDto).subscribe({
      next:(data)=>{
        reservationDto=data
        alert("The Reservation Was Added Successfully with Id = " +reservationDto.id)
        //this.router.navigateByUrl("/persons")
      }, error: (err) => {
        console.log(err.message)
      }
    })
  }
}
