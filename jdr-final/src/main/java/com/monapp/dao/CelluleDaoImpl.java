package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.entity.Cellule;

@Transactional
@Repository
public class CelluleDaoImpl implements CelluleDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Cellule findByPrimaryKey(Integer id) {
		return em.find(Cellule.class, id);
	}

	@Override
	public List<Cellule> findAll() {
		String querystring = "SELECT p FROM Cellule p ORDER BY id";
		Query query = em.createQuery(querystring);
		List<Cellule> list = query.getResultList();
		return list;
	}

	@Override
	public Cellule save(Cellule entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Cellule entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public Cellule update(Cellule entity) {
		return em.merge(entity);
	}


}
