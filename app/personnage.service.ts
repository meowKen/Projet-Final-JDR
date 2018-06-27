import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Personnage} from './personnage';
import {Observable} from 'rxjs';

@Injectable()
export class PersonnageService {

  constructor(private http: HttpClient) {
  }

  baseUrl = 'http://localhost:8090/jdr/personnages';

  //readAll / findAll
  list(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  //read / findById
  getOne(id: number) : Observable<any>{
    return this.http.get(this.baseUrl+''+id);
  }

  //create
  add(perso: Personnage): Observable<any>{
    return this.http.post(this.baseUrl, perso);
  }

  //update
  update(perso: Personnage) : Observable<any>{
    return this.http.put(this.baseUrl, perso)
  }

  //delete
  delete(id:number) : Observable<any>{
    return this.http.delete(this.baseUrl+''+id);
  }
}
