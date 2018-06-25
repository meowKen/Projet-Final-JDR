package com.monapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.monapp.enumeration.PandaContinent;

@Entity
@Table(name="pandadata")
public class Panda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column
	private int age;
	
	@NotNull
	@Column
	private String nom;
	
	@NotNull
	@Column
	@Enumerated
	private PandaContinent origine;
	
	public Panda() {}
	public Panda(int age, String nom, PandaContinent origine) {
		this.age = age;
		this.nom = nom;
		this.origine = origine;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public PandaContinent getOrigine() {
		return origine;
	}
	public void setOrigine(PandaContinent origine) {
		this.origine = origine;
	}
	@Override
	public String toString() {
		return "Panda [id=" + id + ", age=" + age + ", nom=" + nom + ", origine=" + origine + "]";
	}
	
	
}
