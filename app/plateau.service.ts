import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Plateau} from './plateau';
import {Observable} from 'rxjs';

@Injectable()
export class PlateauService {

  constructor(private http: HttpClient) {
  }

  baseUrl = 'http://localhost:8090/jdr/plateaus/';

  //readAll / findAll
  list(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  //read / findById
  getOne(id: number): Observable<any>{
    return this.http.get(this.baseUrl + '' + id);
  }

  //create
  add(plateau: Plateau): Observable<any>{
    return this.http.post(this.baseUrl, plateau);
  }

  //create and generate
  generate(plateau: Plateau, largeur: number, hauteur: number): Observable<any>{
    return this.http.post(this.baseUrl + largeur + '/' + hauteur, plateau);
  }

  //update
  update(plateau: Plateau): Observable<any>{
    return this.http.put(this.baseUrl, plateau);
  }

  //delete
  delete(id:number) : Observable<any>{
    return this.http.delete(this.baseUrl + '' + id);
  }
}
