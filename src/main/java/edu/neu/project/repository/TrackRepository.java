package edu.neu.project.repository;

import java.util.List;

import edu.neu.project.model.FavouriteTrack;
import edu.neu.project.model.TrackModel;
import edu.neu.project.model.TrackRecommendation;
import edu.neu.project.model.User;


public interface TrackRepository {
	
	public void addTrackRepository(TrackModel track);
	public TrackModel getTrackByTrackId(String trackId);
	public void insertFavouriteTrack(FavouriteTrack trackFavourite);
	public List<String> getTrackIdsForIds(List<Integer> idList);
	public void persistTrackRecommendation(TrackRecommendation recommendation);
	public List<TrackRecommendation> getRecommendationForUser(User user);

}
