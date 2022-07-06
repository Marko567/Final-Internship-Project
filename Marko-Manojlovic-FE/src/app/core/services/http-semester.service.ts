import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Semester } from '../models';

@Injectable({
  providedIn: 'root'
})
export class HttpSemesterService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Semester[]> {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');

    return this.httpClient.get<Semester[]>(`${environment.serverUrl}/semesters/all`, { headers });
  }
}
