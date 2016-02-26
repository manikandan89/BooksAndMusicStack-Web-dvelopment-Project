package edu.neu.project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "series_work")
public class SeriesWork {
	
	private Series series;

	public Series getSeries() {
		return series;
	}
	@XmlElement( name = "series" )
	public void setSeries(Series series) {
		this.series = series;
	}

}
