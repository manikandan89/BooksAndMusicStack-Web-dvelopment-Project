package edu.neu.project.controller;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrapper.spotify.models.SimpleTrack;
import com.wrapper.spotify.models.Track;

import edu.neu.project.service.util.BookService;
import edu.neu.project.model.Book;
import edu.neu.project.model.BookRecommendationModelList;
import edu.neu.project.model.BookReview;
import edu.neu.project.model.BookTitleModel;
import edu.neu.project.model.SpotifyAuthentication;
import edu.neu.project.model.UserBookMapper;

@Controller
@RequestMapping("/user/book/")
public class BookController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(BookController.class);
	
	private BookService bookService;
	
	 @Autowired
	    public BookController(BookService bookService) {
	        this.bookService = bookService;
	 }
	 
	
	@RequestMapping(method = RequestMethod.GET)
	public String music(Locale locale, Model model) {
		logger.info("Book Controller calledd", locale);

	
		return "book";
	}
	
	@RequestMapping(value="search", method = RequestMethod.GET)
	public @ResponseBody List<Book> getBooksForSearchQuery(@RequestParam String input) {
		
		System.out.println("getBooksForSearchQuery called");
		System.out.println("booksearch name::" + input);
		
		List<Book> books = bookService.findBookServiceForSearchQuery(input,"title");
			
		return books;
	}
	
	@RequestMapping(value="/{bookId}", method = RequestMethod.GET)
	public String getBookModel(@PathVariable String bookId, Model model) {
		
		System.out.println("bookId in getBookModel::" +  bookId);
		
		model.addAttribute("bookId", bookId);

		return "bookSearchResults";
	}
	
	
		
	@RequestMapping(value="/reviews/{bookId}", method = RequestMethod.GET)
	public @ResponseBody BookReview getBooksForBookId(@PathVariable String bookId, Principal principal) {
		
		BookReview book = bookService.findReviewsForBookService(bookId);
		
		bookService.insertBook(bookId);
		
		 final String currentUser = principal.getName();
		 System.out.println("userrr::" + currentUser);
		
		bookService.mapBookAndUser(bookId, currentUser);
			
		return book;
	}
	
	@RequestMapping(value="recommended", method = RequestMethod.GET)
	public @ResponseBody BookRecommendationModelList getRecommendedBooks(Principal principal) {
		
		 final String currentUser = principal.getName();
		 System.out.println("userrr::" + currentUser);
		
		 
		 BookRecommendationModelList books = bookService.getViewedBooks(currentUser);
		 
		/*BookRecommendationModelList book = bookService.findReviewsForBookService(bookId);*/
		
		 return books;
	}
	 
}
