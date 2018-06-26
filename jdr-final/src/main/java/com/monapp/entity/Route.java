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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="route")
public class Route {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_route")
	private int id;
	
	@Column
	@NotNull
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name = "join_route_direction",
			joinColumns = @JoinColumn(name="id_route"),
			inverseJoinColumns=@JoinColumn(name = "id_direction")
	)
	private List<Direction> directions = new ArrayList<Direction>();
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cellule")
	private Cellule cellule;
	
	public Route() {}
	public Route(List<Direction> directions) {
		this.directions = directions;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Direction> getDirections() {
		return directions;
	}
	public void setDirections(List<Direction> directions) {
		this.directions = directions;
	}
	
	
}
