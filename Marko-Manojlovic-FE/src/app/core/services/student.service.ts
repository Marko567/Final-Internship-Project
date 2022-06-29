import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Student } from '../models';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) {

  }
  public getStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(`${environment.serverUrl}/students/all`);
  }
}
