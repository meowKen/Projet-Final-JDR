import {Component, Input, OnInit} from '@angular/core';
import {Plateau} from '../plateau';

@Component({
  selector: 'app-plateau-edit',
  templateUrl: './plateau-edit.component.html',
  styleUrls: ['./plateau-edit.component.css']
})
export class PlateauEditComponent implements OnInit {

  plateau: Plateau;
  hauteur: number;
  largeur: number;
  constructor() { }

  ngOnInit() {
  }

  receiveMessage(evt) {
    this.plateau = evt.plat;
    this.hauteur = evt.hauteur;
    this.largeur = evt.largeur;
  }
}
