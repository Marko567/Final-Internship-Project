import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import { environment } from 'src/environments/environment';
import { PageDto, PageRequest, Subject } from '../models';

@Injectable({
  providedIn: 'root'
})
export class HttpSubjectService {

  constructor(private httpClient: HttpClient) {

  }
  public getSubjects(): Observable<Subject[]> {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');

    return this.httpClient.get<Subject[]>(`${environment.serverUrl}/subjects/all`, { headers });
  }

  getByPage(pageRequest: PageRequest) {
    const params = new HttpParams()
      .set('pageNo', pageRequest.pageNo - 1)
      .set('pageSize', pageRequest.pageSize)
      .set('sortBy', pageRequest.sortBy)
      .set('sortOrder', pageRequest.sortOrder);

    return this.httpClient.get<PageDto<Subject>>(`${environment.serverUrl}/subjects/filter`, {params});
  }
  deleteSubject(subject: Subject) {
    return this.httpClient.delete<string>(`${environment.serverUrl}/subjects/${subject.subjectId}`, {responseType: 'text' as 'json'});
  }

  updateSubject(subject: Subject) {
    return this.httpClient.put<Subject>(`${environment.serverUrl}/subjects`, subject);
  }

  getById(subjectId: number) {
    return this.httpClient.get<Subject>(`${environment.serverUrl}/subjects/${subjectId}`);
  }

  saveSubject(subject: Subject) {
    return this.httpClient.post<Subject>(`${environment.serverUrl}/subjects`, subject);
  }
}
