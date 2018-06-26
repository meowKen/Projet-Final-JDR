package com.monapp.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monapp.entity.Item;

@Transactional
@Repository
public class ItemDaoImpl implements ItemDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Item findByPrimaryKey(Integer id) {
		return em.find(Item.class, id);
	}

	@Override
	public Set<Item> findAll() {
		String querystring = "SELECT p FROM Item p ORDER BY id";
		Query query = em.createQuery(querystring);
		Set<Item> list = new HashSet<Item>(query.getResultList());
		return list;
	}

	@Override
	public Item save(Item entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Item entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public Item update(Item entity) {
		return em.merge(entity);
	}
}
