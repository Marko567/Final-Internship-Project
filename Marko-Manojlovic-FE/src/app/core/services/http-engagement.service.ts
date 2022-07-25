import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Engagement } from '../models';

@Injectable({
  providedIn: 'root'
})
export class HttpEngagementService {

  constructor(private httpClient: HttpClient) { }

  saveEngagements(engagements: Engagement[]) {
    return this.httpClient.post(`${environment.serverUrl}/engagements`, engagements);
  }
}
