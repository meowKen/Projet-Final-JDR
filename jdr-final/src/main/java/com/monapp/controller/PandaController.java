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

import com.monapp.dao.PandaDao;
import com.monapp.entity.Panda;
import com.monapp.enumeration.PandaContinent;

@RestController
@CrossOrigin
public class PandaController {
	
	@Autowired
	PandaDao pandaDao;
	
	@GetMapping("/pandas/{id}")
	public ResponseEntity<Panda> findOne(@PathVariable("id") Integer id){
		Panda p = pandaDao.findByPrimaryKey(id);
		
		if(p==null) {
			return new ResponseEntity<Panda>(p, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Panda>(p, HttpStatus.OK);
		}
	}
	
	/*@GetMapping("/pandas/origine/{origine}")
	public ResponseEntity<List<Panda>> findByOrigine(@PathVariable("origine") String origine){
		List<Panda> pandas = pandaDao.findByOrigine(origine);
		return new ResponseEntity<List<Panda>>(pandas, HttpStatus.OK);
	}*/
	
	@GetMapping("/pandasori")
	public ResponseEntity<List<Panda>> findByOrigineParam(@PathParam ("origine") String origine){
		List<Panda> pandas = pandaDao.findByOrigine(PandaContinent.valueOf(origine));
		System.out.println("ORIGINE ---> "+origine+" ValueOf ---> "+PandaContinent.valueOf(origine));
		return new ResponseEntity<List<Panda>>(pandas, HttpStatus.OK);
	}
	
	
	@GetMapping("/pandas")
	public ResponseEntity<List<Panda>> findAll(){
		List<Panda> pandas = pandaDao.findAll();
		return new ResponseEntity<List<Panda>>(pandas, HttpStatus.OK);
	}
	
	@DeleteMapping("/pandas/{id}")
	public ResponseEntity<Panda> delete(@PathVariable("id") Integer id){
		Panda tmp = pandaDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			pandaDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/pandas")
	public ResponseEntity<Panda> create(@Valid @RequestBody Panda panda) {
		if (panda.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		pandaDao.save(panda);
		return new ResponseEntity<Panda>(panda, HttpStatus.CREATED);
	}
	
	@PutMapping("/pandas")
	public ResponseEntity<Panda> update(@RequestBody Panda panda) {
		if (panda.getId() == 0) {
			return create(panda);
		}
		panda = pandaDao.update(panda);

		return new ResponseEntity<Panda>(panda, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
}
