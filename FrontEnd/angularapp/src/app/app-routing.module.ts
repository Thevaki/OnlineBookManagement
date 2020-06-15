import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BooksComponent } from './books/books.component';
import { LoginComponent } from './login/login.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { UserComponent } from './user/user.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AddBookComponent } from './add-book/add-book.component';
import { EditBookComponent } from './edit-book/edit-book.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';

const routes: Routes = [
  {
    path: 'books',    
    component: BooksComponent
  },
  {
    path:'login',
    component:LoginComponent
  },
  {
    path: 'book-detail/:id',    
    component: BookDetailComponent
  },
  {
    path: 'user-registration',    
    component: UserRegistrationComponent
  },
  {
    path: 'user',    
    component: UserComponent
  },
  {
    path: 'admin-home',    
    component: AdminHomeComponent
  },
  {
    path: 'add-book',    
    component: AddBookComponent
  },
  {
    path: 'add-book/:id',    
    component: AddBookComponent
  },
  {
    path: 'edit-book/:id',    
    component: EditBookComponent
  },
   {
    path: 'edit-profile',    
    component: EditProfileComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
