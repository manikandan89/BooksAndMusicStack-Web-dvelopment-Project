package edu.neu.project.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.neu.project.model.FriendMapper;
import edu.neu.project.model.FriendMapperModel;
import edu.neu.project.model.User;
import edu.neu.project.model.UserRoles;
import edu.neu.project.repository.UserRepository;

@SuppressWarnings("unchecked")
@Repository
public class JpaUserRepository implements UserRepository{
	
	@PersistenceContext
	 private EntityManager em;

	@Override
	public User createUser(User user) {
		
		System.out.println("Going to create user in repo");
		this.em.persist(user);
		return user;
	}

	@Override
	public void addRoleToUser(UserRoles role) {
		em.persist(role);
		
	}

	@Override
	public User getUserById(int userId) {
		
		User user = em.find(User.class, userId);
		return user;
	}

	@Override
	public void updateUser(User user) {
		
		
	}

	@Override
	public User getUserByName(String username) {
		System.out.println("username in repo::" + username);
		
		Query q = em.createNamedQuery("User.findUserByName");
		q.setParameter("username", username);
		List<User> users = q.getResultList();
		if (users == null || users.size() == 0) {
			System.out.println("Users is null from DB");
			return null;
		}
		System.out.println("Users is not null drom DB");
		return users.get(0);
	}

	@Override
	public List<User> getUsersByStringSearch(String username, String currentUser, List<Integer> userIdList) {
		
		System.out.println("The parameter to be serached is " + username);
		Query q = em.createNamedQuery("User.findUsersBySearch");
		q.setParameter("username", "%" + username + "%");
		q.setParameter("currentUser", currentUser);
		
		if (userIdList==null || userIdList.isEmpty()) {
			userIdList = new ArrayList<Integer>();
			userIdList.add(0);  // Just a way to handle null list.. userId cant be zero.. so it has no effect on the resultset
			
		}
		    
		q.setParameter("friendList", userIdList);
		
		List<User> users = q.getResultList();
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
	public void persistFriendRequest(FriendMapper friend) {
		
		em.persist(friend);
	}

	@Override
	public void updateStateToAcceptFriendRequest(FriendMapper friendMapper) {
		System.out.println("Inside updateStateToAcceptFriendRequest()");
		friendMapper.setState(true);
		em.merge(friendMapper);
	}

	@Override
	public FriendMapper getMapperObjByMapId(FriendMapperModel friendMapperModel) {
		
		System.out.println("Entering getMapperObjByMapId");
		
		Query q = em.createNamedQuery("FriendMapper.findMapperByMapId");
		q.setParameter("mapId", friendMapperModel.getMapId());
		List<FriendMapper> mappers = q.getResultList();
		if (mappers == null || mappers.size() == 0) {
			System.out.println("Mappers is null from DB in getMapperObjByMapId()");
			return null;
		}
		System.out.println("Mappers is not null drom DB");
		return mappers.get(0);
	}

	@Override
	public List<FriendMapper> getFriendsOfUser(String username, User user) {
		
		System.out.println("The parameter to be serached is " + username);
		System.out.println("The current userId whose friends are to retrieved::" + user.getUserId());
		Query q = em.createNamedQuery("FriendMapper.getFriendsById");

		q.setParameter("recepientUserId", user.getUserId());
		q.setParameter("requestUserId", user.getUserId());
		q.setParameter("requestUserName", "%" + username + "%");
		q.setParameter("recepientUserName", "%" + username + "%");
		List<FriendMapper> mappers = q.getResultList();
		if (mappers != null && mappers.size() > 0) {
			
			for (FriendMapper mapper : mappers) {
				System.out.println(mapper.getMapId());
				System.out.println(mapper.isState());
				System.out.println(mapper.getRequest());
				System.out.println(mapper.getRecepient());
			}
		} else {
			System.out.println("mappers is null");
		}
	
		
		return mappers;
	}

	@Override
	public List<User> getAllUsers(User currentUser, List<Integer> userIdList) {
		
		if (currentUser == null) {
			return null;
		}
		
		
		
		Query q = em.createNamedQuery("User.getAllUsers");
		
		q.setParameter("userId", currentUser.getUserId());
		
		if (userIdList==null || userIdList.isEmpty()) {
			userIdList = new ArrayList<Integer>();
			userIdList.add(0);  // Just a way to handle null list.. userId cant be zero.. so it has no effect on the resultset
			
		}
		    
		q.setParameter("friendList", userIdList);
		  
		List<User> users = q.getResultList();
		return users;
	}

	@Override
	public List<FriendMapper> getFriendsOfUserAsList(User user) {
		
		
		System.out.println("The current userId whose friends are to retrieved::" + user.getUserId());
		Query q = em.createNamedQuery("FriendMapper.getFriendsListById");

		q.setParameter("recepientUserId", user.getUserId());
		q.setParameter("requestUserId", user.getUserId());
		
		List<FriendMapper> mappers = q.getResultList();
		if (mappers != null && mappers.size() > 0) {
			
			for (FriendMapper mapper : mappers) {
				System.out.println(mapper.getMapId());
				System.out.println(mapper.isState());
				System.out.println(mapper.getRequest());
				System.out.println(mapper.getRecepient());
			}
		} else {
			System.out.println("mappers is null");
		}
	
		
		return mappers;
	}

	@Override
	public List<FriendMapper> checkFriendStatus(int requestId, int recepientId) {
		
		Query q = em.createNamedQuery("FriendMapper.isFriend");
		
		q.setParameter("requestUserId", recepientId);
		q.setParameter("recepientUserId", requestId);  // Reversing to check if a row already exists
		
		List<FriendMapper> mappers = q.getResultList();
		
		return mappers;
	}
	
	

}
