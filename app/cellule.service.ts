import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cellule} from './cellule';

@Injectable()
export class CelluleService {

  baseUrl = 'http://localhost:8090/jdr/cellules';

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
  add(cell: Cellule): Observable<any>{
    return this.http.post(this.baseUrl, cell);
  }

  //update
  update(cell: Cellule) : Observable<any>{
    return this.http.put(this.baseUrl, cell)
  }

  //delete
  delete(id:number) : Observable<any>{
    return this.http.delete(this.baseUrl+''+id);
  }
}
