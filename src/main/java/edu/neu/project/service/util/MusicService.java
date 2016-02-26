package edu.neu.project.service.util;

import java.util.List;

import com.wrapper.spotify.models.*;

import edu.neu.project.model.AlbumModel;
import edu.neu.project.model.AlbumSpotifyModel;
import edu.neu.project.model.SpotifyAuthentication;
import edu.neu.project.model.TrackModel;
import edu.neu.project.model.TrackSpotifyModel;
import edu.neu.project.model.UserModel;


public interface MusicService {

	
	public List<AlbumSpotifyModel> findAlbum(String album);

	public List<TrackSpotifyModel> findTracksForAlbumService(String albumId);
	
	public List<AlbumSpotifyModel> findLatestAlbumsService(SpotifyAuthentication auth);
	
	public void addAlbumService(AlbumModel album);

	public void mapUserAndAlbumService(String currentUser, AlbumModel album);

	public AlbumSpotifyModel findAlbumForFav(String albumId);

	public List<AlbumSpotifyModel> findAllFavAlbumsFortheUser(String username);

	public void insertRecommendation(String currentUser, UserModel userRecommendRecepient, String albumId);

	
}
