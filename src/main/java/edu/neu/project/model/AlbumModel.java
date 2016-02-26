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
@Table(name="album_model")
@NamedQueries({ @NamedQuery(name="AlbumModel.findAlbumByAlbumId", query="select a from AlbumModel a where a.albumId = :albumId") })
public class AlbumModel {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="album_id", unique=true)
	private String albumId;
	
	@OneToMany(mappedBy="album",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<FavouriteAlbum> users = new HashSet<FavouriteAlbum>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public Set<FavouriteAlbum> getUsers() {
		return users;
	}

	public void setUsers(Set<FavouriteAlbum> users) {
		this.users = users;
	}

}
