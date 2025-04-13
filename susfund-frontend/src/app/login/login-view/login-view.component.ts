import { Component } from '@angular/core';
import {CasesFetcherService} from '../../cases-services/cases-fetcher.service';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-login-view',
  standalone: false,
  templateUrl: './login-view.component.html',
  styleUrl: './login-view.component.css'
})
export class LoginViewComponent {

  constructor(private fetcher:CasesFetcherService){

  }

  public onSubmit(form:NgForm){
    const loginInfo = {
      username: form.value.username,
      password: form.value.password
    }

    this.fetcher.login(loginInfo).subscribe( tokenBearer => {
      localStorage.setItem('tokenBearer', tokenBearer.token);
    })

  }

}
