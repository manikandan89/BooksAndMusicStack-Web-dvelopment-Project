package edu.neu.project.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wrapper.spotify.methods.AlbumRequest;
import com.wrapper.spotify.models.Album;
import com.wrapper.spotify.models.SimpleAlbum;

import edu.neu.project.model.AlbumRecommendationModel;
import edu.neu.project.model.Employee;
import edu.neu.project.model.FriendMapper;
import edu.neu.project.model.FriendMapperModel;
import edu.neu.project.model.FriendMapperModelSet;
import edu.neu.project.model.TrackRecommendation;
import edu.neu.project.model.TrackRecommendationModel;
import edu.neu.project.model.User;
import edu.neu.project.model.UserModel;
import edu.neu.project.repository.UserRepository;
import edu.neu.project.service.util.ProfileService;

@Controller
@Transactional
@RequestMapping("/user/profile/")
public class ProfileController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProfileController.class);
	
	private ProfileService profileService;
	
	 @Autowired
	    public ProfileController(ProfileService profileService) {
	        this.profileService = profileService;
	    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String profile(Locale locale, Model model) {
		logger.info("Profile Controller called", locale);

	

		return "profile";
	}
	
	@RequestMapping(value="register",method = RequestMethod.GET)
	public ModelAndView register(Locale locale, Model model) {
		logger.info("Registration called", locale);


		return new ModelAndView("register","user", new User());
	}
	
	  @RequestMapping(value="register", method = RequestMethod.POST)
	    public String processRegistration(@ModelAttribute("user") User user,
	    		BindingResult result, ModelMap model) {
	         
		  if (result.hasErrors()) {
	           System.out.println("Binding errors");
	        }
		  
		  boolean bRet = profileService.isUserExists(user);
		  
		  if (bRet) {
			  model.addAttribute("message", "User already exists");
			  return "redirect:/login/";
		  }
	        
		  System.out.println("Going to call create user service in controller");
		  	profileService.createUserService(user);
		  	profileService.createUserRoleService(user);
	         
	        return "redirect:/user/profile/";
	    }
	  
	  @RequestMapping(value="favourites/album",method = RequestMethod.GET)
		public String favourites(Locale locale, Model model) {
			logger.info("Favourites Album called", locale);


			return "favouritesAlbum";
		}
	  
	  @RequestMapping(value="favourites/track",method = RequestMethod.GET)
		public String favouritesTrack(Locale locale, Model model) {
			logger.info("Favourites Tracks called", locale);


			return "favouritesTrack";
		}
	  
	  @RequestMapping(value="people",method = RequestMethod.GET)
			public String findPeople(Locale locale, Model model) {
				logger.info("Find People called", locale);


				return "people";
	  }
	  
	  
	  @RequestMapping("people/users")
		public @ResponseBody List<UserModel> getUsers(@RequestParam String input, Principal principal) {
			logger.info("USER SEARCH NAME ::: " + input);
			
			 final String currentUser = principal.getName();
			 System.out.println("userrr::" + currentUser);
			
			List<User> users = profileService.findUsers(input, currentUser);
			List<UserModel> userModels = new ArrayList<UserModel>();
			
			if (users == null) {
				System.out.println("Users is null");
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
					userModels.add(model);
				}
			}
				
			return userModels;
		}
	  
	  @RequestMapping(value="people/list", method = RequestMethod.GET)
		public @ResponseBody List<UserModel> getUsersList(Principal principal) {
			 System.out.println("Inside getUsersList");
			
			 
			 final String currentUser = principal.getName();
			 System.out.println("userrr::" + currentUser);
				
			 List<UserModel> usersList = profileService.getUsersList(currentUser);
			 
			 return usersList;
		}
	  
	  
	  
	  @RequestMapping(value="people", method = RequestMethod.POST)
		public @ResponseBody User friendRequest(@RequestBody edu.neu.project.model.User recepientUser,Principal principal) {
		 	
		  	
		  	final String currentUserName = principal.getName();
			 System.out.println("userrr::" + currentUserName);
		  
		 	profileService.insertFriendRequest(currentUserName,recepientUser);  
		 	
		 	return recepientUser;
		 	
		}
	  
	 /* @RequestMapping(value="people", method = RequestMethod.POST)
		public ResponseEntity<?> friendRequest(@RequestBody edu.neu.project.model.User recepientUser,Principal principal) {
		 	
		  	//Hard coding a userId for NOW
		  	final String currentUserName = principal.getName();
			 System.out.println("userrr::" + currentUserName);
		  
		 	profileService.insertFriendRequest(currentUserName,recepientUser);
			 return new ResponseEntity<String>("Friend request sent", HttpStatus.OK);  
		 	
		}*/
	  
		 
			@RequestMapping(value="view", method = RequestMethod.GET)
			public @ResponseBody Set<Employee> getPerson() {
				
				Set<Employee> employees = new HashSet<Employee>();
				Employee person = new Employee();
				Employee another = new Employee();
				person.setId(1);
				person.setFirstName("Mani");
				person.setLastName("Nagarajan");
				
				person.setId(2);
				person.setFirstName("Another");
				person.setLastName("Employee");
				
				employees.add(person);
				employees.add(another);
				return employees;
			}
			
			@RequestMapping(value="people/requestsGot", method = RequestMethod.GET)
			public String requestsReceived(Model model) {
				
				 return "pendingRequests";
			}
			
			@RequestMapping(value="people/requestsGot/pending", method = RequestMethod.GET)
			public @ResponseBody Set<FriendMapperModel> requestsReceivedPending(Principal principal) {
				System.out.println("Inside requestsReceivedPending");
				
				 final String currentUser = principal.getName();
				 System.out.println("userrr::" + currentUser);
					
					Set<FriendMapper> users = profileService.getRequestsGotByUser(currentUser);
					System.out.println("Mapper test print inside controller");
					
					Set<FriendMapperModel> friendModels = new HashSet<FriendMapperModel>();
					
					if (users != null && users.size() > 0) {
						for (FriendMapper friend : users) {
								System.out.println("request::" + friend.getRequest().getUsername());
							System.out.println("response::" + friend.getRecepient().getUsername());
							
							if (friend.isState()) {
								continue;
							}
							
							FriendMapperModel friendModel = new FriendMapperModel();
							friendModel.setMapId(friend.getMapId());
							friendModel.setRecepientName(friend.getRecepient().getUsername());
							friendModel.setRequestName(friend.getRequest().getUsername());
							friendModel.setRecepientId(friend.getRecepient().getUserId());
							friendModel.setRequestId(friend.getRequest().getUserId());
							friendModel.setState(friend.isState());
							friendModels.add(friendModel);
						}
					} else {
							System.out.println("newCurrentUser.getRecepientList() is null");
					}
					
					return friendModels;
			}
			
	
			
			/*@RequestMapping(value="people/accept", method = RequestMethod.POST)
			public void friendRequestAcceptance(@RequestBody edu.neu.project.model.FriendMapperModel friendMapper,Principal principal) {
			 	
			  	final String currentUserName = principal.getName();
				 System.out.println("userrr::" + currentUserName);
				 
				 if (friendMapper.getRecepientName().equals(currentUserName)) {
					 profileService.acceptFriendRequest(friendMapper);
				 } else {
					 System.out.println("The friend mapper name from UI and the current user logged in via Principal Obj are not same");
				 }
			  
			 	  
			 	
			}*/
			
			/*@RequestMapping(value="people/accept", method = RequestMethod.POST)
			public Set<FriendMapperModel> friendRequestAcceptance(@RequestBody edu.neu.project.model.FriendMapperModel friendMapper,Principal principal) {
			 	
			  	final String currentUserName = principal.getName();
				 System.out.println("userrr::" + currentUserName);
				 
				 if (friendMapper.getRecepientName().equals(currentUserName)) {
					 Set<FriendMapper> users = profileService.acceptFriendRequest(friendMapper,currentUserName);
					 
					 Set<FriendMapperModel> friendModels = new HashSet<FriendMapperModel>();
						
						if (users != null && users.size() > 0) {
							for (FriendMapper friend : users) {
									System.out.println("request::" + friend.getRequest().getUsername());
								System.out.println("response::" + friend.getRecepient().getUsername());
								
								if (friend.isState()) {
									continue;
								}
								
								FriendMapperModel friendModel = new FriendMapperModel();
								friendModel.setMapId(friend.getMapId());
								friendModel.setRecepientName(friend.getRecepient().getUsername());
								friendModel.setRequestName(friend.getRequest().getUsername());
								friendModel.setRecepientId(friend.getRecepient().getUserId());
								friendModel.setRequestId(friend.getRequest().getUserId());
								friendModel.setState(friend.isState());
								friendModels.add(friendModel);
							}
						} else {
								System.out.println("newCurrentUser.getRecepientList() is null");
						}
						
						return friendModels;
				 } else {
					 System.out.println("The friend mapper name from UI and the current user logged in via Principal Obj are not same");
				 }
			  
			 	  
			 	return null;
			}
			*/
			
			@RequestMapping(value="people/accept/", method = RequestMethod.POST)
			public @ResponseBody Set<FriendMapperModel> friendRequestAcceptance(@RequestBody edu.neu.project.model.FriendMapperModel friendMapper,Principal principal) {
			 	
			  	final String currentUserName = principal.getName();
				 System.out.println("userrr::" + currentUserName);
				 
				 if (friendMapper.getRecepientName().equals(currentUserName)) {
					  profileService.acceptFriendRequest(friendMapper,currentUserName);
					 
					  Set<FriendMapper> users = profileService.getRequestsGotByUser(currentUserName);
						System.out.println("Mapper test print inside controller");
						
						Set<FriendMapperModel> friendModels = new HashSet<FriendMapperModel>();
						
						if (users != null && users.size() > 0) {
							for (FriendMapper friend : users) {
									System.out.println("request::" + friend.getRequest().getUsername());
								System.out.println("response::" + friend.getRecepient().getUsername());
								
								if (friend.isState()) {
									continue;
								}
								
								FriendMapperModel friendModel = new FriendMapperModel();
								friendModel.setMapId(friend.getMapId());
								friendModel.setRecepientName(friend.getRecepient().getUsername());
								friendModel.setRequestName(friend.getRequest().getUsername());
								friendModel.setRecepientId(friend.getRecepient().getUserId());
								friendModel.setRequestId(friend.getRequest().getUserId());
								friendModel.setState(friend.isState());
								friendModels.add(friendModel);
							}
						} else {
								System.out.println("newCurrentUser.getRecepientList() is null");
						}
						
						return friendModels;
				 } else {
					 System.out.println("The friend mapper name from UI and the current user logged in via Principal Obj are not same");
				 }
			  
			 	  
			 	return null;
			}
			
			
			@RequestMapping("people/friends")
			public @ResponseBody Set<UserModel> getFriends(@RequestParam String input, Principal principal) {
				logger.info("FRIEND SEARCH NAME ::: " + input);
				
				final String currentUserName = principal.getName();
				 System.out.println("userrr::" + currentUserName);
				
				Set<UserModel> userModels = profileService.findFriendsOfUser(input, currentUserName);
				
				return userModels;
			}
			
			@RequestMapping("people/friendslist")
			public @ResponseBody Set<UserModel> getFriendsList(Principal principal) {
				
				
				final String currentUserName = principal.getName();
				 System.out.println("userrr::" + currentUserName);
				
				Set<UserModel> userModels = profileService.findFriendsOfUserAsList(currentUserName);
				
				return userModels;
			}
			
			
		@RequestMapping(value="recommendation/track",method = RequestMethod.GET)
			public String getRecommendationPage(Locale locale, Model model) {
					logger.info("To generate Recommendation Page called", locale);


					return "recommendation";
		  }
		
		@RequestMapping(value="recommendation/track/received", method = RequestMethod.GET)
		public @ResponseBody List<TrackRecommendationModel> recommendationsReceived(Principal principal) {
			 System.out.println("Inside recommendationsReceived");
			
			 
			 final String currentUser = principal.getName();
			 System.out.println("userrr::" + currentUser);
				
			 List<TrackRecommendationModel> trackRecommendationModelList = profileService.getRecommendationsReceived(currentUser);
			 
			 return trackRecommendationModelList;
		}
		
		@RequestMapping(value="recommendation/album",method = RequestMethod.GET)
		public String getRecommendationPageForAlbum(Locale locale, Model model) {
				logger.info("To generate Recommendation Page For Album called", locale);


				return "recommendationAlbum";
	  }
		
		@RequestMapping(value="recommendation/album/received", method = RequestMethod.GET)
		public @ResponseBody List<AlbumRecommendationModel> albumRecommendationsReceived(Principal principal) {
			 System.out.println("Inside albumRecommendationsReceived");
			
			 
			 final String currentUser = principal.getName();
			 System.out.println("userrr::" + currentUser);
				
			 List<AlbumRecommendationModel> albumRecommendationModelList = profileService.getAlbumRecommendationsReceived(currentUser);
			 
			 return albumRecommendationModelList;
		}
		
		@RequestMapping(value="documentation", method = RequestMethod.GET)
		public String documentation(Locale locale, Model model) {
			logger.info("Profile Controller for documentation called", locale);

		

			return "documentation";
		}
		
		@RequestMapping(value="recommendMessage", method = RequestMethod.GET)
		public String message(Locale locale, Model model) {
			logger.info("Profile Controller for recommend message called", locale);

		

			return "recommendMessage";
		}
	  
}
