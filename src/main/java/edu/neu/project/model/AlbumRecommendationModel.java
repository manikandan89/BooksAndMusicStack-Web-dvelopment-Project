package edu.neu.project.model;

import com.wrapper.spotify.models.Album;
import com.wrapper.spotify.models.Track;

public class AlbumRecommendationModel {
	
	private AlbumSpotifyModel album;
	private String recommendedBy;
	
	
	public AlbumSpotifyModel getAlbum() {
		return album;
	}
	public void setAlbum(AlbumSpotifyModel album2) {
		this.album = album2;
	}
	public String getRecommendedBy() {
		return recommendedBy;
	}
	public void setRecommendedBy(String recommendedBy) {
		this.recommendedBy = recommendedBy;
	}


}
