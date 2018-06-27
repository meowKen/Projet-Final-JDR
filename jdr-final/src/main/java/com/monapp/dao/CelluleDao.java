package com.monapp.dao;

import java.util.Set;

import com.monapp.entity.Cellule;

public interface CelluleDao extends GenericDao<Cellule, Integer>{

	Set<Cellule> findByPlateau(int id_plateau);
}
