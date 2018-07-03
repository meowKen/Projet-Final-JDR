package com.monapp.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonView;
import com.monapp.dao.CelluleDao;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Plateau {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	@OneToMany(mappedBy="plateau", fetch=FetchType.EAGER)
	@JsonView(Views.Plateau.class)
	private List<Cellule> cellules = new ArrayList<Cellule>();
	
	@OneToMany(mappedBy="plateau", fetch=FetchType.EAGER)
	@JsonView(Views.Plateau.class)
	private Set<Partie> parties;
	
	@Column
	@NotNull
	@JsonView(Views.Common.class)
	private int largeur;
	
	@Column
	@NotNull
	@JsonView(Views.Common.class)
	private int hauteur;
	
	@Column
	@JsonView(Views.Common.class)
	private int positionDepart;
	
	@Column
	@JsonView(Views.Common.class)
	private int positionArrivee;
	
	public Plateau() {}
	
	public Plateau(List<Cellule> cellules, Set<Partie> parties, int largeur, int hauteur, int positionDepart, int positionArrivee) {
		this.cellules = cellules;
		this.parties = parties;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.positionDepart = positionDepart;
		this.positionArrivee = positionArrivee;
	}
	

	public List<Cellule> voisinageN(Cellule caseEnCours) {
        int departX = caseEnCours.getCoordoneeX();
        int departY = caseEnCours.getCoordoneeY();
        List<Cellule> listeCellules = new ArrayList();
        if (caseEnCours.getCoordoneeX()>0) {
            listeCellules.add(getByCoord(departX-1, departY));
        }
        if (caseEnCours.getCoordoneeX()<largeur-1) {
            listeCellules.add(getByCoord(departX+1, departY));
        }
        if (caseEnCours.getCoordoneeY()>0) {
            listeCellules.add(getByCoord(departX, departY-1));
        }
        if (caseEnCours.getCoordoneeY()<hauteur-1) {
            listeCellules.add(getByCoord(departX, departY+1));
        }
        return listeCellules;
    }

    private Cellule getByCoord(int x, int y){
        for(Cellule c : cellules){
            if(c.getCoordoneeX() == x && c.getCoordoneeY() == y){
                return c;
            }
        }
        return null;
    }

	@Override
	public String toString() {
		return "Plateau [id=" + id + ", largeur=" + largeur + ", hauteur=" + hauteur + ", positionDepart="
				+ positionDepart + ", positionArrivee=" + positionArrivee + "]";
	}
	
    
}
