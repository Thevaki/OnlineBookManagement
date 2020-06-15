import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from "@angular/router";
import { HttpInterceptor, HttpClient, HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.css']
})
export class EditBookComponent implements OnInit {

  private txtName:String;
  private txtAuthor:String;
  private txtBookImageUrl:String;
  private txtCategoryId:number;
  private txtCategoryName:String;

  private data:any[];
  categories = [];
  txtCategory = [];
  books = [];

  constructor(private dataService: DataService,private router: Router,private route: ActivatedRoute) { }

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
  this.bookId = this.route.snapshot.paramMap.get("id");
    this.dataService.fetchAllCategories().subscribe((categoryData: any[])=>{
        console.log(categoryData);
        this.categories = categoryData;
        console.log(this.categories);
    });

    this.dataService.findBook(this.bookId).subscribe((data: any)=>{  
     this.books = data;

     this.txtName = data.bookName;
     this.txtAuthor = data.author;
     this.txtBookImageUrl = data.imageUrl;
     this.txtCategoryId = data.bookCategory.id;
     this.txtCategoryName = data.bookCategory.name;

     console.log(this.books);
     //this.txtCategory = this.books.bookCategory;
     //console.log(this.txtCategory);
    });
  }

  result: string;

  private bookId = "";

  editBook(){

        var book = {
          "bookId":this.bookId,
          "bookName":this.txtName,
          "author" : this.txtAuthor,
          "imageUrl":this.txtBookImageUrl,
          "bookCategory": { 
                "id":this.txtCategoryId,
                "name": this.txtCategoryName
           }  
        };

        console.log("Form creation data "+this.txtName);

        this.dataService.editBook(book).subscribe(
          (data: any[]) => {
               this.data = data,
               this.result = "You have succesfully edited the book to the system";
               this.router.navigate(['admin-home']);
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
