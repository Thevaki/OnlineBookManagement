import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from "@angular/router";
import { HttpInterceptor, HttpClient, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

    //private userId:number;
    private txtName:String;
    private txtAuthor:String;
    private txtBookImageUrl:String;
    private txtCategoryId:number;
    private txtCategoryName:String;
    //private txtCategory:String;

    private data:any[];
    categories = [];
    txtCategory = [];

    constructor(private dataService: DataService,private router: Router,private route: ActivatedRoute) { }

    result: string;

    private bookId = "";

    onChangeObj(newObj) {
        console.log(newObj);
        this.txtCategory = newObj;
        this.txtCategoryId = Object["values"](this.txtCategory)[0];
        this.txtCategoryName = Object["values"](this.txtCategory)[1];
        // ... do other stuff here ...
        console.log(Object["values"](newObj));
        console.log(Object["values"](this.txtCategory)[0]);
        console.log(Object["values"](this.txtCategory)[1]);
    }

    ngOnInit() {
    this.dataService.fetchAllCategories().subscribe((categoryData: any[])=>{
        console.log(categoryData);
        this.categories = categoryData;
        console.log(this.categories);
      });
    }

    createBook(){

        console.log("category"+this.txtCategoryId+this.txtCategoryName);

        /*var category = {
          "id":this.txtCategoryId,
          "name":this.txtCategoryId
        }*/

        var book = {
          "bookName":this.txtName,
          "author" : this.txtAuthor,
          "imageUrl":this.txtBookImageUrl,
          "bookCategory": { 
                "id":this.txtCategoryId,
                "name": this.txtCategoryName
            }
        };

        //console.log("Form creation data "+book.bookCategory.id);

        this.dataService.createBook(book).subscribe(
          (data: any[]) => {
               this.data = data,
               this.result = "You have succesfully added a book to the system";
               this.router.navigate(['admin-home']);
            },
          /*(response) => {
              console.log("response "+response.status);   
              console.log("response "+response);  
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
