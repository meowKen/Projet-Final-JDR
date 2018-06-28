import {Component, Input, OnInit, SimpleChange} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {PlateauService} from '../plateau.service';
import {Plateau} from '../plateau';
import {Cellule} from '../cellule';

@Component({
  selector: 'app-plateau-route-edit',
  templateUrl: './plateau-route-edit.component.html',
  styleUrls: ['./plateau-route-edit.component.css']
})
export class PlateauRouteEditComponent implements OnInit {
  constructor() { }

  @Input() plateau: Plateau;
  @Input() hauteur: number;
  @Input() largeur: number;

  matrice : Array<Array<Cellule>>;


  ngOnInit() {
    this.matrice = this.makeMatrice();
  }

  makeMatrice() : Array<Array<Cellule>> {
   const arrayTemp: Array<Cellule> = new Array();
    const arrayFinal: Array<Array<Cellule>> = new Array();
    let indice: number = 0;
    for (let i = 0; i < this.hauteur; i++) {
      for (let j = 0; j < this.largeur; j++) {
        arrayTemp.push(this.plateau.cellules[indice++]);
      }
      arrayFinal.push(arrayTemp.concat());
      arrayTemp.splice(0, arrayTemp.length);
    }
    return arrayFinal;
    }
  }
