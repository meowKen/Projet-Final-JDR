import {Route} from './route';


export class Direction {

  constructor(
    private _id: number,
    private _envoieVers: number,
    private _route: Array<Route>,
               ) {}


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get envoieVers(): number {
    return this._envoieVers;
  }

  set envoieVers(value: number) {
    this._envoieVers = value;
  }

  get route(): Array<Route> {
    return this._route;
  }

  set route(value: Array<Route>) {
    this._route = value;
  }
}
