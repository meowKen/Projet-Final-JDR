package com.monapp.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.monapp.dao.CelluleDao;
import com.monapp.entity.Cellule;
import com.monapp.entity.Views;

@RestController
@CrossOrigin
public class CelluleController {
	
	@Autowired
	CelluleDao celluleDao;
	
	@GetMapping("/cellules/{id}")
	@JsonView(Views.Cellule.class)
	public ResponseEntity<Cellule> findOne(@PathVariable("id") Integer id){
		Cellule p = celluleDao.findByPrimaryKey(id);
		
		if(p==null) {
			return new ResponseEntity<Cellule>(p, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Cellule>(p, HttpStatus.OK);
		}
	}
	
	@GetMapping("/cellules")
	@JsonView(Views.Cellule.class)
	public ResponseEntity<Set<Cellule>> findAll(){
		Set<Cellule> cellules = celluleDao.findAll();
		return new ResponseEntity<Set<Cellule>>(cellules, HttpStatus.OK);
	}
	
	@DeleteMapping("/cellules/{id}")
	@JsonView(Views.Cellule.class)
	public ResponseEntity<Cellule> delete(@PathVariable("id") Integer id){
		Cellule tmp = celluleDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			celluleDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/cellules")
	@JsonView(Views.Cellule.class)
	public ResponseEntity<Cellule> create(@Valid @RequestBody Cellule cellule) {
		if (cellule.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		celluleDao.save(cellule);
		return new ResponseEntity<Cellule>(cellule, HttpStatus.CREATED);
	}
	
	@PutMapping("/cellules")
	@JsonView(Views.Cellule.class)
	public ResponseEntity<Cellule> update(@RequestBody Cellule cellule) {
		if (cellule.getId() == 0) {
			return create(cellule);
		}
		cellule = celluleDao.update(cellule);

		return new ResponseEntity<Cellule>(cellule, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
}
