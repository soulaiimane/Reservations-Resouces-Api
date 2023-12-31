import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-persons',
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.css']
})
export class PersonsComponent implements OnInit {
  persons: any

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
    this.http.get("http://localhost:9999/reservation-service/persons").subscribe({
      next: (data) => {
        this.persons = data
      }, error: (err) => {
        console.log(err.message)
      }
    })
  }

  handleDeletePerson(personId: number) {
    this.http.delete("http://localhost:8082/persons/"+personId).subscribe({
      next:(data)=>{
        alert("The Person With Id= " + personId+" Was Deleted SuccessFully")
        this.ngOnInit()
      }, error: (err) => {
        console.log(err.message)
      }
    })
  }

  handleUpdatePerson(id:number) {

  }

  handleNewPerson() {
    this.router.navigateByUrl("/newPerson")
  }

  handlePersonReservations(personId:number) {
    this.router.navigateByUrl("personReservations/"+personId)
  }

  handleNewReservation(personId:number) {
    this.router.navigateByUrl("/newReservation/"+personId)

  }
}

