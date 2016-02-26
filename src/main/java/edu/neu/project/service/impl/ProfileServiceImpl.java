package edu.neu.project.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.TracksRequest;
import com.wrapper.spotify.models.Album;
import com.wrapper.spotify.models.Track;

import edu.neu.project.model.AlbumRecommendation;
import edu.neu.project.model.AlbumRecommendationModel;
import edu.neu.project.model.AlbumSpotifyModel;
import edu.neu.project.model.FavouriteTrack;
import edu.neu.project.model.FriendMapper;
import edu.neu.project.model.FriendMapperModel;
import edu.neu.project.model.TrackRecommendation;
import edu.neu.project.model.TrackRecommendationModel;
import edu.neu.project.model.TrackSpotifyModel;
import edu.neu.project.model.User;
import edu.neu.project.model.UserModel;
import edu.neu.project.model.UserRoles;
import edu.neu.project.repository.MusicRepository;
import edu.neu.project.repository.TrackRepository;
import edu.neu.project.repository.UserRepository;
import edu.neu.project.service.util.MusicService;
import edu.neu.project.service.util.ProfileService;
import edu.neu.project.service.util.TrackService;
import edu.neu.project.util.SpotifyUtil;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TrackRepository trackRepository;
	
	@Autowired
	private MusicRepository musicRepository;
	
	@Autowired
	private TrackService trackService;
	
	@Autowired
	private MusicService musicService;
	
	Api api = Api.builder()
			  .clientId("<20f7c83db6d548a4aaadf057691661eb>")
			  .clientSecret("<c5366c21e94a41fbb9b73bae365e5a38>")
			  .redirectURI("<your_redirect_uri>")
			  .build();
	
	 
	@Override
	public User createUserService(User user) {
		System.out.println("Going to call user repo in service");
		
		//Defaulting favourite tracks and albums of the user to be null
		user.setFavoriteTrackList(null);
		
		User newUser = userRepository.createUser(user);
		return newUser;
	}


	@Override
	public void createUserRoleService(User user) {
		
		UserRoles role = new UserRoles();
		role.setUsername(user.getUsername());
		role.setRole("ROLE_USER");
		userRepository.addRoleToUser(role);
	}


	@Override
	public List<User> findUsers(String input, String currentUser) {
		
		if(currentUser == null || input == null) {
			return null;
		}
		
		Set<UserModel> friends = findFriendsOfUserAsList(currentUser);
		
		List<Integer> userIdList = new ArrayList<Integer>();
		
		for (UserModel friend : friends) {
			if(friend != null) {
				userIdList.add(friend.getUserId()) ;
			}
		}
		
		List<User> users = userRepository.getUsersByStringSearch(input, currentUser,userIdList);
		
		if (users == null) {
			System.out.println("Users is null");
			return null;
		} else {
			for (User user : users) {
				System.out.println(user.getUsername());
			}
		}
		return users;
	}


	@Override
	public void insertFriendRequest(String currentUserName, User recepientUser) {
		
		if (currentUserName == null) {
			return;
		}
		
		User newCurrentUser = userRepository.getUserByName(currentUserName);
		User newRecepientUser = userRepository.getUserById(recepientUser.getUserId());
		
		if(newCurrentUser == null || newRecepientUser == null) {
			return;
		}
		
		List<FriendMapper> friends = userRepository.checkFriendStatus(newCurrentUser.getUserId(), newRecepientUser.getUserId());
		
		if(friends != null && friends.size() == 1) {
			FriendMapper friend = friends.get(0);
			userRepository.updateStateToAcceptFriendRequest(friend);
		}
		
		if (newCurrentUser == null) {
			System.out.println("Friend cannot be mapped as requestUser(current user) is null");
			return;
		} else if (newRecepientUser == null) {
			System.out.println("Friend cannot be mapped as recepienttUser(select from the UI) is null");
			return;
		}
		
		FriendMapper friend = new FriendMapper();
		friend.setRequest(newCurrentUser);
		friend.setRecepient(newRecepientUser);
		
		userRepository.persistFriendRequest(friend);
		
		Set<FriendMapper> requestList = newCurrentUser.getRequestList();
		if (requestList == null) {
			requestList = new HashSet<FriendMapper>();
			requestList.add(friend);
		} else {
			requestList.add(friend);
		}
		newCurrentUser.setRequestList(requestList);
		
		Set<FriendMapper> recepientList = newRecepientUser.getRecepientList();
		if (recepientList == null) {
			recepientList = new HashSet<FriendMapper>();
			recepientList.add(friend);
		} else {
			recepientList.add(friend);
		}
		newRecepientUser.setRecepientList(recepientList);
		
/*		Set<FriendMapper> requestList = newCurrentUser.getRequestList();
		requestList.add(friend);
		newCurrentUser.setRequestList(requestList);
		
		Set<FriendMapper> recepientList = newRecepientUser.getRecepientList();
		recepientList.add(friend);
		newRecepientUser.setRecepientList(recepientList);*/
	
	}


	@Override
	public Set<FriendMapper> getRequestsGotByUser(String currentUser) {
		System.out.println("Inside getRequestsGotByUser");
		
		User newCurrentUser = userRepository.getUserByName(currentUser);
		Set<FriendMapperModel> friendModels = new HashSet<FriendMapperModel>();
		
		if (newCurrentUser == null) {
			System.out.println("newCurrentUser is null");
		}
		
		System.out.println(newCurrentUser.getEmail());
		System.out.println(newCurrentUser.getUsername());
		
		System.out.println(newCurrentUser.getUserId());
		
		if (newCurrentUser.getRequestList() != null && newCurrentUser.getRequestList().size() > 0) {
			System.out.println("request list is present");
			for (FriendMapper friend : newCurrentUser.getRequestList()) {
				System.out.println("request::" + friend.getRequest().getUsername());
				System.out.println("response::" + friend.getRecepient().getUsername());
				FriendMapperModel friendModel = new FriendMapperModel();
				friendModel.setMapId(friend.getMapId());
				/*friendModel.setRecepient(friend.getRecepient());
				friendModel.setRequest(friend.getRequest());*/
				friendModel.setState(friend.isState());
				friendModels.add(friendModel);
			}
		} else {
			System.out.println("request list is null");
		}
		
		if (newCurrentUser.getRecepientList() != null && newCurrentUser.getRecepientList().size() > 0) {
			for (FriendMapper friend : newCurrentUser.getRecepientList()) {
				System.out.println("request::" + friend.getRequest().getUsername());
				System.out.println("response::" + friend.getRecepient().getUsername());
				FriendMapperModel friendModel = new FriendMapperModel();
				friendModel.setMapId(friend.getMapId());
				/*friendModel.setRecepient(friend.getRecepient());
				friendModel.setRequest(friend.getRequest());*/
				friendModel.setState(friend.isState());
				friendModels.add(friendModel);
			}
		} else {
				System.out.println("newCurrentUser.getRecepientList() is null");
		}
		System.out.println("check3");
		return newCurrentUser.getRecepientList();
	}


	@Override
	public Set<FriendMapper> acceptFriendRequest(FriendMapperModel friendMapperModel, String currentUserName) {
		
		if (friendMapperModel != null) {
			
			FriendMapper mapper = userRepository.getMapperObjByMapId(friendMapperModel);
			userRepository.updateStateToAcceptFriendRequest(mapper);
			
			Set<FriendMapper> mappers = getRequestsGotByUser(currentUserName);
			return mappers;
		}
		return null;
	}


	@Override
	public Set<UserModel> findFriendsOfUser(String input, String currentUserName) {
		
		User user = userRepository.getUserByName(currentUserName);
		
		if (user == null) {
			System.out.println("Current User is null for findFriendsOfUser()");
			return null;
		}
		
		List<FriendMapper> mappers = userRepository.getFriendsOfUser(input,user);
		
		Set<UserModel> userModels = new HashSet<UserModel>();
		if (mappers != null && mappers.size() > 0) {
			for (FriendMapper friend : mappers) {
				System.out.println("request::" + friend.getRequest().getUsername());
				System.out.println("response::" + friend.getRecepient().getUsername());
				UserModel userModel = new UserModel();
				if (friend.getRequest().getUsername().equalsIgnoreCase(currentUserName)) {
					userModel.setUsername(friend.getRecepient().getUsername());
					userModel.setUserId(friend.getRecepient().getUserId());
				} else if (friend.getRecepient().getUsername().equalsIgnoreCase(currentUserName)) {
					userModel.setUsername(friend.getRequest().getUsername());
					userModel.setUserId(friend.getRequest().getUserId());
				} else {
					continue;
				}
				
				userModels.add(userModel);
			}
		} else {
				System.out.println("mappers is null when trying to populate friends of users for recommendation in drop down");
		}
		
		return userModels;
	}


	@Override
	public List<TrackRecommendationModel> getRecommendationsReceived(String currentUser) {
		
			if (currentUser == null) {
				return null;
			}
			
			User user = userRepository.getUserByName(currentUser);
			
			List<TrackRecommendation> trackRecommendationReceivedList = trackRepository.getRecommendationForUser(user);
			
			List<String> trackIds = new ArrayList<String>();
			
			List<TrackRecommendationModel> trackRecommendationModelList = new ArrayList<TrackRecommendationModel>();
			
			if (trackRecommendationReceivedList != null && trackRecommendationReceivedList.size() > 0) {
				
				for (TrackRecommendation tr : trackRecommendationReceivedList) {
					if (tr != null && tr.getTrackId() != null) {
						TrackRecommendationModel trackRecModel = new TrackRecommendationModel();
						TrackSpotifyModel track = trackService.findTrack(tr.getTrackId());
						trackRecModel.setTrack(track);
						trackRecModel.setRecommendedBy(tr.getTrRecommender().getUsername());
						trackRecommendationModelList.add(trackRecModel);
					}
				}	
			} else {
				System.out.println("The trackRecommendationReceivedList from DB is null");
			}
			
			return trackRecommendationModelList;
	}


	@Override
	public List<AlbumRecommendationModel> getAlbumRecommendationsReceived(String currentUser) {
		
		if (currentUser == null) {
			return null;
		}
		
		User user = userRepository.getUserByName(currentUser);
		
		List<AlbumRecommendation> albumRecommendationReceivedList = musicRepository.getRecommendationForUser(user);
		
		List<String> trackIds = new ArrayList<String>();
		
		List<AlbumRecommendationModel> albumRecommendationModelList = new ArrayList<AlbumRecommendationModel>();
		
		if (albumRecommendationReceivedList != null && albumRecommendationReceivedList.size() > 0) {
			
			for (AlbumRecommendation al : albumRecommendationReceivedList) {
				if (al != null && al.getAlbumId() != null) {
					AlbumRecommendationModel albumRecModel = new AlbumRecommendationModel();
					AlbumSpotifyModel album = SpotifyUtil.getAlbumForAlbumId(al.getAlbumId());
					albumRecModel.setAlbum(album);
					albumRecModel.setRecommendedBy(al.getAlRecommender().getUsername());
					albumRecommendationModelList.add(albumRecModel);
				}
			}	
		} else {
			System.out.println("The albumRecommendationModelList from DB is null");
		}
		
		return albumRecommendationModelList;
	}


	@Override
	public List<UserModel> getUsersList(String currentUser) {
		
		if (currentUser == null) {
			return null;
		}
		
		User currUser = userRepository.getUserByName(currentUser);
		Set<UserModel> friends = findFriendsOfUserAsList(currentUser);
		
		List<Integer> userIdList = new ArrayList<Integer>();
		
		for (UserModel friend : friends) {
			if(friend != null) {
				userIdList.add(friend.getUserId()) ;
			}
		}
		
		List<User> users = userRepository.getAllUsers(currUser,userIdList);
		
		List<UserModel> models = new ArrayList<UserModel>();
		
		if (users == null) {
			System.out.println("Users is null when trying to fetch list of all users for friend request");
			return null;
		} else {
			for (User user : users) {
				System.out.println(user.getUsername());
				System.out.println(user.getUserId());
				System.out.println(user.getPassword());
				System.out.println(user.getEmail());
				System.out.println(user.isEnabled());
				UserModel model = new UserModel();
				model.setEmail(user.getEmail());
				model.setUsername(user.getUsername());
				model.setEnabled(user.isEnabled());
				model.setPassword(user.getPassword());
				model.setUserId(user.getUserId());
				models.add(model);
			}
		}
		return models;
	}


	@Override
	public Set<UserModel> findFriendsOfUserAsList(String currentUserName) {

		User user = userRepository.getUserByName(currentUserName);
		
		if (user == null) {
			System.out.println("Current User is null for findFriendsOfUser()");
			return null;
		}
		
		List<FriendMapper> mappers = userRepository.getFriendsOfUserAsList(user);
		
		Set<UserModel> userModels = new HashSet<UserModel>();
		if (mappers != null && mappers.size() > 0) {
			for (FriendMapper friend : mappers) {
				System.out.println("request::" + friend.getRequest().getUsername());
				System.out.println("response::" + friend.getRecepient().getUsername());
				UserModel userModel = new UserModel();
				if (friend.getRequest().getUsername().equalsIgnoreCase(currentUserName)) {
					userModel.setUsername(friend.getRecepient().getUsername());
					userModel.setUserId(friend.getRecepient().getUserId());
				} else if (friend.getRecepient().getUsername().equalsIgnoreCase(currentUserName)) {
					userModel.setUsername(friend.getRequest().getUsername());
					userModel.setUserId(friend.getRequest().getUserId());
				} else {
					continue;
				}
				
				userModels.add(userModel);
			}
		} else {
				System.out.println("mappers is null when trying to populate friends of users for recommendation in drop down");
		}
		
		return userModels;
	}


	@Override
	public boolean isUserExists(User user) {
		if(user == null) {
			return true;
		}
		
		User userFromDB = userRepository.getUserByName(user.getUsername());
		if(userFromDB != null) {
			return true;
		}
		
		return false;
	}

}
