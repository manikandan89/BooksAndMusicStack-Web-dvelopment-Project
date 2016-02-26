package edu.neu.project.service.util;

import java.util.List;

import edu.neu.project.model.BookRecommendationModelList;
import edu.neu.project.model.UserBookMapper;
import edu.neu.project.model.Book;
import edu.neu.project.model.BookReview;

public interface BookService {
	
	public List<Book> findBookServiceForSearchQuery(String query, String category);
	public BookReview findReviewsForBookService(String bookId);
	public void insertBook(String bookId);
	public void mapBookAndUser(String bookId, String currentUser);
	public BookRecommendationModelList getViewedBooks(String currentUser);
}
