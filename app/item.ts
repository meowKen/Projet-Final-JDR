import {Inventaire} from './inventaire';

export class Item {

  constructor(
                private _id: number,
                private _nom: string,
                private _description: string,
                private _imageLink: string,
                private _inventaire: Inventaire) {}


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get nom(): string {
    return this._nom;
  }

  set nom(value: string) {
    this._nom = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  get imageLink(): string {
    return this._imageLink;
  }

  set imageLink(value: string) {
    this._imageLink = value;
  }

  get inventaire(): Inventaire {
    return this._inventaire;
  }

  set inventaire(value: Inventaire) {
    this._inventaire = value;
  }
}
