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

import com.monapp.dao.DirectionDao;
import com.monapp.entity.Direction;

@RestController
@CrossOrigin
public class DirectionController {
	
	@Autowired
	DirectionDao directionDao;
	
	@GetMapping("/directions/{id}")
	public ResponseEntity<Direction> findOne(@PathVariable("id") Integer id){
		Direction p = directionDao.findByPrimaryKey(id);
		
		if(p==null) {
			return new ResponseEntity<Direction>(p, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Direction>(p, HttpStatus.OK);
		}
	}
	
	@GetMapping("/directions")
	public ResponseEntity<List<Direction>> findAll(){
		List<Direction> directions = directionDao.findAll();
		return new ResponseEntity<List<Direction>>(directions, HttpStatus.OK);
	}
	
	@DeleteMapping("/directions/{id}")
	public ResponseEntity<Direction> delete(@PathVariable("id") Integer id){
		Direction tmp = directionDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			directionDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/directions")
	public ResponseEntity<Direction> create(@Valid @RequestBody Direction direction) {
		if (direction.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		directionDao.save(direction);
		return new ResponseEntity<Direction>(direction, HttpStatus.CREATED);
	}
	
	@PutMapping("/directions")
	public ResponseEntity<Direction> update(@RequestBody Direction direction) {
		if (direction.getId() == 0) {
			return create(direction);
		}
		direction = directionDao.update(direction);

		return new ResponseEntity<Direction>(direction, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
}
