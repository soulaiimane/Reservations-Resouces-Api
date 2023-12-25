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
    this.http.get("http://localhost:8082/reservations").subscribe({
      next:(data)=>{
        this.reservations=data
      },error:(err)=>{
        console.log(err.message)
      }
    })
  }


}
