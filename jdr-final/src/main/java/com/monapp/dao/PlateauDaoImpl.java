package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.entity.Plateau;

@Transactional
@Repository
public class PlateauDaoImpl implements PlateauDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Plateau findByPrimaryKey(Integer id) {
		return em.find(Plateau.class, id);
	}

	@Override
	public List<Plateau> findAll() {
		String querystring = "SELECT p FROM Plateau p ORDER BY id";
		Query query = em.createQuery(querystring);
		List<Plateau> list = query.getResultList();
		return list;
	}

	@Override
	public Plateau save(Plateau entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Plateau entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public Plateau update(Plateau entity) {
		return em.merge(entity);
	}


}
