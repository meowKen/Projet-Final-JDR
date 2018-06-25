package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Inventaire {

	//CREATION DES VARIABLES :
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int taille;
	
	@OneToMany (mappedBy="inventaire")
	private List<Item> items = new ArrayList<Item>();
	
	@OneToOne (mappedBy = "inventaire")
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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
