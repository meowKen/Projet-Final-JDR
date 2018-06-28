import {Component, EventEmitter, OnInit, Output} from '@angular/core';
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
  @Output() output = new EventEmitter()
  constructor(private fb: FormBuilder,
              private ps: PlateauService) { }

  ngOnInit() {
    this.plateauForm = this.fb.group({});
  }
  submitForm() {
    this.formSubmitted = true;
    if (this.plateauForm.valid) {
      let tab;
      this.ps.generate(this.plateau, this.largeur.value, this.hauteur.value).subscribe(
        plateauFromDb => {
          this.plateau = plateauFromDb;
           tab = { 'plat':this.plateau,'hauteur':this.hauteur.value, 'largeur':this.largeur.value};
        },
        () => {},
        () => {
          this.output.emit(tab);
        }
      );
    }
  }
}
