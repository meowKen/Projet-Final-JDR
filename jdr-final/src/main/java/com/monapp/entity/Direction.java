package com.monapp.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name="direction")
public class Direction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_direction")
	@JsonView(Views.Common.class)
	private int id;
	
	@Column
	@NotNull
	@JsonView(Views.Common.class)
	private int envoieVers;
	
	@Column
	@ManyToMany(mappedBy="directions", fetch=FetchType.EAGER)
	@JsonView(Views.Direction.class)
	private Set<Route> routes = new HashSet<Route>();
	
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
