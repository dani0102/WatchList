import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginStatus ='no profile';
  username = '';

  constructor() { }

  ngOnInit() {
  }

  onLoggedIn(){
    this.loginStatus ='logged in. your username: ' + this.username;
  }
  onUpdateUsername(event: any){
this.username = (<HTMLInputElement>event.target).value;
  }
}
