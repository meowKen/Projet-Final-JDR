import {Route} from './route';
import {Plateau} from './plateau';

export class Cellule {

  constructor(  private _id: number,
                private _plateau: Plateau,
                private _RoutePossible: Route,
                private _imageLien: string,
                private _position: number,
                private _coordonneX: number,
                private _coordonneY: number) {}


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get plateau(): Plateau {
    return this._plateau;
  }

  set plateau(value: Plateau) {
    this._plateau = value;
  }

  get RoutePossible(): Route {
    return this._RoutePossible;
  }

  set RoutePossible(value: Route) {
    this._RoutePossible = value;
  }

  get imageLien(): string {
    return this._imageLien;
  }

  set imageLien(value: string) {
    this._imageLien = value;
  }

  get position(): number {
    return this._position;
  }

  set position(value: number) {
    this.position = value;
  }

  get coordonneX(): number {
    return this._coordonneX;
  }

  set coordonneX(value: number) {
    this._coordonneX = value;
  }

  get coordonneY(): number {
    return this._coordonneY;
  }

  set coordonneY(value: number) {
    this._coordonneY = value;
  }
}
