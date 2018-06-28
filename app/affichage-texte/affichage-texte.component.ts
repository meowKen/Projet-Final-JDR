import { Component, OnInit } from '@angular/core';
import {CelluleService} from '../cellule.service';
import {RouteService} from '../route.service';
import {PlateauService} from '../plateau.service';
import {forEach} from '@angular/router/src/utils/collection';
import {Cellule} from '../cellule';
import {DirectionService} from '../direction.service';

@Component({
  selector: 'app-affichage-texte',
  templateUrl: './affichage-texte.component.html',
  styleUrls: ['./affichage-texte.component.css']
})
export class AffichageTexteComponent implements OnInit {
  cellulesList = [];
  routeList = [];
  plateau = [];
  constructor(private celluleService: CelluleService,
              private routeService: RouteService,
              private plateauService: PlateauService,
              private directionService: DirectionService) {
    this.plateauService.getOne(1).subscribe(
      lePlateau => this.plateau = lePlateau
    );
    this.celluleService.getByPlateau(1).subscribe(
      listeDesCellules => { console.log('111111111'); this.cellulesList = listeDesCellules; console.log('2222222222222222');
        this.cellulesList.forEach(function(object) {
          console.log('333333333');
          routeService.getOne(object.routesPossible.id).subscribe(
            laRoute => {
              console.log(this.routeList);
              this.routeList.add(laRoute);
            });
        });
        console.log('yoyoyoyoyoyoyo');
        console.log(this.routeList);
      }
    );
  }

  ngOnInit() {
  }

}
