package edu.neu.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="track_recommendation", uniqueConstraints = {@UniqueConstraint(columnNames={"track_id","request_id","recepient_id"})})
@NamedQueries({ @NamedQuery(name="TrackRecommendation.findReceivedRecommendations", query="select tr from TrackRecommendation tr where "
				+ "tr.trReceiver.userId = :userId")})
public class TrackRecommendation {
	
	@Id
	@GeneratedValue
	@Column(name="map_id")
	private int mapId;
	

	@ManyToOne
	@JoinColumn(name="request_id")
	private User trRecommender;
	
	@ManyToOne
	@JoinColumn(name="recepient_id")
	private User trReceiver;
	
	@Column(name="track_id")
	private String trackId;
	

	public User getTrRecommender() {
		return trRecommender;
	}

	public void setTrRecommender(User trRecommender) {
		this.trRecommender = trRecommender;
	}

	public User getTrReceiver() {
		return trReceiver;
	}

	public void setTrReceiver(User trReceiver) {
		this.trReceiver = trReceiver;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public String getTrackId() {
		return trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

}
