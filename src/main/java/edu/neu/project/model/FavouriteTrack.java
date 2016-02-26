package edu.neu.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user_map_track", uniqueConstraints = {@UniqueConstraint(columnNames={"user_id","id"})})
/*@NamedQueries({ @NamedQuery(name="FavouriteTrack.findTracksByUser", query="select ft from FavouriteTrack ft where ft.userId = :userId")})*/
public class FavouriteTrack implements Serializable {
	
	
	@Id
	@GeneratedValue
	@Column(name="map_id")
	private int mapId;
	

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="id")
	private TrackModel track;

	
	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TrackModel getTrack() {
		return track;
	}

	public void setTrack(TrackModel track) {
		this.track = track;
	}

}
