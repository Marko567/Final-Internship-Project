import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserLoginData } from '../models';

@Injectable({
  providedIn: 'root'
})
export class HttpAuthService {

  constructor(private httpClient: HttpClient) {
  }

  login(userlogin: {username: string, password: string}): Observable<UserLoginData> {

    const params = new URLSearchParams();
    params.set("username", userlogin.username);
    params.set("password", userlogin.password);

    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/x-www-form-urlencoded');

    return this.httpClient.post<UserLoginData>('http://localhost:8080/auth/login', params, { headers,});

  }
}
