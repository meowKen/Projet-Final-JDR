package com.monapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
	
	
	
	
	
}
