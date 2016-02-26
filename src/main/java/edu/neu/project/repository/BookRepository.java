package edu.neu.project.repository;

import java.util.List;

import edu.neu.project.model.BookEntityModel;
import edu.neu.project.model.User;
import edu.neu.project.model.UserBookMapper;

public interface BookRepository {
	
	public BookEntityModel getBookForBookId(String bookId);
	public void persistBook(BookEntityModel book);
	public void persistBookMapper(UserBookMapper mapper);
	public List<String> getMappedBooks(User user);
	public List<UserBookMapper> findIfMapperExists(User newUser, BookEntityModel book);
	
}
