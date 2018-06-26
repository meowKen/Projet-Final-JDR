package com.monapp.dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.entity.Inventaire;
import com.monapp.entity.Inventaire;

@Transactional
@Repository
public class InventaireDaoImpl implements InventaireDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Inventaire findByPrimaryKey(Integer id) {
		return em.find(Inventaire.class, id);
	}

	@Override
	public Set<Inventaire> findAll() {
		String querystring = "SELECT p FROM Inventaire p ORDER BY id";
		Query query = em.createQuery(querystring);
		Set<Inventaire> list = (Set<Inventaire>) query.getResultList();
		return list;
	}

	@Override
	public Inventaire save(Inventaire entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Inventaire entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public Inventaire update(Inventaire entity) {
		return em.merge(entity);
	}
}
