import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

   books = [];
   categories = [];
   private txtSearch:String;
   //private category:String;
   private categoryId:number;

   constructor(private dataService: DataService) { }

     ngOnInit() {
      this.dataService.fetchAllBooks().subscribe((data: any[])=>{
        console.log(data);
        this.books = data;
      });

      this.dataService.fetchAllCategories().subscribe((categoryData: any[])=>{
        console.log(categoryData);
        this.categories = categoryData;
      });
      
     }

    searchBook(){
        console.log("response "+this.txtSearch);
        
        this.dataService.searchBook(this.txtSearch).subscribe(
          (data: any[]) => {
                console.log("response "+this.txtSearch);
               this.books = data;
               //this.result = "You have succesfully registered to the system";
               //this.router.navigate(['admin-home']);
            },
          (response) => {
              console.log("response "+response.status);   
              //this.result = "Try again";
           }
        );
    }

    categoryBooks(categoryId){
       console.log("response "+categoryId);
        
        this.dataService.fetchBookByCategory(categoryId).subscribe(
          (data: any[]) => {
              console.log("response "+categoryId);
              this.books = data;  
            },
          (response) => {
              console.log("response "+response.status);   
           }
        );
    }



}
