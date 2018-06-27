import {Plateau} from './plateau';
import {Personnage} from './personnage';
import {Utilisateur} from './utilisateur';

export class Partie {

  constructor(  private _id: number,
                private _plateau: Plateau,
                private _personnage: Personnage,
                private _positionDepart: number,
                private _positionArrivee: number,
                private _utilisateur: Utilisateur) {}


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

  get personnage(): Personnage {
    return this._personnage;
  }

  set personnage(value: Personnage) {
    this._personnage = value;
  }

  get positionDepart(): number {
    return this._positionDepart;
  }

  set positionDepart(value: number) {
    this._positionDepart = value;
  }

  get positionArrivee(): number {
    return this._positionArrivee;
  }

  set positionArrivee(value: number) {
    this._positionArrivee = value;
  }

  get utilisateur(): Utilisateur {
    return this._utilisateur;
  }

  set utilisateur(value: Utilisateur) {
    this._utilisateur = value;
  }
}
