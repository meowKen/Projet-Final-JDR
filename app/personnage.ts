import {Utilisateur} from './utilisateur';
import {Inventaire} from './inventaire';

export class Personnage {

 constructor ( private _id: number,
  private _nom: string,
  private _job: string,
  private _positionActuelle: number,
  private _inventaire: Inventaire,
  private _utilisateur: Utilisateur ){}


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

  get job(): string {
    return this._job;
  }

  set job(value: string) {
    this._job = value;
  }

  get positionActuelle(): number {
    return this._positionActuelle;
  }

  set positionActuelle(value: number) {
    this._positionActuelle = value;
  }

  get inventaire(): Inventaire {
    return this._inventaire;
  }

  set inventaire(value: Inventaire) {
    this._inventaire = value;
  }

  get utilisateur(): Utilisateur {
    return this._utilisateur;
  }

  set utilisateur(value: Utilisateur) {
    this._utilisateur = value;
  }
}
