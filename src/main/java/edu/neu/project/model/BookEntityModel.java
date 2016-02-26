package edu.neu.project.model;

import java.util.HashSet;
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
@Table(name="book_model")
@NamedQueries({ @NamedQuery(name="BookEntityModel.findBookId", query="select be from BookEntityModel be where be.bookId = :bookId")})
public class BookEntityModel {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="book_id", unique=true)
	private String bookId;
	
	@OneToMany(mappedBy="book",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserBookMapper> users = new HashSet<UserBookMapper>();
	

	public Set<UserBookMapper> getUsers() {
		return users;
	}

	public void setUsers(Set<UserBookMapper> users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

}
