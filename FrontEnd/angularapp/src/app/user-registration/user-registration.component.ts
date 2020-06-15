import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';
import { HttpInterceptor, HttpClient, HttpErrorResponse } from '@angular/common/http';
//import { Response } from '@angular/http`;

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit{

    private userId:number;
    private txtUsername:String;
    private txtPassword:String;
    private txtEmail:String;
    private txtAddressLine1:String;
    private txtAddressLine2:String;
    private txtCity:String;
    private txtTelephone_1:String;
    private txtTelephone_2:String;

    private data:any[];
    result: string;

    constructor(private dataService: DataService,private router: Router) { }

    ngOnInit() {}

    save(){
        var telephones = {
          "telephoneNumber_1": this.txtTelephone_1,
          "telephoneNumber_2": this.txtTelephone_2
        }

        var address = {
          "addressLine1":this.txtAddressLine1,
          "addressLine2":this.txtAddressLine2,
          "city":this.txtCity
        }

        var user = {
          "userId":this.userId,
          "username" : this.txtUsername,
          "password":this.txtPassword,
          "email":this.txtEmail,
          "address":address,
          "telephones":telephones,
          "role":"user"
        };

        console.log("Form creation data "+this.txtUsername + this.txtPassword);
        console.log("txtTelephone_1 "+this.txtTelephone_1);
        console.log("txtTelephone_1 "+this.txtTelephone_2);

        this.dataService.createUser(user).subscribe(
          (data: any[]) => {
               this.data = data,
               this.result = "You have succesfully registered to the system";
               console.log("successfully regitered to system"); 
               this.router.navigate(['login']);
            },
          /*(response:Response) => {
              console.log("response "+response.status);  
              console.log(response); 
              //console.log(response.); 
              this.result = "Registration failed. Try again";
              //console.log( JSON.stringify(response.body));
              //alert(error._body.type);
           },*/
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
