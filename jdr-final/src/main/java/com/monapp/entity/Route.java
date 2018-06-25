package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

public class Route {
	private int id;
	private List<Integer> directions = new ArrayList<Integer>();
	
	public Route() {}
	public Route(List<Integer> directions) {
		this.directions = directions;
	}
}
