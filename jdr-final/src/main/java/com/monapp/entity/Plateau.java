package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="plateau")
public class Plateau {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	@OneToMany(mappedBy="plateau")
	@JsonView(Views.Plateau.class)
	private List<Cellule> cellules = new ArrayList<Cellule>();
	
	@OneToMany(mappedBy="plateau")
	@JsonView(Views.Plateau.class)
	private List<Partie> parties;
	
	@Column
	@NotNull
	@JsonView(Views.Common.class)
	private int largeur;
	
	@Column
	@NotNull
	@JsonView(Views.Common.class)
	private int hauteur;
	
	public Plateau() {}
	
	public Plateau(List<Cellule> cellules, List<Partie> parties, int largeur, int hauteur) {
		this.cellules = cellules;
		this.parties = parties;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Cellule> getCellules() {
		return cellules;
	}

	public void setCellules(List<Cellule> cellules) {
		this.cellules = cellules;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public List<Partie> getParties() {
		return parties;
	}

	public void setParties(List<Partie> parties) {
		this.parties = parties;
	}
	
	
	
	
	
}
