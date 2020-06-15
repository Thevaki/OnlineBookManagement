import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
//import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private httpClient: HttpClient) { }

  //private FETCH_ALL_BOOKS = "http://172.17.237.209:8762//book/Book/fetchAllBooks";

  private FETCH_ALL_BOOKS = "http://localhost:8762/book/Book/fetchAllBooks";

   public fetchAllBooks(){
      const idToken = localStorage.getItem("id_token");
      console.log(idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': idToken });
      let options = { headers: headers };
    return this.httpClient.get(this.FETCH_ALL_BOOKS,options);
  }

  private FIND_BOOK = "http://localhost:8762/book/Book/searchBooks/";

   public searchBook(txtSearch){
    const idToken = localStorage.getItem("id_token");
      console.log(idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': idToken });
      let options = { headers: headers };
    return this.httpClient.get(this.FIND_BOOK+txtSearch,options);
  }

  private SEARCH_BOOK = "http://localhost:8762/book/Book/findBook/";

   public findBook(bookId){
    const idToken = localStorage.getItem("id_token");
      console.log(idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': idToken });
      let options = { headers: headers };
    return this.httpClient.get(this.SEARCH_BOOK+bookId,options);
  }

  private CATEGORY_BOOK = "http://localhost:8762/book/Book/categoryBooks/";

   public categoryBooks(category){
    const idToken = localStorage.getItem("id_token");
      console.log(idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': idToken });
      let options = { headers: headers };
    return this.httpClient.get(this.CATEGORY_BOOK+category,options);
  }

  private FETCH_ALL__CATEGORIES = "http://localhost:8762/book/Book/fetchAllCategories";

   public fetchAllCategories(){
    const idToken = localStorage.getItem("id_token");
      console.log(idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': idToken });
      let options = { headers: headers };
    return this.httpClient.get(this.FETCH_ALL__CATEGORIES,options);
  }

  private FETCH_BOOK_BY_CATEGORY = "http://localhost:8762/book/Book/findCategoryBooks/";

   public fetchBookByCategory(categoryId){
    const idToken = localStorage.getItem("id_token");
      console.log(idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': idToken });
      let options = { headers: headers };
    return this.httpClient.get(this.FETCH_BOOK_BY_CATEGORY+categoryId,options);
  }

  private CREATE_USER = "http://localhost:8762/user/User/createUser";

  createUser(user){
      /*const idToken = localStorage.getItem("id_token");
      console.log(idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': idToken });
      let options = { headers: headers };*/

      return this.httpClient.post(this.CREATE_USER,user);
  }

  private FIND_USER_ID = "http://localhost:8762/user/User/findByUsername/";

   public findUserById(userId){
      const idToken = localStorage.getItem("id_token");
      console.log(idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': idToken });
      let options = { headers: headers };
    return this.httpClient.get(this.FIND_USER_ID+userId,options);
  }

  private EDIT_PROFILE = "http://localhost:8762/user/User/editUserDetails";

   public editProfile(user){
      const idToken = localStorage.getItem("id_token");
      console.log(idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': idToken });
      let options = { headers: headers };
    return this.httpClient.put(this.EDIT_PROFILE,user,options);
  }

  private CREATE_BOOK = "http://localhost:8762/book/Book/createBook";

  createBook(book){
      const idToken = localStorage.getItem("id_token");
      console.log("Token "+idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': "Bearer "+idToken });
      let options = { headers: headers };

      return this.httpClient.post(this.CREATE_BOOK,book,options);
  }

  private EDIT_BOOK = "http://localhost:8762/book/Book/editBook";

  editBook(book){
      const idToken = localStorage.getItem("id_token");
      console.log("Token "+idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': "Bearer "+idToken });
      let options = { headers: headers };

      return this.httpClient.put(this.EDIT_BOOK,book,options);
  }

  private DELETE_BOOK = "http://localhost:8762/book/Book/deleteBook/";

  deleteBook(bookId){
      const idToken = localStorage.getItem("id_token");
      console.log("Token "+idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': "Bearer "+idToken });
      let options = { headers: headers };

      return this.httpClient.delete(this.DELETE_BOOK+bookId,options);
  }

  private FETCH_ALL_USERS = "http://localhost:8762/user/User/fetchAllUsers";

   public fetchAllUsers(){
    const idToken = localStorage.getItem("id_token");
      console.log("Token "+idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': "Bearer "+idToken });
      let options = { headers: headers };

    return this.httpClient.get(this.FETCH_ALL_USERS,options);
   }
  

  private returnedData;

  private LOGIN = "http://localhost:8762/auth";

  login(user){

    this.returnedData = this.httpClient.post(this.LOGIN, user, {observe: 'response'});
    return this.returnedData;
  }

}
