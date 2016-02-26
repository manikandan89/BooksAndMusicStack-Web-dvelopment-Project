package edu.neu.project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class BookReview {
	
	private String id;
	private String isbn;
	private String isbn13;
	private String title;
	private String imageUrl;
	private String smallImageUrl;
	private int publishedYear;
	private String publisher;
	private String language;
	private String description;
	private Authors authors;
	private SeriesWorks seriesWorks;
	private SimilarBooks similarBooks;
	
	
	public String getId() {
		return id;
	}
	
	@XmlElement( name = "id" )
	public void setId(String id) {
		this.id = id;
	}
	
	public String getIsbn() {
		return isbn;
	}
	@XmlElement( name = "isbn" )
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getIsbn13() {
		return isbn13;
	}
	@XmlElement( name = "isbn13" )
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	
	public String getTitle() {
		return title;
	}
	@XmlElement( name = "title" )
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	@XmlElement( name = "image_url" )
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getSmallImageUrl() {
		return smallImageUrl;
	}
	@XmlElement( name = "small_image_url" )
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
	
	public int getPublishedYear() {
		return publishedYear;
	}
	@XmlElement( name = "publication_year" )
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	
	public String getPublisher() {
		return publisher;
	}
	@XmlElement( name = "publisher" )
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getLanguage() {
		return language;
	}
	@XmlElement( name = "language_code" )
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getDescription() {
		return description;
	}
	@XmlElement( name = "description" )
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Authors getAuthors() {
		return authors;
	}
	@XmlElement( name = "authors" )
	public void setAuthors(Authors authors) {
		this.authors = authors;
	}
	
	public SeriesWorks getSeriesWorks() {
		return seriesWorks;
	}
	@XmlElement( name = "series_works" )
	public void setSeriesWorks(SeriesWorks seriesWorks) {
		this.seriesWorks = seriesWorks;
	}
	
	public SimilarBooks getSimilarBooks() {
		return similarBooks;
	}
	@XmlElement( name = "similar_books" )
	public void setSimilarBooks(SimilarBooks similarBooks) {
		this.similarBooks = similarBooks;
	}

}
