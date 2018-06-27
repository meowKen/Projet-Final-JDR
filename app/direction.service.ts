import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Direction} from './direction';

@Injectable()
export class DirectionService {

  baseUrl = 'http://localhost:8090/jdr/directions';

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
  add(dir: Direction): Observable<any>{
    return this.http.post(this.baseUrl, dir);
  }

  //update
  update(dir: Direction) : Observable<any>{
    return this.http.put(this.baseUrl, dir)
  }

  //delete
  delete(id:number) : Observable<any>{
    return this.http.delete(this.baseUrl+''+id);
  }
}
