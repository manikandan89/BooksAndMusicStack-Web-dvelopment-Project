package edu.neu.project.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.AlbumRequest;
import com.wrapper.spotify.models.Album;

import edu.neu.project.model.Book;
import edu.neu.project.model.BookMap;
import edu.neu.project.model.BookTestModel;
import edu.neu.project.model.Employee;
import edu.neu.project.model.Results;
import edu.neu.project.model.Search;
import edu.neu.project.model.SpotifyAuthentication;

@Controller
@RequestMapping("/test/")
public class TestController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(TestController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome to the Test Controller home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		System.out.println("Testing.");
		return "test";
	}
	
	@RequestMapping(value="view", method = RequestMethod.GET)
	public @ResponseBody Set<Employee> getPerson() {
		
		Set<Employee> employees = new HashSet<Employee>();
		Employee person = new Employee();
		Employee another = new Employee();
		another.setId(1);
		another.setFirstName("Mani");
		another.setLastName("Nagarajan");
		
		person.setId(2);
		person.setFirstName("Another");
		person.setLastName("Employee");
		
		employees.add(person);
		employees.add(another);
		return employees;
	}
	
	@RequestMapping(value="spotify", method = RequestMethod.GET)
	public @ResponseBody Album getSpotifyAlbum() {
		
		Api api = Api.builder()
				  .clientId(SpotifyAuthentication.getClientId())
				  .clientSecret(SpotifyAuthentication.getSecretId())
				  .redirectURI("<your_redirect_uri>")
				  .build();
		
		final String albumId = "0sNOF9WDwhWunNAHPD3Baj";
		final AlbumRequest request = api.getAlbum(albumId).build();

		try {
		   final Album album = request.get();
		   System.out.println("Retrieved album " + album.getName());
		   System.out.println("Its popularity is " + album.getPopularity()); 
		   return album;
		} catch (Exception e) {
		   System.out.println("Something went wrong!" + e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value="goodreads", method = RequestMethod.GET)
	public @ResponseBody List<BookTestModel> getGoodReadsDetails() {
		
		
		StringBuilder builder = new StringBuilder();
		builder.append("https://www.goodreads.com/search/index.xml?key=zPb0Yf71k5yLcqANoVs8g&q=history");
		//builder.append(query);
		String url = builder.toString();
		try {
 			List<Book> books = new ArrayList<Book>();
 			List<BookTestModel> models = new ArrayList<BookTestModel>();
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
			if (books != null && books.size() > 0) {
				for (Book book : books) {
					if (book != null) {
						BookTestModel model = new BookTestModel();
						model.setAverage_rating(book.getAverage_rating());
						model.setId(book.getId());
						models.add(model);
					} else {
						System.out.println("book is null");
					}
				}
			} else {
				System.out.println("books is null");
			}
			return models;
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
		return null;
	}
	
	
	
	
}
