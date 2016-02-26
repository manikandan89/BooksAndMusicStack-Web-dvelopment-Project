package edu.neu.project.model;

import java.util.List;

import com.wrapper.spotify.models.Track;

public class TrackRecommendationModel {
	
	private TrackSpotifyModel track;
	private String recommendedBy;
	
	
	public TrackSpotifyModel getTrack() {
		return track;
	}
	public void setTrack(TrackSpotifyModel track2) {
		this.track = track2;
	}
	public String getRecommendedBy() {
		return recommendedBy;
	}
	public void setRecommendedBy(String recommendedBy) {
		this.recommendedBy = recommendedBy;
	}

}
