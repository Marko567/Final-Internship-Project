import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { PageDto, PageRequest, Professor } from '../models';

@Injectable({
  providedIn: 'root'
})
export class HttpProfessorService {

  constructor(private httpClient: HttpClient) { }

  public getProfessors(): Observable<Professor[]> {

    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');

    return this.httpClient.get<Professor[]>(`${environment.serverUrl}/professors/all`, { headers });
  }

  getByPage(pageRequest: PageRequest) {
    const params = new HttpParams()
      .set('pageNo', pageRequest.pageNo - 1)
      .set('pageSize', pageRequest.pageSize)
      .set('sortBy', pageRequest.sortBy)
      .set('sortOrder', pageRequest.sortOrder);

    return this.httpClient.get<PageDto<Professor>>(`${environment.serverUrl}/professors/filter`, {params});
  }

  deleteProfessor(professor: Professor) {
    return this.httpClient.delete<string>(`${environment.serverUrl}/professors/${professor.professorId}`, {responseType: 'text' as 'json'});
  }

  updateProfessor(professor: Professor) {
    return this.httpClient.put<Professor>(`${environment.serverUrl}/professors`, professor);
  }

  getById(professorId: number) {
    return this.httpClient.get<Professor>(`${environment.serverUrl}/professors/${professorId}`);
  }

  saveProfessor(professor: Professor) {
    return this.httpClient.post<Professor>(`${environment.serverUrl}/professors`, professor);
  }

  getProfessorsEngagedOnSubject(subjectId: number) {
    return this.httpClient.get<Professor[]>(`${environment.serverUrl}/professors/engagedOn/${subjectId}`);
  }
}
