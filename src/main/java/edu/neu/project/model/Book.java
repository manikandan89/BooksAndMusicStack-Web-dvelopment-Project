package edu.neu.project.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "work")
public class Book {
	
	private int id;
	private String average_rating;
	private BestBookModel bestBook;
	
	
	
	public BestBookModel getBestBook() {
		return bestBook;
	}
	@XmlElement( name = "best_book" )
	public void setBestBook(BestBookModel bestBook) {
		this.bestBook = bestBook;
	}

	public int getId() {
		return id;
	}
	
	@XmlElement( name = "id" )
	public void setId(int id) {
		this.id = id;
	}
	public String getAverage_rating() {
		return average_rating;
	}
	
	@XmlElement( name = "average_rating" )
	public void setAverage_rating(String average_rating) {
		this.average_rating = average_rating;
	}
	

}
