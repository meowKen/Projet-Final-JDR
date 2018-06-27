import {Partie} from './partie';
import {Personnage} from './personnage';

export class Utilisateur {
  constructor(
    private _id: number,
    private _nom: string,
    private _mail: string,
    private _mdp: string,
    private _parties: Array<Partie>,
    private _personnages: Array<Personnage>
  ){}

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

  get mail(): string {
    return this._mail;
  }

  set mail(value: string) {
    this._mail = value;
  }

  get mdp(): string {
    return this._mdp;
  }

  set mdp(value: string) {
    this._mdp = value;
  }

  get parties(): Array<Partie> {
    return this._parties;
  }

  set parties(value: Array<Partie>) {
    this._parties = value;
  }

  get personnages(): Array<Personnage> {
    return this._personnages;
  }

  set personnages(value: Array<Personnage>) {
    this._personnages = value;
  }
}
