import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Utilisateur} from './utilisateur';
import {Observable} from 'rxjs';

@Injectable()
export class UtilisateurService {

  constructor(private http: HttpClient) {}

  baseUrl = 'http://localhost:8090/jdr/utilisateurs';

  //readAll / findAll
  list(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  //read / findById
  getOne(id: number) : Observable<any>{
    return this.http.get(this.baseUrl+''+id);
  }

  //create
  add(user: Utilisateur): Observable<any>{
    return this.http.post(this.baseUrl, user);
  }

  //update
  update(user: Utilisateur) : Observable<any>{
    return this.http.put(this.baseUrl, user)
  }

  //delete
  delete(id:number) : Observable<any>{
    return this.http.delete(this.baseUrl+''+id);
  }
}
