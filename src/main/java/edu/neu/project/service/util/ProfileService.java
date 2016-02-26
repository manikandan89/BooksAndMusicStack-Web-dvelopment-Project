package edu.neu.project.service.util;

import java.util.List;
import java.util.Set;

import edu.neu.project.model.AlbumRecommendationModel;
import edu.neu.project.model.FriendMapper;
import edu.neu.project.model.FriendMapperModel;
import edu.neu.project.model.TrackRecommendationModel;
import edu.neu.project.model.User;
import edu.neu.project.model.UserModel;
import edu.neu.project.model.UserRoles;

public interface ProfileService {

	public User createUserService(User user);
	public void createUserRoleService(User user);
	public List<User> findUsers(String input, String currentUser);
	public void insertFriendRequest(String currentUserName, User recepientUser);
	public Set<FriendMapper> getRequestsGotByUser(String currentUser);
	public Set<FriendMapper> acceptFriendRequest(FriendMapperModel friendMapperModel, String currentUserName);
	public Set<UserModel> findFriendsOfUser(String input, String currentUserName);
	public List<TrackRecommendationModel> getRecommendationsReceived(String currentUser);
	public List<AlbumRecommendationModel> getAlbumRecommendationsReceived(String currentUser);
	public List<UserModel> getUsersList(String currentUser);
	public Set<UserModel> findFriendsOfUserAsList(String currentUserName);
	public boolean isUserExists(User user);
}
