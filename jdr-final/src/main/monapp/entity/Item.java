package com.monapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table
public class Item {

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
	private String description;
	
	@Column
	@JsonView(Views.Common.class)
	private String imageLink;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="inventaire")
	@JsonView(Views.Item.class)
	private Inventaire inventaire;
	
	// CONSTRUCTEUR
	
	public Item () {}
	public Item (String nom, String description, String imageLink) {
		this.nom = nom;
		this.description = description;
		this.imageLink = imageLink;
	}
	
	// Getter et Setter
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public Inventaire getInventaire() {
		return inventaire;
	}
	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}
	
	
	
}
