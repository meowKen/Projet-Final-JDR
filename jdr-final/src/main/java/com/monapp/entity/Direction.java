package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="direction")
public class Direction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_direction")
	private int id;
	
	@Column
	@NotNull
	private int envoieVers;
	
	@Column
	@ManyToMany(mappedBy="directions", fetch=FetchType.EAGER)
	private List<Route> routes = new ArrayList<Route>();
	
	public Direction() {}
	public Direction(int envoieVers) {
		this.envoieVers = envoieVers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEnvoieVers() {
		return envoieVers;
	}
	public void setEnvoieVers(int envoieVers) {
		this.envoieVers = envoieVers;
	}
	
	
}
