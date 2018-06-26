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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="partie")
public class Partie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="plateau")
	private Plateau plateau;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="personnage")
	private Personnage personnage;
	
	@Column
	private int positionDepart;
	
	@Column
	private int positionArrivee;
	
	public Partie() {}
	public Partie(Plateau plateau, Personnage personnage, int positionDepart, int positionArrivee) {
		this.plateau = plateau;
		this.personnage = personnage;
		this.positionDepart = positionDepart;
		this.positionArrivee = positionArrivee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Plateau getPlateau() {
		return plateau;
	}
	public void setPlateau(Plateau plateaus) {
		this.plateau = plateau;
	}
	public Personnage getPersonnage() {
		return personnage;
	}
	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}
	public int getPositionDepart() {
		return positionDepart;
	}
	public void setPositionDepart(int positionDepart) {
		this.positionDepart = positionDepart;
	}
	public int getPositionArrivee() {
		return positionArrivee;
	}
	public void setPositionArrivee(int positionArrivee) {
		this.positionArrivee = positionArrivee;
	}
	
	
}
