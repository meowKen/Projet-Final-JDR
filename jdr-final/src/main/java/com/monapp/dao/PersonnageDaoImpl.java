package com.monapp.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.entity.Personnage;

@Transactional
@Repository
public class PersonnageDaoImpl implements PersonnageDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Personnage findByPrimaryKey(Integer id) {
		return em.find(Personnage.class, id);
	}

	@Override
	public Set<Personnage> findAll() {
		String querystring = "SELECT p FROM Personnage p ORDER BY id";
		Query query = em.createQuery(querystring);
		Set<Personnage> list = new HashSet<Personnage>(query.getResultList());
		return list;
	}

	@Override
	public Personnage save(Personnage entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Personnage entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public Personnage update(Personnage entity) {
		return em.merge(entity);
	}
}
