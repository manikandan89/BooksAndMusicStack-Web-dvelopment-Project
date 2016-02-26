package edu.neu.project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="search")
public class Search {
	
	Results results;
	
	
	public Results getResults() {
		return results;
	}
	
	@XmlElement(name="results")
	public void setResults(Results results) {
		this.results = results;
	}

}
