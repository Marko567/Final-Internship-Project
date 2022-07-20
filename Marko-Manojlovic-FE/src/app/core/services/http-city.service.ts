import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { City } from '../models';

@Injectable({
  providedIn: 'root'
})
export class HttpCityService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<City[]> {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');

    return this.httpClient.get<City[]>(`${environment.serverUrl}/cities/all`, { headers });
  }

  getById(zipCode: number) {
    return this.httpClient.get<City>(`${environment.serverUrl}/cities/${zipCode}`);
  }
}
