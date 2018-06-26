package com.monapp.controller;

import java.util.List;

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

import com.monapp.dao.PlateauDao;
import com.monapp.entity.Plateau;

@RestController
@CrossOrigin
public class PlateauController {
	
	@Autowired
	PlateauDao plateauDao;
	
	@GetMapping("/plateaus/{id}")
	public ResponseEntity<Plateau> findOne(@PathVariable("id") Integer id){
		Plateau p = plateauDao.findByPrimaryKey(id);
		
		if(p==null) {
			return new ResponseEntity<Plateau>(p, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Plateau>(p, HttpStatus.OK);
		}
	}
	
	@GetMapping("/plateaus")
	public ResponseEntity<List<Plateau>> findAll(){
		List<Plateau> plateaus = plateauDao.findAll();
		return new ResponseEntity<List<Plateau>>(plateaus, HttpStatus.OK);
	}
	
	@DeleteMapping("/plateaus/{id}")
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
	public ResponseEntity<Plateau> create(@Valid @RequestBody Plateau plateau) {
		if (plateau.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		plateauDao.save(plateau);
		return new ResponseEntity<Plateau>(plateau, HttpStatus.CREATED);
	}
	
	@PutMapping("/plateaus")
	public ResponseEntity<Plateau> update(@RequestBody Plateau plateau) {
		if (plateau.getId() == 0) {
			return create(plateau);
		}
		plateau = plateauDao.update(plateau);

		return new ResponseEntity<Plateau>(plateau, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
}
