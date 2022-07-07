import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ExamPeriodStatus } from '../models';

@Injectable({
  providedIn: 'root'
})
export class HttpExamPeriodStatusService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<ExamPeriodStatus[]> {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');

    return this.httpClient.get<ExamPeriodStatus[]>(`${environment.serverUrl}/exam-period-statuses/all`, { headers });
  }
}
