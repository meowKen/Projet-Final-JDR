import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Inventaire} from './inventaire';

@Injectable()
export class InventaireService {

  baseUrl = 'http://localhost:8090/jdr/inventaires';

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
  add(inv: Inventaire): Observable<any>{
    return this.http.post(this.baseUrl, inv);
  }

  //update
  update(inv: Inventaire) : Observable<any>{
    return this.http.put(this.baseUrl, inv)
  }

  //delete
  delete(id:number) : Observable<any>{
    return this.http.delete(this.baseUrl+''+id);
  }
}
