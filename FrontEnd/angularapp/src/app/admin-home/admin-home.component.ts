import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { ActivatedRoute } from "@angular/router";
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {
  private data:any[];
	books = [];
  categories = [];
  result: string;
  private bookId = "";
  private txtSearch:String;
  private category:String;

  constructor(private dataService: DataService,private route: ActivatedRoute) { }

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

  deleteBook(bookId){

        console.log(bookId);
        //this.bookId = this.route.snapshot.paramMap.get("id");

        this.dataService.deleteBook(bookId).subscribe(
          (data: any[]) => {
               this.data = data,
               this.result = "You have succesfully added a book to the system";
               //this.router.navigate(['admin-home']);
               this.ngOnInit();
            },
          (response) => {
              console.log("response "+response.status);   
              this.result = "Try again";
           }
        );
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
