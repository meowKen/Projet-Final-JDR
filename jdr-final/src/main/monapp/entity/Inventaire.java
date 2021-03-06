package com.monapp.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table
public class Inventaire {

	//CREATION DES VARIABLES :
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	@Column
	@JsonView(Views.Common.class)
	private int taille;
	
	@OneToMany (mappedBy="inventaire", fetch=FetchType.EAGER)
	@JsonView(Views.Inventaire.class)
	private Set<Item> items = new HashSet<Item>();
	
	@OneToOne (mappedBy = "inventaire", fetch=FetchType.EAGER)
	@JsonView(Views.Inventaire.class)
	private Personnage personnage;
	
	// CONSTRUCTEURS :
	
	private Inventaire() {}
	
	private Inventaire(int taille) {
		this.taille = taille;
	}

	//GETTER ET SETTER :
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	
}
