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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrapper.spotify.models.*;

import edu.neu.project.model.AlbumModel;
import edu.neu.project.model.AlbumSpotifyModel;
import edu.neu.project.model.Book;
import edu.neu.project.model.Music;
import edu.neu.project.model.SpotifyAuthentication;
import edu.neu.project.model.TrackSpotifyModel;
import edu.neu.project.service.util.HomeService;
import edu.neu.project.service.util.MusicService;
import edu.neu.project.util.SpotifyUtil;

@Controller
@RequestMapping("/user/music/")
public class MusicController {

	private static final Logger logger = LoggerFactory
			.getLogger(MusicController.class);
	
	private MusicService musicService;
	
	 @Autowired
	    public MusicController(MusicService musicService) {
	        this.musicService = musicService;
	    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String music(Locale locale, Model model) {
		logger.info("Music Controller called", locale);

	

		return "music";
	}
	
	/*@RequestMapping("album")
	public @ResponseBody List<SimpleAlbum> getAlbum(@RequestParam String input) {
		logger.info("ALBUM NAME ::: " + input);
		List<SimpleAlbum> simpleAlbums = musicService.findAlbum(input);
			
		return simpleAlbums;
	}*/
	
	@RequestMapping("album")
	public @ResponseBody List<AlbumSpotifyModel> getAlbum(@RequestParam String input) {
		logger.info("ALBUM NAME ::: " + input);
		
		List<AlbumSpotifyModel> models = musicService.findAlbum(input);
			
		return models;
	}
	
	@RequestMapping(value="/tracks/{albumId}", method = RequestMethod.GET)
	public @ResponseBody List<TrackSpotifyModel> getTracksForAlbumId(@PathVariable String albumId) {
		
		List<TrackSpotifyModel> tracks = musicService.findTracksForAlbumService(albumId);
			
		return tracks;
	}
	
	/*@RequestMapping(value="tracks", method = RequestMethod.GET)
	public List<TrackSpotifyModel> getTracksForAlbum(@RequestBody edu.neu.project.model.AlbumSpotifyModel album) {

	
	
	}*/
	
	@RequestMapping(value="/{albumId}", method = RequestMethod.GET)
	public String getTrackModel(@PathVariable String albumId, Model model) {
		
		model.addAttribute("albumId", albumId);

		return "track";
	}

	
	@RequestMapping(value="latest")
	public @ResponseBody List<AlbumSpotifyModel> getLatestAlbums(HttpSession session) {
		
		SpotifyAuthentication auth = (SpotifyAuthentication) session.getAttribute("access");
		if (SpotifyAuthentication.getToken() == null || SpotifyUtil.isAccessTokenCallNecessary(auth)) {
			auth = SpotifyUtil.getSpotifyAccessToken();
			if (auth == null) {
				logger.error("Access token retrieval failure");
			}
			session.setAttribute("access",new SpotifyAuthentication());
		} 
		
		List<AlbumSpotifyModel> simpleAlbums = musicService.findLatestAlbumsService(auth);
			
		return simpleAlbums;
	}
	

	
	/*@RequestMapping(value="/{albumId}", method = RequestMethod.POST)
	public void addAlbum(@PathVariable String albumId) {
		System.out.println("ALBUMMMID::" + albumId);
		musicService.addAlbumService(albumId);
			
	}*/
	
	 @RequestMapping(method = RequestMethod.POST)
		public @ResponseBody AlbumModel addTrackAndMapUserFavourite(@RequestBody edu.neu.project.model.AlbumModel album,Principal principal) {

		 	musicService.addAlbumService(album);  // Gets the album for the track and then inserts the album in the database and returns it
		 	
		 	 final String currentUser = principal.getName();
			 System.out.println("userrr::" + currentUser);
		 
			 musicService.mapUserAndAlbumService(currentUser,album);
			 
			 return album;
		
		}
	
	 @RequestMapping(value="favourites", method = RequestMethod.GET)
		public @ResponseBody List<AlbumSpotifyModel> getFavouriteAlbums(Principal principal) {
		 
		 final String currentUser = principal.getName();
		 System.out.println("userrr::" + currentUser);
			
			List<AlbumSpotifyModel> albums = musicService.findAllFavAlbumsFortheUser(currentUser);
				
			return albums;
		}
	 
	 @RequestMapping(value="recommend/{albumId}", method = RequestMethod.GET)
		public String getRecommendPage(@PathVariable String albumId, Model model) {
			
			model.addAttribute("albumId", albumId);

			return "recommendAlbum";
		}
	 
	 @RequestMapping(value="recommend/{albumId}",method = RequestMethod.POST)
		public @ResponseBody edu.neu.project.model.UserModel recommendTrack(@RequestBody edu.neu.project.model.UserModel userRecommendRecepient, @PathVariable String albumId, Principal principal) {
		   
		 	 final String currentUser = principal.getName();
			 System.out.println("userrr::" + currentUser);

			 musicService.insertRecommendation(currentUser,userRecommendRecepient,albumId);
			 
			return userRecommendRecepient;
		}
}
