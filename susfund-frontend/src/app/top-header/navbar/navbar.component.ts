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
    return this.router.url.split('/').pop()!=='' && this.router.url.split('/').pop()!=='cases';
  }
}
