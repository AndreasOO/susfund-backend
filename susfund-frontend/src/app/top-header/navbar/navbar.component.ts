import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: false,
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  constructor(public router: Router) {

  }

  get isCaseView() : boolean {
    return this.router.url.split('/').pop()!=='' && this.router.url.split('/').pop()!=='cases' && this.router.url.split('/').pop()!=='login';
  }

  get isLoggedIn() : boolean{
    return this.router.url.split('/').pop()!=='login';
  }

  logOut(){
    const token = localStorage.getItem('tokenBearer');
    if(token){
      localStorage.removeItem('tokenBearer');
      this.router.navigate(['/login']);
    }
  }
}
