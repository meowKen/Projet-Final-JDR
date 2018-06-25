package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.entity.Panda;
import com.monapp.enumeration.PandaContinent;

@Transactional
@Repository
public class PandaDaoImpl implements PandaDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Panda findByPrimaryKey(Integer id) {
		return em.find(Panda.class, id);
	}

	@Override
	public List<Panda> findAll() {
		String querystring = "SELECT p FROM Panda p ORDER BY id";
		Query query = em.createQuery(querystring);
		List<Panda> list = query.getResultList();
		return list;
	}

	@Override
	public Panda save(Panda entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Panda entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public Panda update(Panda entity) {
		return em.merge(entity);
	}

	@Override
	public List<Panda> findByOrigine(PandaContinent origine) {
		String querystring = "SELECT p FROM Panda p WHERE p.origine = "+origine;
		Query query = em.createQuery(querystring);
		List<Panda> list = query.getResultList();
		return list;
	}

}
