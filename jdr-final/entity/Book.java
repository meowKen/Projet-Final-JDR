package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	@Column
	@JsonView(Views.Common.class)
	private String titre;

	@Column
	@JsonView(Views.Common.class)
	private String isbn;
	
	@Column
	@JsonView(Views.Common.class)
	private int nbrPages;
	
	 
	@Lob
	@JsonView(Views.Common.class)
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@JsonView(Views.BookWithAuthors.class)
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable( name="AUTHOR_BOOK",joinColumns=@JoinColumn(name="ID_AUTHOR"),inverseJoinColumns=@JoinColumn(name="ID_BOOK") )
	private List<Author> authors = new ArrayList<Author>();

	public Book(String titre, String isbn, int nbrPages) {
		super();
		this.nbrPages = nbrPages;
		this.isbn = isbn;
		this.titre = titre;
		
		
	}
	public Book() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public void addAuthor(Author a) {
		a.getBooks().add(this);
		//this.authors.add(a);
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getNbrPages() {
		return nbrPages;
	}
	public void setNbrPages(int nbrPages) {
		this.nbrPages = nbrPages;
	}
}
