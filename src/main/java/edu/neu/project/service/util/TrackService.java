package edu.neu.project.service.util;

import java.util.List;

import com.wrapper.spotify.models.Track;

import edu.neu.project.model.TrackSpotifyModel;
import edu.neu.project.model.User;
import edu.neu.project.model.UserModel;



public interface TrackService {
	
	public TrackSpotifyModel findTrack(String trackId);
	public void addTrackService(edu.neu.project.model.TrackModel track);
	public void mapUserAndTrackService(String username, edu.neu.project.model.TrackModel track);
	public List<TrackSpotifyModel> findAllFavTracksFortheUser(String username);
	public void insertRecommendation(String currentUser, UserModel userRecommendRecepient, String trackId);
}
