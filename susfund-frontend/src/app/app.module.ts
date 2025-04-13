import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {TopHeaderModule} from './top-header/top-header.module';
import {FooterModule} from './footer/footer.module';
import {CaseViewModule} from './case-view/case-view.module';
import {CasesListModule} from './cases-list/cases-list.module';
import {CasesServicesModule} from './cases-services/cases-services.module';
import {provideHttpClient, withInterceptors} from '@angular/common/http';
import {loggingInterceptor} from './auth-interceptor';
import {LoginModule} from './login/login.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    CaseViewModule, // includes child routing, must be imported before AppRoutingModule
    AppRoutingModule,
    TopHeaderModule,
    FooterModule,
    CasesListModule,
    CasesServicesModule,
    LoginModule
  ],
  providers: [
    provideHttpClient(
      withInterceptors([loggingInterceptor])
    )
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
