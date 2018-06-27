package com.monapp.entity;


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
public class Partie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="plateau")
	@JsonView(Views.Partie.class)
	private Plateau plateau;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="personnage")
	@JsonView(Views.Partie.class)
	private Personnage personnage;
	

	
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name= "utilisateur")
	@JsonView(Views.Common.class)
	private Utilisateur utilisateur; 
	
	public Partie() {}
	public Partie(Plateau plateau, Personnage personnage) {
		this.plateau = plateau;
		this.personnage = personnage;
	}
	

	
	
}
