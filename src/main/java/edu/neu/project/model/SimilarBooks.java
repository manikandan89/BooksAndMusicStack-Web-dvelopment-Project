package edu.neu.project.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "similar_books")
public class SimilarBooks {
	
	private List<BookReview> similarBooks;

	public List<BookReview> getSimilarBooks() {
		return similarBooks;
	}
	@XmlElement( name = "book" )
	public void setSimilarBooks(List<BookReview> similarBooks) {
		this.similarBooks = similarBooks;
	}

}
