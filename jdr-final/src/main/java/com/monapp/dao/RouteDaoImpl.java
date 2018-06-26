package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.entity.Route;

@Transactional
@Repository
public class RouteDaoImpl implements RouteDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Route findByPrimaryKey(Integer id) {
		return em.find(Route.class, id);
	}

	@Override
	public List<Route> findAll() {
		String querystring = "SELECT p FROM Route p ORDER BY id";
		Query query = em.createQuery(querystring);
		List<Route> list = query.getResultList();
		return list;
	}

	@Override
	public Route save(Route entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Route entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public Route update(Route entity) {
		return em.merge(entity);
	}


}
