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
@Table(name="album_recommendation", uniqueConstraints = {@UniqueConstraint(columnNames={"album_id","request_id","recepient_id"})})
@NamedQueries({ @NamedQuery(name="AlbumRecommendation.findReceivedRecommendations", query="select al from AlbumRecommendation al where "
		+ "al.alReceiver.userId = :userId")})
public class AlbumRecommendation {

	@Id
	@GeneratedValue
	@Column(name="map_id")
	private int mapId;
	

	@ManyToOne
	@JoinColumn(name="request_id")
	private User alRecommender;
	
	@ManyToOne
	@JoinColumn(name="recepient_id")
	private User alReceiver;
	
	@Column(name="album_id")
	private String albumId;

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public User getAlRecommender() {
		return alRecommender;
	}

	public void setAlRecommender(User alRecommender) {
		this.alRecommender = alRecommender;
	}

	public User getAlReceiver() {
		return alReceiver;
	}

	public void setAlReceiver(User alReceiver) {
		this.alReceiver = alReceiver;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}
}
