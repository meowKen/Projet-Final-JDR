package com.monapp.entity;

import java.util.HashSet;
import java.util.Set;

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
	
	@OneToMany(mappedBy="plateau", fetch=FetchType.EAGER)
	@JsonView(Views.Plateau.class)
	private Set<Cellule> cellules = new HashSet<Cellule>();
	
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
	
	public Plateau(Set<Cellule> cellules, Set<Partie> parties, int largeur, int hauteur, int positionDepart, int positionArrivee) {
		this.cellules = cellules;
		this.parties = parties;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.positionDepart = positionDepart;
		this.positionArrivee = positionArrivee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Cellule> getCellules() {
		return cellules;
	}

	public void setCellules(Set<Cellule> cellules) {
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

	public Set<Partie> getParties() {
		return parties;
	}

	public void setParties(Set<Partie> parties) {
		this.parties = parties;
	}
	
	public int getPositionDepart() {
		return positionDepart;
	}
	public void setPositionDepart(int positionDepart) {
		this.positionDepart = positionDepart;
	}
	public int getPositionArrivee() {
		return positionArrivee;
	}
	public void setPositionArrivee(int positionArrivee) {
		this.positionArrivee = positionArrivee;
	}
	
	
	
}
