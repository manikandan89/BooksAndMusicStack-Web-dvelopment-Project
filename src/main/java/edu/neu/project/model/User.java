package edu.neu.project.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;




@Entity
@Table(name="users")
@NamedQueries({ @NamedQuery(name="User.findUserByName", query="select u from User u where u.username = :username"),
				@NamedQuery(name="User.findUsersBySearch", query="select u from User u where "
						+ "lower(u.username) like :username and u.username != :currentUser and u.userId not in :friendList"),
				@NamedQuery(name="User.getAllUsers", query="select u from User u where u.userId != :userId and u.userId not in :friendList")})
@SuppressWarnings("serial")
public class User implements UserDetails{
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	
	@Column(unique=true)
	private String username;
	private String password;
	private String email;
	private boolean enabled=true;
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<FavouriteTrack> favoriteTrackList = new HashSet<FavouriteTrack>();
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<FavouriteAlbum> favoriteAlbumList = new HashSet<FavouriteAlbum>();
	
	@OneToMany(mappedBy="recepient",cascade = CascadeType.ALL)
	private Set<FriendMapper> recepientList = new HashSet<FriendMapper>();
	
	@OneToMany(mappedBy="request",cascade = CascadeType.ALL)
	private Set<FriendMapper> requestList = new HashSet<FriendMapper>();
	
	@OneToMany(mappedBy="trReceiver",cascade = CascadeType.ALL)
	private Set<TrackRecommendation> trReceiverList = new HashSet<TrackRecommendation>();
	
	@OneToMany(mappedBy="trRecommender",cascade = CascadeType.ALL)
	private Set<TrackRecommendation> trRecommenderList = new HashSet<TrackRecommendation>();
	
	@OneToMany(mappedBy="alReceiver",cascade = CascadeType.ALL)
	private Set<AlbumRecommendation> alReceiverList = new HashSet<AlbumRecommendation>();
	
	@OneToMany(mappedBy="alRecommender",cascade = CascadeType.ALL)
	private Set<AlbumRecommendation> alRecommenderList = new HashSet<AlbumRecommendation>();
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserBookMapper> bookList = new HashSet<UserBookMapper>();
	
	public Set<UserBookMapper> getBookList() {
		return bookList;
	}
	public void setBookList(Set<UserBookMapper> bookList) {
		this.bookList = bookList;
	}
	public Set<AlbumRecommendation> getAlReceiverList() {
		return alReceiverList;
	}
	public void setAlReceiverList(Set<AlbumRecommendation> alReceiverList) {
		this.alReceiverList = alReceiverList;
	}
	public Set<AlbumRecommendation> getAlRecommenderList() {
		return alRecommenderList;
	}
	public void setAlRecommenderList(Set<AlbumRecommendation> alRecommenderList) {
		this.alRecommenderList = alRecommenderList;
	}
	public Set<TrackRecommendation> getTrReceiverList() {
		return trReceiverList;
	}
	public void setTrReceiverList(Set<TrackRecommendation> trReceiverList) {
		this.trReceiverList = trReceiverList;
	}
	public Set<TrackRecommendation> getTrRecommenderList() {
		return trRecommenderList;
	}
	public void setTrRecommenderList(Set<TrackRecommendation> trRecommenderList) {
		this.trRecommenderList = trRecommenderList;
	}
	public Set<FriendMapper> getRecepientList() {
		return recepientList;
	}
	public void setRecepientList(Set<FriendMapper> recepientList) {
		this.recepientList = recepientList;
	}
	public Set<FriendMapper> getRequestList() {
		return requestList;
	}
	public void setRequestList(Set<FriendMapper> requestList) {
		this.requestList = requestList;
	}
	public Set<FavouriteAlbum> getFavoriteAlbumList() {
		return favoriteAlbumList;
	}
	public void setFavoriteAlbumList(Set<FavouriteAlbum> favoriteAlbumList) {
		this.favoriteAlbumList = favoriteAlbumList;
	}
	public Set<FavouriteTrack> getFavoriteTrackList() {
		return favoriteTrackList;
	}
	public void setFavoriteTrackList(Set<FavouriteTrack> favoriteTrackList) {
		this.favoriteTrackList = favoriteTrackList;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

}
