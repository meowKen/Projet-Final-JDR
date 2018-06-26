package com.monapp.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.monapp.dao.UtilisateurDao;
import com.monapp.entity.Utilisateur;

@RestController
@CrossOrigin
public class UtilisateurController {
	
	@Autowired
	UtilisateurDao utilisateurDao;
	
	@GetMapping("/utilisateurs/{id}")
	public ResponseEntity<Utilisateur> findOne(@PathVariable("id") Integer id){
		Utilisateur p = utilisateurDao.findByPrimaryKey(id);
		
		if(p==null) {
			return new ResponseEntity<Utilisateur>(p, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Utilisateur>(p, HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/utilisateurs")
	public ResponseEntity<List<Utilisateur>> findAll(){
		List<Utilisateur> utilisateurs = utilisateurDao.findAll();
		return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
	}
	
	@DeleteMapping("/utilisateurs/{id}")
	public ResponseEntity<Utilisateur> delete(@PathVariable("id") Integer id){
		Utilisateur tmp = utilisateurDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			utilisateurDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/utilisateurs")
	public ResponseEntity<Utilisateur> create(@Valid @RequestBody Utilisateur utilisateur) {
		if (utilisateur.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		utilisateurDao.save(utilisateur);
		return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.CREATED);
	}
	
	@PutMapping("/utilisateurs")
	public ResponseEntity<Utilisateur> update(@RequestBody Utilisateur utilisateur) {
		if (utilisateur.getId() == 0) {
			return create(utilisateur);
		}
		utilisateur = utilisateurDao.update(utilisateur);

		return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
}
