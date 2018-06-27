import {Personnage} from './personnage';
import {Item} from './item';


export class Inventaire {

  constructor(
    private _id: number,
    private _taille: number,
    private _items: Array<Item>,
    private _personnage: Personnage
               ) {}


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get taille(): number {
    return this._taille;
  }

  set taille(value: number) {
    this._taille = value;
  }

  get items(): Array<Item> {
    return this._items;
  }

  set items(value: Array<Item>) {
    this._items = value;
  }

  get personnage(): Personnage {
    return this._personnage;
  }

  set personnage(value: Personnage) {
    this._personnage = value;
  }
}
