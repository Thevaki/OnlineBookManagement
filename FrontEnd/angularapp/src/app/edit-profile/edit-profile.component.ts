import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from "@angular/router";
import { HttpInterceptor, HttpClient, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

    private userId:number;
    private txtUsername:String;
    private txtPassword:String;
    private txtEmail:String;
    private txtAddressId:number;
    private txtAddressLine1:String;
    private txtAddressLine2:String;
    private txtCity:String;
    private txtTelephoneId:number;
    private txtTelephone_1:String;
    private txtTelephone_2:String;

    private data:any;

    constructor(private dataService: DataService,private router: Router,private route: ActivatedRoute) { }

    result: string;

   users = [];

   //private userId="";
    private username="";

   ngOnInit() {
   	//this.userId = this.route.snapshot.paramMap.get("id");
   	//this.userId = "3";
     this.username = localStorage.getItem("username");
    this.dataService.findUserById(this.username).subscribe((data: any)=>{
      console.log(data);
      this.users = data;

      this.userId = data.userId;
      this.txtUsername = data.username;
      this.txtPassword = data.password;
      this.txtEmail = data.email;
      this.txtAddressId = data.address.id;
      this.txtAddressLine1 = data.address.addressLine1;
      this.txtAddressLine2 = data.address.addressLine2;
      this.txtCity = data.address.city;
      this.txtTelephoneId = data.telephones.id;
      this.txtTelephone_1 = data.telephones.telephoneNumber_1;
      this.txtTelephone_2 = data.telephones.telephoneNumber_2;
    })  
  }

   editProfile(){
        var telephones = {
          "id":this.txtTelephoneId,
          "telephoneNumber_1": this.txtTelephone_1,
          "telephoneNumber_2": this.txtTelephone_2
        }

        var address = {
          "id":this.txtAddressId,
          "addressLine1":this.txtAddressLine1,
          "addressLine2":this.txtAddressLine2,
          "city":this.txtCity
        }

        console.log(this.txtUsername);

        var user = {
          "userId":this.userId,
          "username" : this.txtUsername,
          "password":this.txtPassword,
          "email":this.txtEmail,
          "address":address,
          "telephones":telephones,
          "role":"user"
        };
        
        console.log(user);
        this.dataService.editProfile(user).subscribe(
          (data: any[]) => {
               this.data = data,
               this.result = "You have succesfully registered to the system";
               this.router.navigate(['books']);
            },
          /*(response) => {
              console.log("response "+response.status);   
              this.result = "Try again";
           }*/
           (error: HttpErrorResponse) => {
              console.log("Error"+error.error);
              console.log(error.error); 
              console.log("Message"+error.error.message);
              var found = error.error.message.split(",").indexOf("1");

              var stringArray = error.error.message.split(',');       
                for (var i=0; i<stringArray.length; i++) {
                    if (stringArray[i].match("messageTemplate")) {
                      //alert('Its matched');
                      console.log("Its matched "+i+stringArray[i]);
                          var messageTemplate = stringArray[i].split("=");
                          console.log(messageTemplate[1]);
                          var message = messageTemplate[1].replace(/[^\w ]+/g,'').replace(/ +/g,' ');
                          this.result = message;
                    }         
                }
              //this.result = "Registration failed. Try again";
              }
        );
  }

}
