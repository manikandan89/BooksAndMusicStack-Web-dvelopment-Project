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
@Table(name="friend_mapper", uniqueConstraints = {@UniqueConstraint(columnNames={"request_id","recepient_id"})})
@NamedQueries({ @NamedQuery(name="FriendMapper.findMapperByMapId", query="select fm from FriendMapper fm where fm.mapId = :mapId"), 
				@NamedQuery(name="FriendMapper.getFriendsById", query="select fm from FriendMapper fm where ((fm.recepient.userId = :recepientUserId "
						+ "and lower(fm.request.username) like :requestUserName) or (fm.request.userId = :requestUserId and "
						+ "lower(fm.recepient.username) like :recepientUserName)) and fm.state = 1"), 
				@NamedQuery(name="FriendMapper.getFriendsListById", query="select fm from FriendMapper fm where ((fm.recepient.userId = :recepientUserId) "
								+ "or (fm.request.userId = :requestUserId)) and fm.state = 1"), 
				@NamedQuery(name="FriendMapper.isFriend", query="select fm from FriendMapper fm where fm.request.userId = :requestUserId "
						+ "and fm.recepient.userId = :recepientUserId")})
						
public class FriendMapper {
	
	@Id
	@GeneratedValue
	@Column(name="map_id")
	private int mapId;
	

	@ManyToOne
	@JoinColumn(name="request_id")
	private User request;
	
	@ManyToOne
	@JoinColumn(name="recepient_id")
	private User recepient;
	
	private boolean state = false;

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public User getRequest() {
		return request;
	}

	public void setRequest(User request) {
		this.request = request;
	}

	public User getRecepient() {
		return recepient;
	}

	public void setRecepient(User recepient) {
		this.recepient = recepient;
	}

}
