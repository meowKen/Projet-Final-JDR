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

@Entity
@Table(name="cellule")
public class Cellule {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cellule")
	private int id;
	
	@Column
	@NotNull
	private String sceneDescription;
	
	@OneToOne(mappedBy="cellule", fetch=FetchType.EAGER)
	private Route routesPossible; 
	
	@Column
	private String imageLien;
	
	@Column
	@NotNull
	private int coordoneeX;
	
	@Column
	@NotNull
	private int coordoneeY;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="plateau")
	private Plateau plateau;

	
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
