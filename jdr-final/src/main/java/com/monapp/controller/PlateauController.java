package com.monapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.monapp.dao.CelluleDao;
import com.monapp.dao.PlateauDao;
import com.monapp.entity.Cellule;
import com.monapp.entity.Plateau;
import com.monapp.entity.Views;
import com.monapp.service.ServiceImpl;

@RestController
@CrossOrigin
public class PlateauController {
	
	@Autowired
	PlateauDao plateauDao;
	
	@Autowired
	CelluleDao celluleDao;
	
	@Autowired
	ServiceImpl s;
	
	@GetMapping("/plateaus/{id}")
	@JsonView(Views.Plateau.class)
	public ResponseEntity<Plateau> findOne(@PathVariable("id") Integer id){
		Plateau p = plateauDao.findByPrimaryKey(id);
		
		if(p==null) {
			return new ResponseEntity<Plateau>(p, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Plateau>(p, HttpStatus.OK);
		}
	}
	
	@GetMapping("/plateaus")
	@JsonView(Views.Plateau.class)
	public ResponseEntity<Set<Plateau>> findAll(){
		Set<Plateau> plateaus = plateauDao.findAll();
		return new ResponseEntity<Set<Plateau>>(plateaus, HttpStatus.OK);
	}
	
	@DeleteMapping("/plateaus/{id}")
	@JsonView(Views.Plateau.class)
	public ResponseEntity<Plateau> delete(@PathVariable("id") Integer id){
		Plateau tmp = plateauDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			plateauDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/plateaus")
	@JsonView(Views.Plateau.class)
	public ResponseEntity<Plateau> create(@Valid @RequestBody Plateau plateau) {
		if (plateau.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		plateauDao.save(plateau);
		return new ResponseEntity<Plateau>(plateau, HttpStatus.CREATED);
	}
	
	@PutMapping("/plateaus")
	@JsonView(Views.Plateau.class)
	public ResponseEntity<Plateau> update(@RequestBody Plateau plateau) {
		if (plateau.getId() == 0) {
			return create(plateau);
		}
		plateau = plateauDao.update(plateau);

		return new ResponseEntity<Plateau>(plateau, HttpStatus.OK);
	}
	
//    @ExceptionHandler({ Exception.class })
//    public ResponseEntity<Object> errors(){
//    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//    }
    
	@PostMapping("/plateaus/{x}/{y}")
    @JsonView(Views.Plateau.class)
    public ResponseEntity<Plateau> generatePlateau(@PathVariable("x") Integer x, @PathVariable("y") Integer y) {
        Plateau plateau = new Plateau(null, null, x, y, 0, 0);
        plateauDao.save(plateau);
        List<Cellule> cellules = new ArrayList<Cellule>();
        for (int i = 0 ; i<x ; i++) {
            for (int j = 0; j<y; j++) {
                Cellule c = new Cellule("scene n"+i+"-"+j , null, "", i,j, i*y+j, i*y+j);
                c.setPlateau(plateau);
                cellules.add(c);
                celluleDao.save(c);
            }
        }
        //Plateau plateau = new Plateau(cellules,null,x,y,0, 0);
        plateau.setCellules(cellules);
        s.constructionLaby(plateau);
        plateauDao.update(plateau);
        return new ResponseEntity<Plateau>(plateau,HttpStatus.CREATED);
    }
    
}
