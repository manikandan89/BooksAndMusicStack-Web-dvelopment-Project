package edu.neu.project.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement (name="GoodreadsResponse")
public class BookMap {

/*	private Map<Integer, Book> bookMap = new HashMap<Integer, Book>();
	 
    public Map<Integer, Book> getBookMap() {
        return bookMap;
    }
 
    public void setBookMap(Map<Integer, Book> bookMap) {
        this.bookMap = bookMap;
    }*/
	
	
	
	
	private Search search;
	private BookReview book;
	
	
	public BookReview getBook() {
		return book;
	}

	@XmlElement(name="book")
	public void setBook(BookReview book) {
		this.book = book;
	}

	public Search getSearch() {
		return search;
	}
	
	@XmlElement(name="search")
	public void setSearch(Search search) {
		this.search = search;
	}
	
}
