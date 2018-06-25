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
import com.monapp.dao.BookDao;
import com.monapp.entity.Book;
import com.monapp.entity.Views;

@RestController
@CrossOrigin
public class BookController {
	
	@Autowired
	BookDao bookDao;
	
	@GetMapping("/books/{id}")
	@JsonView(Views.BookWithAuthors.class)
	public ResponseEntity<Book> findOne(@PathVariable("id") Integer id){
		Book b = bookDao.findByPrimaryKey(id);
		
		if(b == null) {
			return new ResponseEntity<Book>(b, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Book>(b, HttpStatus.OK);
		}
	}
	
	@GetMapping("/books")
	@JsonView(Views.BookWithAuthors.class)
	public ResponseEntity<List<Book>> findAll() {
		List<Book> books = bookDao.findAll();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@DeleteMapping("/books/{id}")	
	public ResponseEntity<Book> delete(@PathVariable("id") Integer id){
		Book tmp = bookDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				bookDao.delete(tmp);								
			}catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/books")
	@JsonView(Views.BookWithAuthors.class)
	public ResponseEntity<Book> create(@RequestBody Book book) {
		if (book.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		bookDao.save(book);
		return new ResponseEntity<Book>(book, HttpStatus.CREATED);
	}
	
	@PutMapping("/books")
	@JsonView(Views.BookWithAuthors.class)
	public ResponseEntity<Book> update(@RequestBody Book book) {
		if (book.getId() == 0) {
			return create(book);
		}
		book = bookDao.update(book);

		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	

}
