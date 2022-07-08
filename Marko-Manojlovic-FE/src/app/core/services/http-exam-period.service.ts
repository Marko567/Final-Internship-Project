import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ExamPeriod, PageDto, PageRequest } from '../models';

@Injectable({
  providedIn: 'root'
})
export class HttpExamPeriodService {
  constructor(private httpClient: HttpClient) { }

  public getExamPeriods(): Observable<ExamPeriod[]> {

    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');

    return this.httpClient.get<ExamPeriod[]>(`${environment.serverUrl}/exam-periods/all`, { headers });
  }

  getByPage(pageRequest: PageRequest) {
    const params = new HttpParams()
      .set('pageNo', pageRequest.pageNo - 1)
      .set('pageSize', pageRequest.pageSize)
      .set('sortBy', pageRequest.sortBy)
      .set('sortOrder', pageRequest.sortOrder);

    return this.httpClient.get<PageDto<ExamPeriod>>(`${environment.serverUrl}/exam-periods/filter`, {params});
  }

  deleteExamPeriod(examPeriod: ExamPeriod) {
    return this.httpClient.delete<string>(`${environment.serverUrl}/exam-periods/${examPeriod.id}`, {responseType: 'text' as 'json'});
  }

  updateExamPeriod(examPeriod: ExamPeriod) {
    return this.httpClient.put<ExamPeriod>(`${environment.serverUrl}/exam-periods`, examPeriod);
  }

  getById(examPeriodId: number) {
    return this.httpClient.get<ExamPeriod>(`${environment.serverUrl}/exam-periods/${examPeriodId}`);
  }

  saveExamPeriod(examPeriod: ExamPeriod) {
    return this.httpClient.post<ExamPeriod>(`${environment.serverUrl}/exam-periods`, examPeriod);
  }
  getActiveExamPeriod() {
    return this.httpClient.get<ExamPeriod>(`${environment.serverUrl}/exam-periods/active`);
  }
}
