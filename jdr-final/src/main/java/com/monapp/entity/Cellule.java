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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Cellule {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cellule")
	@JsonView(Views.Common.class)private int id;
	
	@Column
	@NotNull
	@JsonView(Views.Common.class)
	private String sceneDescription;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="routesPossible")
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

	@Column
	@JsonView(Views.Common.class)
	private int position;
	
	@Column
	@JsonView(Views.Common.class)
	private int numeroDeCase;
	
	public Cellule() {}
	public Cellule(String sceneDescription, Route routesPossible, String imageLien, int coordonneX, int coordonneY, int position, int numeroDeCase) {
		this.sceneDescription = sceneDescription;
		this.routesPossible = routesPossible;
		this.imageLien = imageLien;
		this.coordoneeX = coordonneX;
		this.coordoneeY = coordonneY;
		this.position = position;
		this.numeroDeCase = numeroDeCase;
	}
	@Override
	public String toString() {
		return "Cellule [id=" + id + ", sceneDescription=" + sceneDescription + ", imageLien="
				+ imageLien + ", coordoneeX=" + coordoneeX + ", coordoneeY=" + coordoneeY + ", position=" + position
				+ ", numeroDeCase=" + numeroDeCase + "]";
	}
	
	public void addRoute(Route route) {
		route.addCellule(this);
		this.setRoutesPossible(route);
	}
	
	
	
}
