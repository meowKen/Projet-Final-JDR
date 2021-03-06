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
import com.monapp.dao.PartieDao;
import com.monapp.entity.Partie;
import com.monapp.entity.Views;

@RestController
@CrossOrigin
public class PartieController {
	
	@Autowired
	PartieDao partieDao;
	
	@GetMapping("/parties/{id}")
	@JsonView(Views.Partie.class)
	public ResponseEntity<Partie> findOne(@PathVariable("id") Integer id){
		Partie p = partieDao.findByPrimaryKey(id);
		
		if(p==null) {
			return new ResponseEntity<Partie>(p, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Partie>(p, HttpStatus.OK);
		}
	}
	
	@GetMapping("/parties")
	@JsonView(Views.Partie.class)
	public ResponseEntity<Set<Partie>> findAll(){
		Set<Partie> parties = partieDao.findAll();
		return new ResponseEntity<Set<Partie>>(parties, HttpStatus.OK);
	}
	
	@DeleteMapping("/parties/{id}")
	@JsonView(Views.Partie.class)
	public ResponseEntity<Partie> delete(@PathVariable("id") Integer id){
		Partie tmp = partieDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			partieDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/parties")
	@JsonView(Views.Partie.class)
	public ResponseEntity<Partie> create(@Valid @RequestBody Partie partie) {
		if (partie.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		partieDao.save(partie);
		return new ResponseEntity<Partie>(partie, HttpStatus.CREATED);
	}
	
	@PutMapping("/parties")
	@JsonView(Views.Partie.class)
	public ResponseEntity<Partie> update(@RequestBody Partie partie) {
		if (partie.getId() == 0) {
			return create(partie);
		}
		partie = partieDao.update(partie);

		return new ResponseEntity<Partie>(partie, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
}
