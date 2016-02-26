package edu.neu.project.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.*;
import com.wrapper.spotify.models.*;

import edu.neu.project.model.AlbumModel;
import edu.neu.project.model.AlbumRecommendation;
import edu.neu.project.model.AlbumSpotifyModel;
import edu.neu.project.model.FavouriteAlbum;
import edu.neu.project.model.FavouriteTrack;
import edu.neu.project.model.Music;
import edu.neu.project.model.SpotifyAuthentication;
import edu.neu.project.model.TrackModel;
import edu.neu.project.model.TrackRecommendation;
import edu.neu.project.model.TrackSpotifyModel;
import edu.neu.project.model.User;
import edu.neu.project.model.UserModel;
import edu.neu.project.repository.MusicRepository;
import edu.neu.project.repository.UserRepository;
import edu.neu.project.service.util.*;
import edu.neu.project.util.SpotifyUtil;

@Service
@Transactional
public class MusicServiceImpl implements MusicService {
	
	Api api = Api.builder()
			  .clientId(SpotifyAuthentication.getClientId())
			  .clientSecret(SpotifyAuthentication.getSecretId())
			  .redirectURI("<your_redirect_uri>")
			  .build();
	
	@Autowired
	MusicRepository musicRepository;
	
	@Autowired
	UserRepository userRepository;

/*	@Override
	public List<AlbumSpotifyModel> findAlbum(String album) {
		
		List<SimpleAlbum> simpleAlbums = new ArrayList<SimpleAlbum>();
		final AlbumSearchRequest request = api.searchAlbums(album).offset(0).build();

		try {
		   final Page<SimpleAlbum> albumSearchResult = request.get();

		   System.out.println("Printing albums..");
		   for (SimpleAlbum simpleAlbum : albumSearchResult.getItems()) {
			   simpleAlbums.add(simpleAlbum);
		    // System.out.println(simpleAlbum.getName());
		   }
		   return simpleAlbums;
		} catch (Exception e) {
		   System.out.println("Something went wrong!" + e.getMessage());
		}
		return null;
	}*/
	
	@Override
	public List<AlbumSpotifyModel> findAlbum(String album) {
		
		if (album == null) {
			return null;
		}
		
		List<AlbumSpotifyModel> models = SpotifyUtil.findAlbumsForSearch(album);
		return models;
	}

	/*@Override
	public List<TrackSpotifyModel> findTracksForAlbumService(String albumId) {
		
		Album album = SpotifyUtil.getAlbumDetailsForAlbumId(albumId);
		List<SimpleTrack> simpleTracks = new ArrayList<SimpleTrack>();
		final TracksForAlbumRequest trackRequest = api.getTracksForAlbum(albumId).build();
		System.out.println("Tracks...");
		try {
		   final Page<SimpleTrack> simpleTrackPage = trackRequest.get();
		   for (SimpleTrack simpleTrack : simpleTrackPage.getItems()) {
			   	System.out.println(simpleTrack.getName());
			   	simpleTrack.setAlbumName(album.getName());
			   	simpleTrack.setImages(album.getImages());
			   	simpleTracks.add(simpleTrack);
			}
		   return simpleTracks;
		} catch (Exception e) {
		   System.out.println("Something went wrong!" + e.getMessage());
		}
		
		return null;
	}*/
	
	@Override
	public List<TrackSpotifyModel> findTracksForAlbumService(String albumId) {
		
		if(albumId == null) {
			return null;
		}
		
		AlbumSpotifyModel album = SpotifyUtil.getAlbumForAlbumId(albumId);
		List<TrackSpotifyModel>  models = SpotifyUtil.getTracksForAlbum(album, albumId);
		return models;
	}

/*	@Override
	public List<SimpleAlbum> findLatestAlbumsService(SpotifyAuthentication auth) {
			
			System.out.println("token::" + SpotifyAuthentication.getToken());
			Api newapi = Api.builder().accessToken(SpotifyAuthentication.getToken()).build();
			
			
			
			List<SimpleAlbum> latestAlbums = new ArrayList<SimpleAlbum>();
			final NewReleasesRequest request = newapi.getNewReleases()
				    .limit(15)
				    .offset(0)
				    .build();

				try {
				    NewReleases newReleases = request.get();
				    Page<SimpleAlbum> albums = newReleases.getAlbums();

				    for (SimpleAlbum simpleAlbum : albums.getItems()) {
				    	System.out.println(simpleAlbum.getName());
						   latestAlbums.add(simpleAlbum);
				    }
				    return latestAlbums;
				} catch(Exception e) {
					e.printStackTrace();
				    System.out.println("Something went wrong! " + e.getMessage());
				}
			return null;
	}*/
	
	@Override
	public List<AlbumSpotifyModel> findLatestAlbumsService(SpotifyAuthentication auth) {
			
			System.out.println("token::" + SpotifyAuthentication.getToken());
			
			List<AlbumSpotifyModel> models = SpotifyUtil.getLatestAlbums();
			
			return models;
	}

	@Override
	public void addAlbumService(AlbumModel album) {
		if(album == null) {
			return ;
		}
		/*final TrackRequest request = api.getTrack(trackModel.getTrackId()).build();

		try {
		   final Track track = request.get();
		   SimpleAlbum album = track.getAlbum();
		   
		   String albumId = album.getId();
		   AlbumModel albumModel = new AlbumModel();
		   albumModel.setAlbumId(albumId);*/
		   
		  musicRepository.addAlbumRepository(album);
		   
		/*   return newAlbumModel;
		} catch (Exception e) {
		   System.out.println("Something went wrong!" + e.getMessage());
		}
		
		return null;*/
	}

	@Override
	public void mapUserAndAlbumService(String username, AlbumModel album) {
		
		if (album.getAlbumId() == null || username == null) {
			return;
		}
		edu.neu.project.model.AlbumModel newAlbum = musicRepository.getAlbumByAlbumId(album.getAlbumId());
		System.out.println("autoAlbumId:::" + newAlbum.getId());
		
		User newUser = userRepository.getUserByName(username);
		
		FavouriteAlbum albumFavourite = new FavouriteAlbum();
		albumFavourite.setUser(newUser);
		albumFavourite.setAlbum(newAlbum);
		
		Set<FavouriteAlbum> albumList = newUser.getFavoriteAlbumList();
		
		albumList.add(albumFavourite);
		
		newUser.setFavoriteAlbumList(albumList);
		
		Set<FavouriteAlbum> userList = newAlbum.getUsers();
		
		userList.add(albumFavourite);
		
		newAlbum.setUsers(userList);
		
		musicRepository.insertFavouriteAlbum(albumFavourite);
		
	}
	
	@Override
	public List<AlbumSpotifyModel> findAllFavAlbumsFortheUser(String username) {
	
		
		if (username == null) {
			return null;
		}
		
		User newUser = userRepository.getUserByName(username);
		
		Set<FavouriteAlbum> albumsFav = newUser.getFavoriteAlbumList();
		
		ArrayList<String> albumIdList = new ArrayList<String>();
		for(FavouriteAlbum fa : albumsFav) {
			if (fa != null) {
				System.out.println(fa.getAlbum().getAlbumId());
				albumIdList.add(fa.getAlbum().getAlbumId());
			}
		}
		
		List<AlbumSpotifyModel> albums = new ArrayList<AlbumSpotifyModel>();
		for (String al : albumIdList) {
			
			AlbumSpotifyModel album = findAlbumForFav(al);
			albums.add(album);
		}
		
			return albums;
		
	
	}
	
	@Override
	public AlbumSpotifyModel findAlbumForFav(String albumId) {
		
		if (albumId == null) {
			return null;
		}
		
		AlbumSpotifyModel model = SpotifyUtil.getAlbumForAlbumId(albumId);
		return model;
	}

	@Override
	public void insertRecommendation(String currentUser, UserModel userRecommendRecepient, String albumId) {
		
		if (currentUser == null || userRecommendRecepient == null || albumId == null) {
			return;
		}
		
		User currentUserObj = userRepository.getUserByName(currentUser);
		User recepientUserObj = userRepository.getUserById(userRecommendRecepient.getUserId());
		
		AlbumRecommendation recommendation = new AlbumRecommendation();
		
		recommendation.setAlRecommender(currentUserObj);
		recommendation.setAlReceiver(recepientUserObj);
		recommendation.setAlbumId(albumId);
		
		musicRepository.persistAlbumRecommendation(recommendation);
		
		Set<AlbumRecommendation> recommenderList = currentUserObj.getAlRecommenderList();
		if (recommenderList == null) {
			recommenderList = new HashSet<AlbumRecommendation>();
			recommenderList.add(recommendation);
		} else {
			recommenderList.add(recommendation);
		}
		currentUserObj.setAlRecommenderList(recommenderList);
		
		Set<AlbumRecommendation> receiverList = recepientUserObj.getAlReceiverList();
		if (receiverList == null) {
			receiverList = new HashSet<AlbumRecommendation>();
			receiverList.add(recommendation);
		} else {
			receiverList.add(recommendation);
		}
		recepientUserObj.setAlReceiverList(receiverList);
		
	}
	

}
