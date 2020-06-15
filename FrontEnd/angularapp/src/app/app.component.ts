import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-app';

  signOut(){
  console.log(localStorage.getItem("id_token"));
  localStorage.clear();
  console.log(localStorage.getItem("id_token"));
  }
}
