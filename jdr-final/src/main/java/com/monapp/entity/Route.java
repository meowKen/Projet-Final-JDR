package com.monapp.entity;

import java.util.HashSet;
import java.util.Set;

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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Route {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_route")
	@JsonView(Views.Common.class)
	private int id;
	
	@Column
	@NotNull
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name = "join_route_direction",
			joinColumns = @JoinColumn(name="id_route"),
			inverseJoinColumns=@JoinColumn(name = "id_direction")
	)
	@JsonView(Views.Route.class)
	private Set<Direction> directions = new HashSet<Direction>();
	
	@OneToOne(mappedBy ="routesPossible", fetch=FetchType.EAGER)
	@JsonView(Views.Route.class)
	private Cellule cellule;
	
	public Route() {}
	public Route(Set<Direction> directions) {
		this.directions = directions;
	}
	
	public void addDirection(Direction d) {
		directions.add(d);
	}
	
	public void addCellule(Cellule cellule) {
		this.setCellule(cellule);
	}
	@Override
	public String toString() {
		return "Route [id=" + id + ", directions=" + directions + ", cellule=" + cellule + "]";
	}
	
	
}
