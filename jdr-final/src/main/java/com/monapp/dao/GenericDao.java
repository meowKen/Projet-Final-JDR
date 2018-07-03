package com.monapp.dao;

import java.io.Serializable;
import java.util.Set;

public interface GenericDao <T, ID extends Serializable> {
	T findByPrimaryKey(ID id);
	Set<T> findAll ();
	T save(T entity);
	void delete(T entity);
	T update(T entity);
	
}
