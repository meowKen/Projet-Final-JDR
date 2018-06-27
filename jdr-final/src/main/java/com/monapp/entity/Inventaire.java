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

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Inventaire {

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
	
	
	private Inventaire() {}
	
	private Inventaire(int taille) {
		this.taille = taille;
	}

	
	
	
}
