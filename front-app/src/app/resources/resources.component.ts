import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-resources',
  templateUrl: './resources.component.html',
  styleUrls: ['./resources.component.css']
})
export class ResourcesComponent implements OnInit{
  resources:any

  constructor(private http:HttpClient,private router:Router) {
  }
  ngOnInit(): void {
    this.http.get("http://localhost:8081/resources").subscribe({
      next:(data)=>{
        this.resources=data
      },error:(err)=>{
        console.log(err.message)
      }
    })
  }


}
