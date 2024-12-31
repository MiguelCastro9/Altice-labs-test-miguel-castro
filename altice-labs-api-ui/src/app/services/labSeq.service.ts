import { environment } from '../environments/environment';
import { LabSeq } from './../models/LabSeq';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LabSeqService {

  constructor(private http: HttpClient) {}

  labSeq(n: number) {
    return this.http.get<LabSeq>(`${environment.API_URL}/labseq/${n}`);
  }
}