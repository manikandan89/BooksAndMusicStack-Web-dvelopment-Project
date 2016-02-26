package edu.neu.project.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="track_model")
@NamedQueries({ @NamedQuery(name="TrackModel.findTrackByTrackId", query="select t from TrackModel t where t.trackId = :trackId"), 
				@NamedQuery(name="TrackModel.findTracksForMultipleTrackIds", query="select t.trackId from TrackModel t where t.id IN :idList")})

public class TrackModel {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="track_id", unique=true)
	private String trackId;
	
	@OneToMany(mappedBy="track",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<FavouriteTrack> users = new HashSet<FavouriteTrack>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrackId() {
		return trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public Set<FavouriteTrack> getUsers() {
		return users;
	}

	public void setUsers(Set<FavouriteTrack> users) {
		this.users = users;
	}

}
