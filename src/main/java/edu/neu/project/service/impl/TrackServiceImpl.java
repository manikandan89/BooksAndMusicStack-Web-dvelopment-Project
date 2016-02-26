package edu.neu.project.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.AlbumSearchRequest;
import com.wrapper.spotify.methods.TrackRequest;
import com.wrapper.spotify.methods.TracksRequest;
import com.wrapper.spotify.models.Album;
import com.wrapper.spotify.models.Image;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.SimpleAlbum;
import com.wrapper.spotify.models.Track;

import edu.neu.project.model.FavouriteTrack;
import edu.neu.project.model.FriendMapper;
import edu.neu.project.model.SpotifyAuthentication;
import edu.neu.project.model.TrackRecommendation;
import edu.neu.project.model.TrackSpotifyModel;
import edu.neu.project.model.User;
import edu.neu.project.model.UserModel;
import edu.neu.project.repository.TrackRepository;
import edu.neu.project.repository.UserRepository;
import edu.neu.project.service.util.MusicService;
import edu.neu.project.service.util.TrackService;
import edu.neu.project.util.SpotifyUtil;

@Service
@Transactional
public class TrackServiceImpl implements TrackService {
	
	Api api = Api.builder()
			  .clientId(SpotifyAuthentication.getClientId())
			  .clientSecret(SpotifyAuthentication.getSecretId())
			  .redirectURI("<your_redirect_uri>")
			  .build();
	
	 @Autowired
	private TrackRepository trackRepository;
	 
	 @Autowired
	private UserRepository userRepository;
	
	 

	@Override
	public TrackSpotifyModel findTrack(String trackId) {
		if(trackId == null) {
			return null;
		}
		
		TrackSpotifyModel model = SpotifyUtil.findTrackById(trackId);
		
		return model;
	}

	@Override
	public void addTrackService(edu.neu.project.model.TrackModel track) {
	
			trackRepository.addTrackRepository(track);
	
		
	}

	@Override
	public void mapUserAndTrackService(String username, edu.neu.project.model.TrackModel track) {
		
		if (track.getTrackId() == null || username == null) {
			return;
		}
		edu.neu.project.model.TrackModel newTrack = trackRepository.getTrackByTrackId(track.getTrackId());
		System.out.println("autotrackId:::" + newTrack.getId());
		if(userRepository == null) {
			System.out.println("user rep is null");
		}
		User newUser = userRepository.getUserByName(username);
		
		FavouriteTrack trackFavourite = new FavouriteTrack();
		trackFavourite.setUser(newUser);
		trackFavourite.setTrack(newTrack);
		
		Set<FavouriteTrack> trackList = newUser.getFavoriteTrackList();
		if (trackList == null) {
			trackList = new HashSet<FavouriteTrack>();
			trackList.add(trackFavourite);
		} else {
			trackList.add(trackFavourite);
		}
		newUser.setFavoriteTrackList(trackList);
		
		Set<FavouriteTrack> userList = newTrack.getUsers();
		if (userList == null) {
			userList = new HashSet<FavouriteTrack>();
			userList.add(trackFavourite);
		} else {
			userList.add(trackFavourite);
		}
		newTrack.setUsers(userList);
		
		trackRepository.insertFavouriteTrack(trackFavourite);
		
	}

	@Override
	public List<TrackSpotifyModel> findAllFavTracksFortheUser(String username) {
		
		
		if (username == null) {
			return null;
		}
		
		User newUser = userRepository.getUserByName(username);
		
		Set<FavouriteTrack> tracksFav = newUser.getFavoriteTrackList();
		
		ArrayList<String> trackIdList = new ArrayList<String>();
		for(FavouriteTrack ft : tracksFav) {
			if (ft != null) {
				System.out.println(ft.getTrack().getTrackId());
				trackIdList.add(ft.getTrack().getTrackId());
			}
		}
		
		List<TrackSpotifyModel> tracks = new ArrayList<TrackSpotifyModel>();
		for (String tr : trackIdList) {
			
			TrackSpotifyModel track = findTrack(tr);
			tracks.add(track);
		}
		
			return tracks;
		
	
	}

	@Override
	public void insertRecommendation(String currentUser, UserModel userRecommendRecepient, String trackId) {
		
		if (currentUser == null || userRecommendRecepient == null || trackId == null) {
			return;
		}
		
		User currentUserObj = userRepository.getUserByName(currentUser);
		User recepientUserObj = userRepository.getUserById(userRecommendRecepient.getUserId());
		
		TrackRecommendation recommendation = new TrackRecommendation();
		
		recommendation.setTrRecommender(currentUserObj);
		recommendation.setTrReceiver(recepientUserObj);
		recommendation.setTrackId(trackId);
		
		trackRepository.persistTrackRecommendation(recommendation);
		
		Set<TrackRecommendation> recommenderList = currentUserObj.getTrRecommenderList();
		if (recommenderList == null) {
			recommenderList = new HashSet<TrackRecommendation>();
			recommenderList.add(recommendation);
		} else {
			recommenderList.add(recommendation);
		}
		currentUserObj.setTrRecommenderList(recommenderList);
		
		Set<TrackRecommendation> receiverList = recepientUserObj.getTrReceiverList();
		if (receiverList == null) {
			receiverList = new HashSet<TrackRecommendation>();
			receiverList.add(recommendation);
		} else {
			receiverList.add(recommendation);
		}
		recepientUserObj.setTrReceiverList(receiverList);
	}

}
