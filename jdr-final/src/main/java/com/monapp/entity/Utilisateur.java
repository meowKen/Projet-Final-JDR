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

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Utilisateur {

	
	// CREATION DES VARIABLES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	@Column
	@JsonView(Views.Common.class)
	private String nom;
	
	@Column
	@JsonView(Views.Common.class)
	private String mail;
	
	@Column
	@JsonView(Views.Common.class)
	private String mdp;
	
//	@ManyToOne
//	@JsonView(Views.Utilisateur.class)
//	@JoinColumn(name="parties", fetch=FetchType.EAGER)
//	private List<Partie> parties = new ArrayList<Partie>();
	
	@OneToMany(mappedBy="utilisateur", fetch=FetchType.EAGER)
	@JsonView(Views.Utilisateur.class)
	private List<Personnage> personnages = new ArrayList<Personnage>();
	
	
	// CONSTRUCTEUR
	
	private Utilisateur() {}
	
	private Utilisateur(String nom, String mail, String mdp) {
		this.nom = nom;
		this.mail = mail;
		this.mdp = mdp;
		}

	
	// GETTER ET SETTER
	
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

//	public List<Partie> getParties() {
//		return parties;
//	}
//
//	public void setParties(List<Partie> parties) {
//		this.parties = parties;
//	}

	public List<Personnage> getPersonnages() {
		return personnages;
	}

	public void setPersonnages(List<Personnage> personnages) {
		this.personnages = personnages;
	}
	
	
	
}
