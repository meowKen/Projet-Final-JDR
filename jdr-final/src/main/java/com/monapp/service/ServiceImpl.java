package com.monapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.monapp.dao.CelluleDao;
import com.monapp.dao.CelluleDaoImpl;
import com.monapp.dao.PlateauDao;
import com.monapp.entity.Cellule;
import com.monapp.entity.Plateau;

@org.springframework.stereotype.Service
public class ServiceImpl implements ServiceI{

	@Autowired
	CelluleDao celluleDao;
	
	@Autowired
	PlateauDao plateauDao;
	
	public void constructionLaby(Plateau plateau) {
		List<Cellule> listCellules = plateau.getCellules();
		int numeroBase = listCellules.get(0).getNumeroDeCase();
		int numeroAlea;
		int i = 0;
			while(listCellules.size()>0) {
				numeroAlea = (int) Math.floor(Math.random()*listCellules.size());
				System.out.println("I: "+ i++);
				if (numeroAlea != numeroBase) {
					celluleDao.addChemin(listCellules.get(numeroAlea));
					numeroBase = numeroAlea;
				}
				listCellules.remove(numeroAlea);
			}
			
	}
	


	
}
