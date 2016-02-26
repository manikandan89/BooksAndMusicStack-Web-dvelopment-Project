package edu.neu.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user_map_album", uniqueConstraints = {@UniqueConstraint(columnNames={"user_id","id"})})
public class FavouriteAlbum {
	
	@Id
	@GeneratedValue
	@Column(name="map_id")
	private int mapId;
	

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="id")
	private AlbumModel album;

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

	public AlbumModel getAlbum() {
		return album;
	}

	public void setAlbum(AlbumModel album) {
		this.album = album;
	}

}
