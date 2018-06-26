package com.monapp.dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.entity.Direction;

@Transactional
@Repository
public class DirectionDaoImpl implements DirectionDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Direction findByPrimaryKey(Integer id) {
		return em.find(Direction.class, id);
	}

	@Override
	public Set<Direction> findAll() {
		String querystring = "SELECT p FROM Direction p ORDER BY id";
		Query query = em.createQuery(querystring);
		Set<Direction> list = (Set<Direction>) query.getResultList();
		return list;
	}

	@Override
	public Direction save(Direction entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Direction entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public Direction update(Direction entity) {
		return em.merge(entity);
	}


}
