package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monapp.entity.Book;


@Transactional
@Repository
public class BookDaoImpl implements BookDao{

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Book> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> crit = cb.createQuery(Book.class);
		Root<Book> r = crit.from(Book.class);
		
		crit.select(r);
		
		return em.createQuery(crit).getResultList();
	}

	@Override
	public Book save(Book entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Book entity) {
		Book eMerged = em.merge(entity);
		em.remove(eMerged);
		
	}
	
	@Override
	public Book findByPrimaryKey(Integer id) {
		return em.find(Book.class, id);
	}

	@Override
	public Book update(Book entity) {
		return em.merge(entity);
	}



}
