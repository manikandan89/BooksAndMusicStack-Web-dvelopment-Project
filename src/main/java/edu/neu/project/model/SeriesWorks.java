package edu.neu.project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "series_works")
public class SeriesWorks {
	
	private SeriesWork seriesWork;

	public SeriesWork getSeriesWork() {
		return seriesWork;
	}
	@XmlElement( name = "series_work" )
	public void setSeriesWork(SeriesWork seriesWork) {
		this.seriesWork = seriesWork;
	}

}
