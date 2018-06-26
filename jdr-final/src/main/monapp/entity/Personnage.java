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

@Entity
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
	@JsonView(Views.Inventaire.class)
	private Inventaire inventaire;
	
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name ="utilisateur")
	@JsonView(Views.Inventaire.class)
	private Utilisateur utilisateur;
	
	//CONSTRUCTEUR
	
	private Personnage() {}
	
	private Personnage(String nom, String job, int positionActuelle) {
		this.nom = nom;
		this.job = job;
		this.positionActuelle = positionActuelle;
	}

	// GETTER ET SETTER :
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getPositionActuelle() {
		return positionActuelle;
	}

	public void setPositionActuelle(int positionActuelle) {
		this.positionActuelle = positionActuelle;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

	
}
