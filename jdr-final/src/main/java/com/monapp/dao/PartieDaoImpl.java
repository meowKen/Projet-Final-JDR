package com.monapp.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.entity.Partie;

@Transactional
@Repository
public class PartieDaoImpl implements PartieDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Partie findByPrimaryKey(Integer id) {
		return em.find(Partie.class, id);
	}

	@Override
	public Set<Partie> findAll() {
		String querystring = "SELECT p FROM Partie p ORDER BY id";
		Query query = em.createQuery(querystring);
		Set<Partie> list = new HashSet<Partie>(query.getResultList());
		return list;
	}

	@Override
	public Partie save(Partie entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Partie entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public Partie update(Partie entity) {
		return em.merge(entity);
	}


}
