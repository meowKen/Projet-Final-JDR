package com.monapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="cellule")
public class Cellule {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cellule")
	@JsonView(Views.Common.class)
	private int id;
	
	@Column
	@NotNull
	@JsonView(Views.Common.class)
	private String sceneDescription;
	
	@OneToOne(mappedBy="cellule", fetch=FetchType.EAGER)
	@JsonView(Views.Cellule.class)
	private Route routesPossible; 
	
	@ManyToOne
    @JoinColumn(name="plateau")
    private Plateau plateau;
	
	@Column
	@JsonView(Views.Common.class)
	private String imageLien;
	
	@Column
	@NotNull
	@JsonView(Views.Common.class)
	private int coordoneeX;
	
	@Column
	@NotNull
	@JsonView(Views.Common.class)
	private int coordoneeY;

	
	public Cellule() {}
	public Cellule(String sceneDescription, Route routesPossible, String imageLien, int coordonneX, int coordonneY) {
		this.sceneDescription = sceneDescription;
		this.routesPossible = routesPossible;
		this.imageLien = imageLien;
		this.coordoneeX = coordonneX;
		this.coordoneeY = coordonneY;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSceneDescription() {
		return sceneDescription;
	}
	public void setSceneDescription(String sceneDescription) {
		this.sceneDescription = sceneDescription;
	}
	public Route getRoutesPossible() {
		return routesPossible;
	}
	public void setRoutesPossible(Route routesPossible) {
		this.routesPossible = routesPossible;
	}
	public String getImageLien() {
		return imageLien;
	}
	public void setImageLien(String imageLien) {
		this.imageLien = imageLien;
	}
	public int getCoordoneeX() {
		return coordoneeX;
	}
	public void setCoordoneeX(int coordoneeX) {
		this.coordoneeX = coordoneeX;
	}
	public int getCoordoneeY() {
		return coordoneeY;
	}
	public void setCoordoneeY(int coordoneeY) {
		this.coordoneeY = coordoneeY;
	}
	public Plateau getPlateau() {
		return plateau;
	}
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
	
	
}
