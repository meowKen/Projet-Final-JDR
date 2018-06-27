import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Partie} from './partie';

@Injectable()
export class PartieService {

  baseUrl = 'http://localhost:8090/jdr/parties';

  constructor(private http: HttpClient) {}

  //readAll / findAll
  list(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  //read / findById
  getOne(id: number) : Observable<any>{
    return this.http.get(this.baseUrl+''+id);
  }

  //create
  add(part: Partie): Observable<any>{
    return this.http.post(this.baseUrl, part);
  }

  //update
  update(part: Partie) : Observable<any>{
    return this.http.put(this.baseUrl, part)
  }

  //delete
  delete(id:number) : Observable<any>{
    return this.http.delete(this.baseUrl+''+id);
  }
}
