package edu.neu.project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "best_book")
public class BestBookModel {

	private String title;
	private String smallImage;
	private String largeImage;
	private Author author;
	private int id;
	
	public int getId() {
		return id;
	}
	@XmlElement( name = "id" )
	public void setId(int id) {
		this.id = id;
	}
	
	public Author getAuthor() {
		return author;
	}
	@XmlElement( name = "author" )
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	@XmlElement( name = "title" )
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSmallImage() {
		return smallImage;
	}
	@XmlElement( name = "small_image_url" )
	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}
	public String getLargeImage() {
		return largeImage;
	}
	@XmlElement( name = "image_url" )
	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}
	
	
}
