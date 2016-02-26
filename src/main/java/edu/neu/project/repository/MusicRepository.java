package edu.neu.project.repository;

import java.util.List;

import edu.neu.project.model.AlbumModel;
import edu.neu.project.model.AlbumRecommendation;
import edu.neu.project.model.FavouriteAlbum;
import edu.neu.project.model.User;

public interface MusicRepository {
	
	public void addAlbumRepository(AlbumModel album);

	public AlbumModel getAlbumByAlbumId(String albumId);

	public void insertFavouriteAlbum(FavouriteAlbum albumFavourite);

	public void persistAlbumRecommendation(AlbumRecommendation recommendation);

	public List<AlbumRecommendation> getRecommendationForUser(User user);


}
