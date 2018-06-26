package com.monapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Personnage {

	// CREATION DES VARIABLES :
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nom;
	
	@Column
	private String job;
	
	@Column
	private int positionActuelle;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name ="inventaire")
	private Inventaire inventaire;
	
	@OneToOne(mappedBy="personnage", fetch=FetchType.EAGER)
	private Partie partie;
	
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
	

	
}
