package edu.neu.project.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import edu.neu.project.exception.*;
import edu.neu.project.exception.Error;
import edu.neu.project.model.*;
import edu.neu.project.service.util.*;
import edu.neu.project.service.impl.*;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	private HomeService homeService;
	private ProfileService profileService;
	
	 @Autowired
	    public HomeController(HomeService homeService, ProfileService profileService) {
	        this.homeService = homeService;
	        this.profileService = profileService;
	    }

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value="sample1", method = RequestMethod.GET)
	public String sample1(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "sample1";
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {
		// String greetings = "Greetings, Spring MVC!";
		Employee employee = null;		
		ObjectMapper mapper = new ObjectMapper();
		try {
			employee = mapper.readValue(new File("c://temp/employee.json"),
					Employee.class);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// System.out.println(employee);
		model.addAttribute("message", employee);

		return "test";
	}

	@RequestMapping("/view")
	public @ResponseBody Employee getPerson() {
		Employee person = new Employee();
		person.setId(1);
		person.setFirstName("Rafael");
		person.setLastName("Nadal");
		return person;
	}
	
	/*@RequestMapping("/example")
	public @ResponseBody Employee getEmployee() {
		
		return homeService.findEmployee();
	}
	
	@RequestMapping(value="/{emotion}", method = RequestMethod.GET)
	public @ResponseBody List<Book> getBooksForEmotion(@PathVariable String emotion) {
		
		List<Book> books = homeService.findBooksForEmotionService(emotion);
			
		return books;
	}*/
	
	@ExceptionHandler(EmotionNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody Error emotionNotFound(EmotionNotFoundException e) {
	String emotion = e.getEmotion();
	return new Error(4, "Response [" + emotion + "] not found");
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
        
	  System.out.println("email::" + user.getEmail());
	  System.out.println("Going to call create user service in controller");
	  	profileService.createUserService(user);
	  	profileService.createUserRoleService(user);
         
        return "redirect:/user/";
    }
}
