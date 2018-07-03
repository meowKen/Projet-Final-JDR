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

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Personnage {

	// CREATION DES VARIABLES :
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	@Column
	@JsonView(Views.Common.class)
	private String nom;
	
	@Column
	@JsonView(Views.Common.class)
	private String job;
	
	@Column
	@JsonView(Views.Common.class)
	private int positionActuelle;
	
	@OneToOne (fetch=FetchType.EAGER)
	@JoinColumn(name ="inventaire")
	@JsonView(Views.Utilisateur.class)
	private Inventaire inventaire;
	
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name ="utilisateur")
	@JsonView(Views.Utilisateur.class)
	private Utilisateur utilisateur;
	
	//CONSTRUCTEUR
	
	private Personnage() {}
	
	private Personnage(String nom, String job, int positionActuelle) {
		this.nom = nom;
		this.job = job;
		this.positionActuelle = positionActuelle;
	}

	

	
}
