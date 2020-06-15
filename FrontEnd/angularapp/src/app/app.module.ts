import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BooksComponent } from './books/books.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AddBookComponent } from './add-book/add-book.component';
import { EditBookComponent } from './edit-book/edit-book.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';


@NgModule({
  declarations: [
    AppComponent,
    BooksComponent,
    UserComponent,
    LoginComponent,
    BookDetailComponent,
    UserRegistrationComponent,
    AdminHomeComponent,
    AddBookComponent,
    EditBookComponent,
    EditProfileComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent],

})
export class AppModule { }