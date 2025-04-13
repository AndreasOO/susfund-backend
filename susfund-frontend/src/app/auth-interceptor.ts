import {HttpErrorResponse, HttpEvent, HttpHandlerFn, HttpRequest, HttpResponse} from '@angular/common/http';
import {Observable, tap} from 'rxjs';
import { inject } from '@angular/core';
import {Router} from '@angular/router';

export function loggingInterceptor(req: HttpRequest<unknown>, next: HttpHandlerFn): Observable<HttpEvent<unknown>> {

  const router= inject(Router);

  const token = localStorage.getItem('tokenBearer');

  if (!token && !req.url.includes('login')) {
    router.navigate(['/login']);
  }

  const authRequest = token ? req.clone({
    setHeaders: {
      Authorization: token!},
  }) : req;

  return next(authRequest).pipe(
    tap(
      event => {
        if (event instanceof HttpResponse){
          if (router.url.includes('login')) {
            router.navigate(['/cases']);
          }
        }
      },
      error => {
        if (error instanceof HttpErrorResponse) {
          if (error.status == 401) {
            console.log("Unauthorized from response interceptor");
            router.navigate(['/login']);
          }
          console.log('request failed');
        }
      }
    ));
}

