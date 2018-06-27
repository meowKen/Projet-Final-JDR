import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PlateauEditComponent } from './plateau-edit/plateau-edit.component';
import { PlateauTailleFormComponent } from './plateau-taille-form/plateau-taille-form.component';
import { PlateauRouteEditComponent } from './plateau-route-edit/plateau-route-edit.component';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {PlateauService} from './plateau.service';
import {CelluleService} from './cellule.service';
import {RouteService} from './route.service';
import {DirectionService} from './direction.service';
import {PartieService} from './partie.service';
import {PersonnageService} from './personnage.service';
import {UtilisateurService} from './utilisateur.service';
import {ItemService} from './item.service';
import {InventaireService} from './inventaire.service';

@NgModule({
  declarations: [
    AppComponent,
    PlateauEditComponent,
    PlateauTailleFormComponent,
    PlateauRouteEditComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    PlateauService,
    CelluleService,
    RouteService,
    DirectionService,
    PartieService,
    PersonnageService,
    UtilisateurService,
    ItemService,
    InventaireService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
