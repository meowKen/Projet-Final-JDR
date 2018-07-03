package com.monapp.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monapp.entity.Cellule;
import com.monapp.entity.Direction;
import com.monapp.entity.Plateau;
import com.monapp.entity.Route;
import com.monapp.service.ServiceImpl;

@Transactional
@Repository
public class CelluleDaoImpl implements CelluleDao{

	@Autowired
	RouteDao routeDao;
	
	@Autowired
	DirectionDao directionDao;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Cellule findByPrimaryKey(Integer id) {
		return em.find(Cellule.class, id);
	}

	@Override
	public Set<Cellule> findAll() {
		String querystring = "SELECT p FROM Cellule p ORDER BY id";
		Query query = em.createQuery(querystring);
		Set<Cellule> list = new HashSet<Cellule>(query.getResultList());
		return list;
	}

	@Override
	public Cellule save(Cellule entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Cellule entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public Cellule update(Cellule entity) {
		System.out.println(entity);
		return em.merge(entity);
	}

	@Override
	public Set<Cellule> findByPlateau(int id_plateau) {
		String querystring = "SELECT p FROM Cellule p WHERE plateau= "+ id_plateau + "ORDER BY id";
		Query query = em.createQuery(querystring);
		Set<Cellule> list = new HashSet<Cellule>(query.getResultList());
		return list;
	}

	@Override
	public void addChemin(Cellule caseEnCours) {
		Plateau plateau = caseEnCours.getPlateau();
		List<Cellule> voisinage = plateau.voisinageN(caseEnCours);
		for (Cellule c : voisinage) {
			if (c!= null && c.getNumeroDeCase() != caseEnCours.getNumeroDeCase()) {
				System.out.println("entre les deux if");
				if (Math.random()<0.5) {
					System.out.println("dans le 2eme if");
					c.setNumeroDeCase(caseEnCours.getNumeroDeCase());
					
					Direction direction1 = new Direction(c.getId());
					Direction direction2 = new Direction(caseEnCours.getId());	
					directionDao.save(direction1);					
					directionDao.save(direction2);
					
					if(caseEnCours.getRoutesPossible() == null) {
						caseEnCours.setRoutesPossible(new Route(new HashSet<Direction>()));
					}
					
					if(c.getRoutesPossible() == null) {
						c.setRoutesPossible(new Route(new HashSet<Direction>()));
					}
					
					Route r1 = caseEnCours.getRoutesPossible();
					Route r2 = c.getRoutesPossible();
					direction1.addRoute(r1);
					direction2.addRoute(r2);
					caseEnCours.addRoute(r1);
					c.addRoute(r2);
					routeDao.save(r1);
					routeDao.save(r2);
					this.update(c);
					this.update(caseEnCours);
//					serviceI.propagation(caseEnCours, c);							
//					directionDao.update(direction1);
//					directionDao.update(direction2);
//					routeDao.update(r1);
//					routeDao.update(r2);
				}
			}
		}
	}


}
