import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users = [];

  constructor(private dataService: DataService) { }

  ngOnInit() {
	this.dataService.fetchAllUsers().subscribe((data: any[])=>{
      console.log(data);
      this.users = data;
    })  
  }

}
