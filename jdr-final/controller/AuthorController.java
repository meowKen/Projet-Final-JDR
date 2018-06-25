package com.monapp.controller;

import java.util.List;

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
import com.monapp.dao.AuthorDao;
import com.monapp.entity.Author;
import com.monapp.entity.Views;


@RestController
@CrossOrigin
public class AuthorController {
	
	@Autowired	
	AuthorDao authorDao;
	
	@GetMapping("/authors/{id}")
	@JsonView(Views.AuthorWithBooks.class)
	public ResponseEntity<Author> findOne(@PathVariable("id") Integer id){
		
		Author b = authorDao.findByPrimaryKey(id);
		
		if(b == null) {
			return new ResponseEntity<Author>(b, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Author>(b, HttpStatus.OK);
		}
	}
	
	@GetMapping("/authors")
	@JsonView(Views.AuthorWithBooks.class)
	public ResponseEntity<List<Author>> findAll() {
		List<Author> authors = authorDao.findAll();
		return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
	}
	
	@DeleteMapping("/authors/{id}")
	public ResponseEntity<Author> delete(@PathVariable("id") Integer id){
		Author tmp = authorDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			authorDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/authors")
	@JsonView(Views.AuthorWithBooks.class)
	public ResponseEntity<Author> create(@RequestBody Author author) {
		if (author.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		authorDao.save(author);
		return new ResponseEntity<Author>(author, HttpStatus.CREATED);
	}
	@PutMapping("/authors")
	@JsonView(Views.AuthorWithBooks.class)
	public ResponseEntity<Author> update(@RequestBody Author author) {
		if (author.getId() == 0) {
			return create(author);
		}
		author = authorDao.update(author);

		return new ResponseEntity<Author>(author, HttpStatus.OK);
	}
	

}
