package edu.neu.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Entity;


@Entity
@Table(name="user_map_book", uniqueConstraints = {@UniqueConstraint(columnNames={"user_id","id"})})
@NamedQueries({ @NamedQuery(name="UserBookMapper.findMapper", query="select ub.book.bookId from UserBookMapper ub where ub.user.userId = :userId"),
	@NamedQuery(name="UserBookMapper.findIfMapperExists", query="select ub from UserBookMapper ub where ub.user.userId = :userId and "
			+ "ub.book.bookId = :bookId")})
public class UserBookMapper implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="map_id")
	private int mapId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="id")
	private BookEntityModel book;
	
	

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

	public BookEntityModel getBook() {
		return book;
	}

	public void setBook(BookEntityModel book) {
		this.book = book;
	}

}
