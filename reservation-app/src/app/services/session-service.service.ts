import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Session, User} from "../model/Reservations.model";
import {environment} from "../environments/environment.development";

@Injectable({
  providedIn: 'root'
})
export class SessionServiceService {

  constructor(private http : HttpClient) { }


  public getAllSessions():Observable<Array<Session>>{
    return this.http.get<Array<Session>>(`${environment.backendHost}/sessions`);
  }

  public getAllUsers():Observable<Array<User>> {
    return this.http.get<Array<User>>(`${environment.backendHost}/users`);
  }

  public saveSession(formData : any):Observable<Session>{
    return this.http.post<Session>(`${environment.backendHost}/session`,formData);
  }

  public saveeUser(formData : any) {
    return this.http.post<User>(`${environment.backendHost}/user`,formData);
  }
}
