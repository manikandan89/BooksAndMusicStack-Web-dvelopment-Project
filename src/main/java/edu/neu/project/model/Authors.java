package edu.neu.project.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "authors")
public class Authors {
	
	private List<Author> authors;

	public List<Author> getAuthors() {
		return authors;
	}
	@XmlElement( name = "author" )
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
}
