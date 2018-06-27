import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Route} from './route';
import {Observable} from 'rxjs';

@Injectable()
export class RouteService {

  constructor(private http: HttpClient) {
  }

  baseUrl = 'http://localhost:8090/jdr/routes';

  //readAll / findAll
  list(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  //read / findById
  getOne(id: number) : Observable<any>{
    return this.http.get(this.baseUrl+''+id);
  }

  //create
  add(route: Route): Observable<any>{
    return this.http.post(this.baseUrl, route);
  }

  //update
  update(route: Route) : Observable<any>{
    return this.http.put(this.baseUrl, route)
  }

  //delete
  delete(id:number) : Observable<any>{
    return this.http.delete(this.baseUrl+''+id);
  }
}
