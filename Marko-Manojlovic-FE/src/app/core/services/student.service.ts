import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { PageDto, PageRequest, Student } from '../models';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private httpClient: HttpClient) {

  }
  public getStudents(): Observable<Student[]> {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');

    return this.httpClient.get<Student[]>(`${environment.serverUrl}/students/all`, { headers });
  }

  getByPage(pageRequest: PageRequest) {
    const params = new HttpParams()
      .set('pageNo', pageRequest.pageNo - 1)
      .set('pageSize', pageRequest.pageSize)
      .set('sortBy', pageRequest.sortBy)
      .set('sortOrder', pageRequest.sortOrder);

    return this.httpClient.get<PageDto<Student>>(`${environment.serverUrl}/students/filter`, {params});
  }

  deleteStudent(student: Student) {
    return this.httpClient.delete<string>(`${environment.serverUrl}/students/${student.studentId}`, {responseType: 'text' as 'json'});
  }

  updateStudent(student: Student) {
    //console.log("Student pred odlazak na server: ", student);
    return this.httpClient.put<Student>(`${environment.serverUrl}/students`, student);
  }

  getById(studentId: number) {
    return this.httpClient.get<Student>(`${environment.serverUrl}/cities/${studentId}`);
  }
  saveStudent(student: Student) {
    return this.httpClient.post<Student>(`${environment.serverUrl}/students`, student);
  }
}
