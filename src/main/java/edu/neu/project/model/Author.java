package edu.neu.project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "author")
public class Author {

	private String authorId;
	private String name;
	private String image;
	private String smallImage;
	private String rating;
	
	
	public String getAuthorId() {
		return authorId;
	}
	@XmlElement( name = "id" )
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	
	public String getName() {
		return name;
	}
	@XmlElement( name = "name" )
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImage() {
		return image;
	}
	@XmlElement( name = "image_url" )
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getSmallImage() {
		return smallImage;
	}
	@XmlElement( name = "small_image_url" )
	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}
	
	public String getRating() {
		return rating;
	}
	@XmlElement( name = "average_rating" )
	public void setRating(String rating) {
		this.rating = rating;
	}
}
