package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monapp.entity.Author;

@Transactional
@Repository
public class AuthorDaoImpl implements AuthorDao{

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Author> findAll() {
		String querystring = "SELECT a FROM Author a " ;
		Query query = em.createQuery( querystring ) ;
		List<Author> list = query.getResultList() ;
		return list;
	}

	@Override
	public Author save(Author entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Author entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	public Author findByPrimaryKey(Integer id) {
		return em.find(Author.class, id);
	}

	@Override
	public Author update(Author entity) {
		return em.merge(entity);
	}
}
