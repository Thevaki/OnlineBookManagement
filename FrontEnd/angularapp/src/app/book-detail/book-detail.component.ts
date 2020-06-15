import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})

export class BookDetailComponent implements OnInit {

   constructor(private dataService: DataService,private route: ActivatedRoute) { }

    bookName: string;
    author:String;
    imageUrl:String;

    private bookId = "";

    ngOnInit() {
      this.bookId = this.route.snapshot.paramMap.get("id");
      this.dataService.findBook(this.bookId).subscribe((data: any)=>{
      
      this.bookName = data.bookName;
      this.author = data.author;
      this.imageUrl = data.imageUrl;
    });

   }
}