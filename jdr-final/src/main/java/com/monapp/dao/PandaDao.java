package com.monapp.dao;

import java.util.List;

import com.monapp.entity.Panda;
import com.monapp.enumeration.PandaContinent;

public interface PandaDao extends GenericDao<Panda, Integer>{
	List<Panda> findByOrigine(PandaContinent origine);
}
