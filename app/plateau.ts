import {Cellule} from './cellule';

export class Plateau {
  constructor(
    private _id: number,
    private _cellules: Array<Cellule>,
    private _hauteur: number,
    private _largeur: number
  ) {}


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get cellules(): Array<Cellule> {
    return this._cellules;
  }

  set cellules(value: Array<Cellule>) {
    this._cellules = value;
  }

  get hauteur(): number {
    return this._hauteur;
  }

  set hauteur(value: number) {
    this._hauteur = value;
  }

  get largeur(): number {
    return this._largeur;
  }

  set largeur(value: number) {
    this._largeur = value;
  }
}
