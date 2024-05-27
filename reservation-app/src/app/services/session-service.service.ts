import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Session} from "../model/Reservations.model";
import {environment} from "../environments/environment.development";

@Injectable({
  providedIn: 'root'
})
export class SessionServiceService {

  constructor(private http : HttpClient) { }


  public getAllSessions():Observable<Array<Session>>{
    return this.http.get<Array<Session>>(`${environment.backendHost}/sessions`);
  }
}
