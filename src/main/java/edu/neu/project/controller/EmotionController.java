package edu.neu.project.controller;

import java.util.ArrayList;
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

import edu.neu.project.model.Book;
import edu.neu.project.model.CurrentEmotionModel;
import edu.neu.project.model.SpotifyAuthentication;
import edu.neu.project.model.TrackEmotionModel;
import edu.neu.project.service.util.BookService;
import edu.neu.project.service.util.EmotionService;
import edu.neu.project.service.util.MusicService;
import edu.neu.project.util.EmotionUtil;
import edu.neu.project.util.SpotifyUtil;

@Controller
@RequestMapping("/user/emotion/")
public class EmotionController {

	private static final Logger logger = LoggerFactory
			.getLogger(EmotionController.class);
	
	private EmotionService emotionService;
	private BookService bookService;
	
	 @Autowired
	    public EmotionController(EmotionService emotionService, BookService bookService) {
	        this.emotionService = emotionService;
	        this.bookService = bookService;
	    }
	 
	 @RequestMapping(method = RequestMethod.GET)
		public String emotionDialogPage(Locale locale, Model model) {
			logger.info("Emotion Controller called", locale);

			//Session get
			return "emotion";
		}
	 
	 
	 @RequestMapping(value="music/{emotion}", method = RequestMethod.GET)
		public String  emotionResultsPage(@PathVariable String emotion, Model model, HttpSession session) {
			
		 	model.addAttribute("emotion", emotion);
		 	
		 	CurrentEmotionModel currentEmotionModel =  new CurrentEmotionModel();
		 	currentEmotionModel.setCurrentEmotion(emotion);
			session.setAttribute("emotion", currentEmotionModel);
			
			return "emotionResultsMusic";
		}
	 
	 
	 @RequestMapping(value="music/results/{emotion}", method = RequestMethod.GET)
		public @ResponseBody List<TrackEmotionModel> getTracksForEmotion(@PathVariable String emotion, HttpSession session) {
		 
		 SpotifyAuthentication auth = (SpotifyAuthentication) session.getAttribute("access");
			if (SpotifyAuthentication.getToken() == null || SpotifyUtil.isAccessTokenCallNecessary(auth)) {
				auth = SpotifyUtil.getSpotifyAccessToken();
				if (auth == null) {
					logger.error("Access token retrieval failure");
				}
				session.setAttribute("access",new SpotifyAuthentication());
			} 
			
		 System.out.println("Incoming emotion for music is ::" + emotion);
		 	String[] musicKeywords = EmotionUtil.getMusicKeywordsForEmotion(emotion);
		 	for (String key : musicKeywords) {
		 		//System.out.println(key);
		 	}
		 	
		 	List<TrackEmotionModel> tracks = emotionService.getTracksForEmotionService(musicKeywords);
		 	
		 	return tracks;
		}
	 
	 @RequestMapping(value="book/{emotion}", method = RequestMethod.GET)
		public String  emotionResultsPageBook(@PathVariable String emotion, Model model, HttpSession session) {
			
		 	model.addAttribute("emotion", emotion);
		 	
		 	CurrentEmotionModel currentEmotionModel =  new CurrentEmotionModel();
		 	currentEmotionModel.setCurrentEmotion(emotion);
			session.setAttribute("emotion", currentEmotionModel);
			
			return "emotionResultsBook";
		}
	 
	 @RequestMapping(value="book/results/{emotion}", method = RequestMethod.GET)
		public @ResponseBody List<Book> getBooksForEmotion(@PathVariable String emotion) {
		 
		 	System.out.println("Incoming emotion for book is ::" + emotion);
		 	System.out.println("getBooksForSearchQuery for emotion called");
			
			List<Book> books = bookService.findBookServiceForSearchQuery(emotion,"genre");
				
			return books;
		 	
		}
	 
	
}
