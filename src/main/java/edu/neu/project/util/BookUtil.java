package edu.neu.project.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import edu.neu.project.model.Book;
import edu.neu.project.model.BookMap;
import edu.neu.project.model.BookReview;
import edu.neu.project.model.Results;
import edu.neu.project.model.Search;

public class BookUtil {
	
	private static String bookSearchUrlByTitle = "https://www.goodreads.com/search.xml[title]?key=zPb0Yf71k5yLcqANoVs8g&q=";
	private static String bookReviewsUrlFirstPart = "https://www.goodreads.com/book/show/";
	private static String bookReviewsUrlSecondPart = "?format=xml&key=zPb0Yf71k5yLcqANoVs8g";
	
	//private static String bookReviewsUrlFirstPart = "https://www.goodreads.com/book/title.xml?key=zPb0Yf71k5yLcqANoVs8g&title=";
//	private static String bookReviewsUrlSecondPart = "&key=zPb0Yf71k5yLcqANoVs8g&title=";
	private static String bookSearchUrlByGenre = "https://www.goodreads.com/search.xml[genre]?key=zPb0Yf71k5yLcqANoVs8g&q=";
	
	public static List<Book> getListOfBooksForQuery(String query, String category) {
		if (query == null || query.length() == 0) {
			System.out.println("Empty query string for the books");
			return null;
		}
		String apiUrl = "";
		if (category.equalsIgnoreCase("title")) {
			apiUrl = bookSearchUrlByTitle;
		} else {
			apiUrl = bookSearchUrlByGenre;
		}
		StringBuilder builder = new StringBuilder();
		builder.append(apiUrl);
		builder.append(query);
		String url = builder.toString();
		
		try {
			url = url.replaceAll(" ", "%20");
 			List<Book> books = new ArrayList<Book>();
    		URL urlModel = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) urlModel.openConnection();
			connection.setRequestMethod("GET");
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while((inputLine = br.readLine()) != null) {
				buffer.append(inputLine);
			}
			br.close();
			if (buffer.toString() == null || buffer.toString().length() == 0) {
				return null;
			}
			
			StringReader reader = new StringReader(buffer.toString());
			JAXBContext jaxbContext = JAXBContext.newInstance(BookMap.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			BookMap bookMap = (BookMap) jaxbUnmarshaller.unmarshal(reader);
			Search search = bookMap.getSearch();
			if (search != null) {
				Results results = search.getResults();
				if (results != null) {
					books = results.getBooks();
				} else {
					System.out.println("Results element is null when trying to retrieve books");
				}
			} else {
				System.out.println("Search element is null when trying to retrieve books");
			}
			return books;
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
		return null;
	}
	
	public static BookReview findReviewsForBook(String bookId) {
		if (bookId == null) {
			System.out.println("Empty booKId string for the books");
			return null;
		} 
		StringBuilder builder = new StringBuilder();
		builder.append(bookReviewsUrlFirstPart);
		builder.append(bookId);
		builder.append(bookReviewsUrlSecondPart);
		
		String url = builder.toString();
		System.out.println("URL:::" + url);
		try {
 			List<Book> books = new ArrayList<Book>();
    		URL urlModel = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) urlModel.openConnection();
			connection.setRequestMethod("GET");
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while((inputLine = br.readLine()) != null) {
				buffer.append(inputLine);
			}
			br.close();
			if (buffer.toString() == null || buffer.toString().length() == 0) {
				return null;
			}
			//4259809 https://www.goodreads.com/book/show/4259809?format=xml&key=zPb0Yf71k5yLcqANoVs8g
			StringReader reader = new StringReader(buffer.toString());
			JAXBContext jaxbContext = JAXBContext.newInstance(BookMap.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			BookMap bookMap = (BookMap) jaxbUnmarshaller.unmarshal(reader);
			BookReview book = bookMap.getBook();
		
			return book;
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
		return null;
	}

}
