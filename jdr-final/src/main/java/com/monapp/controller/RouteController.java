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

import com.monapp.dao.RouteDao;
import com.monapp.entity.Route;

@RestController
@CrossOrigin
public class RouteController {
	
	@Autowired
	RouteDao routeDao;
	
	@GetMapping("/routes/{id}")
	public ResponseEntity<Route> findOne(@PathVariable("id") Integer id){
		Route p = routeDao.findByPrimaryKey(id);
		
		if(p==null) {
			return new ResponseEntity<Route>(p, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Route>(p, HttpStatus.OK);
		}
	}
	
	@GetMapping("/routes")
	public ResponseEntity<List<Route>> findAll(){
		List<Route> routes = routeDao.findAll();
		return new ResponseEntity<List<Route>>(routes, HttpStatus.OK);
	}
	
	@DeleteMapping("/routes/{id}")
	public ResponseEntity<Route> delete(@PathVariable("id") Integer id){
		Route tmp = routeDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			routeDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/routes")
	public ResponseEntity<Route> create(@Valid @RequestBody Route route) {
		if (route.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		routeDao.save(route);
		return new ResponseEntity<Route>(route, HttpStatus.CREATED);
	}
	
	@PutMapping("/routes")
	public ResponseEntity<Route> update(@RequestBody Route route) {
		if (route.getId() == 0) {
			return create(route);
		}
		route = routeDao.update(route);

		return new ResponseEntity<Route>(route, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
}
