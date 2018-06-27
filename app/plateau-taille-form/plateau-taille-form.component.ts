import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators, FormControl} from '@angular/forms';
import {PlateauService} from '../plateau.service';
import {Plateau} from '../plateau';

@Component({
  selector: 'app-plateau-taille-form',
  templateUrl: './plateau-taille-form.component.html',
  styleUrls: ['./plateau-taille-form.component.css']
})
export class PlateauTailleFormComponent implements OnInit {

  plateauForm: FormGroup;
  formSubmitted = false;
  largeur = new FormControl();
  hauteur = new FormControl();
  plateau: Plateau;
  constructor(private fb: FormBuilder,
              private ps: PlateauService) { }

  ngOnInit() {
    this.plateauForm = this.fb.group({});
  }
  submitForm() {
    console.log('formulaire envoyé');
    console.log(this.plateauForm.value);
    console.log(this.plateauForm.valid);
    console.log(this.largeur);
    this.formSubmitted = true;
    if (this.plateauForm.valid) {
      this.ps.generate(this.plateau, this.largeur.value, this.hauteur.value).subscribe(
        plateauFromDb => {
          console.log(plateauFromDb);
        }
      );
    }
  }
}
