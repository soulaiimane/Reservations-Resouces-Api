import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-person',
  templateUrl: './new-person.component.html',
  styleUrls: ['./new-person.component.css']
})
export class NewPersonComponent implements OnInit{
  newPersonFormGroup! :FormGroup
  constructor(private fb:FormBuilder,private http:HttpClient, private router:Router) {
  }
  ngOnInit(): void {
    this.newPersonFormGroup=this.fb.group({
      name:this.fb.control(null),
      email:this.fb.control(null),
      function:this.fb.control(null)
    })
  }

  handleNewCustomer() {
    let personDto:any=this.newPersonFormGroup.value
    this.http.post("http://localhost:9999/reservation-service/persons/newPerson",personDto).subscribe({
      next:(data)=>{
        personDto=data
        alert("The Person Was Added Successfully with Id = " +personDto.id)
        //this.router.navigateByUrl("/persons")
      }, error: (err) => {
        console.log(err.message)
      }
    })

  }
}
