package edu.neu.project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "series")
public class Series {
	
	private int id;
	private String title;
	
	public int getId() {
		return id;
	}
	@XmlElement( name = "id" )
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	@XmlElement( name = "title" )
	public void setTitle(String title) {
		this.title = title;
	}

}
