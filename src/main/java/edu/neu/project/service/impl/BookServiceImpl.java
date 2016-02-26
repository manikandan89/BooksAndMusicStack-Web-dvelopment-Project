package edu.neu.project.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.project.model.Book;
import edu.neu.project.model.BookEntityModel;
import edu.neu.project.model.BookRecommendationModelList;
import edu.neu.project.model.BookReview;
import edu.neu.project.model.BooksRecommendedModel;
import edu.neu.project.model.FavouriteTrack;
import edu.neu.project.model.User;
import edu.neu.project.model.UserBookMapper;
import edu.neu.project.repository.BookRepository;
import edu.neu.project.repository.UserRepository;
import edu.neu.project.service.util.BookService;
import edu.neu.project.service.util.BookService;
import edu.neu.project.util.BookUtil;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public List<Book> findBookServiceForSearchQuery(String query, String category) {
		
		List<Book> books = BookUtil.getListOfBooksForQuery(query, category);
		return books;
	}

	@Override
	public BookReview findReviewsForBookService(String bookId) {
		
		if (bookId == null) {
			return null;
		}
		
		
		BookReview book = BookUtil.findReviewsForBook(bookId);
		return book;
	}

	@Override
	public void insertBook(String bookId) {
		
		if(bookId == null) {
			return;
		}
		
		BookEntityModel bookModel = bookRepository.getBookForBookId(bookId);
		
		if (bookModel != null) {
			return;
		}
				
		BookEntityModel book = new BookEntityModel();
		book.setBookId(bookId);
		
		bookRepository.persistBook(book);
	}

	@Override
	public void mapBookAndUser(String bookId, String currentUser) {
		
		if (bookId == null || currentUser == null) {
			return;
		}
		BookEntityModel book = bookRepository.getBookForBookId(bookId);
		
		if (book == null) {
			return;
		}
		
		User newUser = userRepository.getUserByName(currentUser);
		
		List<UserBookMapper> mappersFromDB = bookRepository.findIfMapperExists(newUser,book);
		
		if(mappersFromDB != null && mappersFromDB.size() > 0) {
			System.out.println("Mapper alreday exists. Returning...");
			return;
		}
		
		UserBookMapper bookMapper = new UserBookMapper();
		bookMapper.setUser(newUser);
		bookMapper.setBook(book);
		
		Set<UserBookMapper> bookList = newUser.getBookList();
		if (bookList == null) {
			bookList = new HashSet<UserBookMapper>();
			bookList.add(bookMapper);
		} else {
			bookList.add(bookMapper);
		}
		newUser.setBookList(bookList);
		
		Set<UserBookMapper> userList = book.getUsers();
		if (userList == null) {
			userList = new HashSet<UserBookMapper>();
			userList.add(bookMapper);
		} else {
			userList.add(bookMapper);
		}
		book.setUsers(userList);
		
		bookRepository.persistBookMapper(bookMapper);
		
	}

	@Override
	public BookRecommendationModelList getViewedBooks(String currentUser) {
		
		if (currentUser == null) {
			return null;
		}
		
		User newUser = userRepository.getUserByName(currentUser);
		
		List<String> mapperBookIds = bookRepository.getMappedBooks(newUser);
		List<BooksRecommendedModel> models = new ArrayList<BooksRecommendedModel>();
		List<BooksRecommendedModel> similarModels = new ArrayList<BooksRecommendedModel>();
		
		if (mapperBookIds != null && mapperBookIds.size() > 0) {
			for (int i = 0; i < mapperBookIds.size(); i++) {
				if (i > 3) {
					break;
				}
				
				
				BookReview book = BookUtil.findReviewsForBook(mapperBookIds.get(i));
				if (book != null) {
					BooksRecommendedModel model = new BooksRecommendedModel();
					model.setBookId(book.getId());
					model.setImage(book.getImageUrl());
					model.setTitle(book.getTitle());
					models.add(model);
					
					if (book.getSimilarBooks() != null && book.getSimilarBooks().getSimilarBooks() != null &&
							book.getSimilarBooks().getSimilarBooks().size() > 0) {
						
						List<BookReview> similarBooks = book.getSimilarBooks().getSimilarBooks();
						for (int j = 0; j < similarBooks.size(); j++) {
							
							if(similarBooks.get(j) != null) {
								BooksRecommendedModel similarModel = new BooksRecommendedModel();
								similarModel.setBookId(similarBooks.get(j).getId());
								similarModel.setImage(similarBooks.get(j).getImageUrl());
								similarModel.setTitle(similarBooks.get(j).getTitle());
								similarModels.add(similarModel);
							}
						}
						
						
					}
				}
			}
		} else {
			
			mapperBookIds = new ArrayList<String>(); 
			mapperBookIds.add("1885");
			mapperBookIds.add("41865");
			mapperBookIds.add("5907");
			mapperBookIds.add("7869");
			mapperBookIds.add("17333554");
			mapperBookIds.add("157993");
			mapperBookIds.add("5");
			mapperBookIds.add("15931");
			
			List<String> images = new ArrayList<String>();
			images.add("https://d.gr-assets.com/books/1320399351m/1885.jpg");
			images.add("https://d.gr-assets.com/books/1361039443m/41865.jpg");
			images.add("https://d.gr-assets.com/books/1372847500m/5907.jpg");
			images.add("https://d.gr-assets.com/books/1335860740m/7869.jpg");
			images.add("https://d.gr-assets.com/books/1376876502m/17333554.jpg");
			images.add("https://d.gr-assets.com/books/1367545443m/157993.jpg");
			images.add("https://d.gr-assets.com/books/1362278317m/5.jpg");
			images.add("https://d.gr-assets.com/books/1385738917m/15931.jpg");
			
			List<String> titles = new ArrayList<String>();
			titles.add("Pride and Prejudice");
			titles.add("Twilight (Twilight, #1)");
			titles.add("The Hobbit (Middle-Earth Universe)");
			titles.add("The Bourne Identity (Jason Bourne, #1)");
			titles.add("Sports Illustrated Baseball's Greatest");
			titles.add("The Little Prince");
			titles.add("Harry Potter and the Prisoner of Azkaban (Harry Potter, #3)");
			titles.add("The Notebook (The Notebook, #1)");
			
			
			
			for (int i = 0; i < 4; i++) {
				BooksRecommendedModel model = new BooksRecommendedModel();
				model.setBookId(mapperBookIds.get(i));
				model.setImage(images.get(i));
				model.setTitle(titles.get(i));
				models.add(model);
			}
			
			for (int i = 4; i < 8; i++) {
				BooksRecommendedModel model = new BooksRecommendedModel();
				model.setBookId(mapperBookIds.get(i));
				model.setImage(images.get(i));
				model.setTitle(titles.get(i));
				similarModels.add(model);
			}
			
		}
		
		
		BookRecommendationModelList bookList = new BookRecommendationModelList();
		bookList.setRecommendedList(models);
		bookList.setSimilarList(similarModels);
		
		return bookList;
	}

	
	
	
}
