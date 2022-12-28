import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from '../models/login';
import { map } from 'rxjs';


@Injectable()
export class AuthService {

private apiUrl = 'oauth/login';
  isLoggedIn: any;

  constructor( private http: HttpClient ) {}

  login(email: string, password: string) {
    return this.http.post<Login>(`${this.apiUrl}`, { email, password })
        .pipe(map((login: any) => {
            return login;
        }));
}
}
