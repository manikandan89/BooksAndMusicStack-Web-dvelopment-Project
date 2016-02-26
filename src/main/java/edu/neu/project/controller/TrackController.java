package edu.neu.project.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrapper.spotify.models.SimpleTrack;
import com.wrapper.spotify.models.Track;

import edu.neu.project.model.TrackModel;
import edu.neu.project.model.TrackSpotifyModel;
import edu.neu.project.model.User;
import edu.neu.project.service.util.MusicService;
import edu.neu.project.service.util.TrackService;

@Controller
@RequestMapping("/user/track/")
public class TrackController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(MusicController.class);
	
	private TrackService trackService;
	
	 @Autowired
	    public TrackController(TrackService trackService) {
	        this.trackService = trackService;
	    }
	 
	 @RequestMapping(value="/{trackId}", method = RequestMethod.GET)
		public String getTrackPage(@PathVariable String trackId, Model model) {
			
			model.addAttribute("trackId", trackId);

			return "playTrack";
		}
	 
	 @RequestMapping(value="/play/{trackId}", method = RequestMethod.GET)
		public @ResponseBody TrackSpotifyModel getTrackForId(@PathVariable String trackId) {
			
		 TrackSpotifyModel track = trackService.findTrack(trackId);
				
			return track;
		}
	 
	 @RequestMapping(method = RequestMethod.POST)
		public @ResponseBody TrackModel addTrackAndMapUserFavourite(@RequestBody edu.neu.project.model.TrackModel track,Principal principal) {
		 	
			/*UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
			System.out.println(userDetails.getUsername());*/
		
		 
//		 	/track.setFavo(null);
		 	trackService.addTrackService(track);  // Adds the track to the database
		 	
		 	 final String currentUser = principal.getName();
			 System.out.println("userrr::" + currentUser);
		 
		 
	/*		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails details = (UserDetails) auth.getDetails();
			System.out.println(details.getUsername());
			System.out.println(auth.getPrincipal());
			Object myUser = (auth != null) ? auth.getPrincipal() :  null;
		
			if (myUser instanceof User) {
				System.out.println("Inside authentication");
			     User user = (User) myUser;  */  
			     trackService.mapUserAndTrackService(currentUser,track);
			     
			//}
			
		
			return	track;
		}
	 
	 
	 @RequestMapping(value="favourites", method = RequestMethod.GET)
		public @ResponseBody List<TrackSpotifyModel> getFavouriteTracks(Principal principal) {
		 
		 final String currentUser = principal.getName();
		 System.out.println("userrr::" + currentUser);
			
			List<TrackSpotifyModel> tracks= trackService.findAllFavTracksFortheUser(currentUser);
				
			return tracks;
		}
	 
	 @RequestMapping(value="recommend/{trackId}", method = RequestMethod.GET)
		public String getRecommendPage(@PathVariable String trackId, Model model) {
			
			model.addAttribute("trackId", trackId);

			return "recommendTrack";
		}
	 
	 @RequestMapping(value="recommend/{trackId}",method = RequestMethod.POST)
		public @ResponseBody edu.neu.project.model.UserModel  recommendTrack(@RequestBody edu.neu.project.model.UserModel userRecommendRecepient, @PathVariable String trackId, Principal principal) {
		   
		 	 final String currentUser = principal.getName();
			 System.out.println("userrr::" + currentUser);
 
			 trackService.insertRecommendation(currentUser,userRecommendRecepient,trackId);
			 
			 return userRecommendRecepient;
			
		}
	 
}
