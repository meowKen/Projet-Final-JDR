import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Item} from './item';

@Injectable()
export class ItemService {

  baseUrl = 'http://localhost:8090/jdr/items';

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
  add(it: Item): Observable<any>{
    return this.http.post(this.baseUrl, it);
  }

  //update
  update(it: Item) : Observable<any>{
    return this.http.put(this.baseUrl, it)
  }

  //delete
  delete(id:number) : Observable<any>{
    return this.http.delete(this.baseUrl+''+id);
  }
}
