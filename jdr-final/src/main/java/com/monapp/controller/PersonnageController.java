package com.monapp.controller;

import java.util.Set;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

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
import com.monapp.dao.PersonnageDao;
import com.monapp.entity.Personnage;
import com.monapp.entity.Views;


@RestController
@CrossOrigin
public class PersonnageController {
	
	@Autowired
	PersonnageDao personnageDao;
	
	@GetMapping("/personnages/{id}")
	@JsonView(Views.Personnage.class)
	public ResponseEntity<Personnage> findOne(@PathVariable("id") Integer id){
		Personnage p = personnageDao.findByPrimaryKey(id);
		
		if(p==null) {
			return new ResponseEntity<Personnage>(p, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Personnage>(p, HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/personnages")
	@JsonView(Views.Personnage.class)
	public ResponseEntity<Set<Personnage>> findAll(){
		Set<Personnage> personnages = personnageDao.findAll();
		return new ResponseEntity<Set<Personnage>>(personnages, HttpStatus.OK);
	}
	
	@DeleteMapping("/personnages/{id}")
	@JsonView(Views.Personnage.class)
	public ResponseEntity<Personnage> delete(@PathVariable("id") Integer id){
		Personnage tmp = personnageDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			personnageDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/personnages")
	@JsonView(Views.Personnage.class)
	public ResponseEntity<Personnage> create(@Valid @RequestBody Personnage personnage) {
		if (personnage.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		personnageDao.save(personnage);
		return new ResponseEntity<Personnage>(personnage, HttpStatus.CREATED);
	}
	
	@PutMapping("/personnages")
	@JsonView(Views.Personnage.class)
	public ResponseEntity<Personnage> update(@RequestBody Personnage personnage) {
		if (personnage.getId() == 0) {
			return create(personnage);
		}
		personnage = personnageDao.update(personnage);

		return new ResponseEntity<Personnage>(personnage, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
}
