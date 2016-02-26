package edu.neu.project.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="results")
public class Results {
	
	List<Book> books;
	
	public List<Book> getBooks() {
		return books;
	}
	
	@XmlElement(name="work")
	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
