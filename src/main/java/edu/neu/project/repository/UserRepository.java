package edu.neu.project.repository;

import java.util.List;

import edu.neu.project.model.FriendMapper;
import edu.neu.project.model.FriendMapperModel;
import edu.neu.project.model.User;
import edu.neu.project.model.UserRoles;

public interface UserRepository {

	public User createUser(User user);
	public void addRoleToUser(UserRoles role);
	public User getUserById(int userId);
	public void updateUser(User user);
	public User getUserByName(String username);
	public List<User> getUsersByStringSearch(String username, String currentUser, List<Integer> userIdList);
	public void persistFriendRequest(FriendMapper friend);
	public void updateStateToAcceptFriendRequest(FriendMapper friendMapper);
	public FriendMapper getMapperObjByMapId(FriendMapperModel friendMapperModel);
	public List<FriendMapper> getFriendsOfUser(String username, User user);
	public List<User> getAllUsers(User currentUser, List<Integer> userIdList);
	public List<FriendMapper> getFriendsOfUserAsList(User user);
	public List<FriendMapper> checkFriendStatus(int userId,int userId2);
}
