package com.codecentric.cvgenerator.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.exception.UserNotCreateExceprion;
import com.codecentric.cvgenerator.forms.UserLoginForm;
import com.codecentric.cvgenerator.service.UserService;
import com.codecentric.cvgenerator.validator.UserCreateFormPasswordValidator;




@Controller
public class UserLoginController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserService userService;
	
	@Inject
	public UserLoginController(UserService userService){
		this.userService = userService;
	}
	
	@RequestMapping(value = "/user_login", method = RequestMethod.GET)
	public ModelAndView getLoginUserView() {

		logger.info("------------User Login--------------------------");
	    return new ModelAndView("user_login", "user_login_form", new UserLoginForm());
	}
	
	@RequestMapping(value = "/user_login", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("user_login_form")@Valid UserLoginForm form, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {
		 if (result.hasErrors()) {
	          return "user_login";
	     }
		User user = null;
		logger.info("------------User Login--------------------------");
		try {
		  logger.info("-------form.getEmail()-------------------------------"+form.getEmail());
		  user = userService.userLoginCheck(form.getEmail());
		  HttpSession userSession = request.getSession();
		  
		  if (form.getPassword().equals(user.getPassword())){
			  
			  userSession.setAttribute("user", user); 
		  }else {
			  result.rejectValue("password","user.error.password.not_compatible_with_email" );
			//  result.reject("user.error.password.not_compatible_with_email");
			  return "user_login";
			  
			 
		  }
			 
		  
		}catch( UserNotCreateExceprion e){
			  result.rejectValue("email","user.error.not_create" );
			// result.reject("user.error.not_create");
			 return "user_login";
		}
		
		
	
		return "redirect:/user_page";
	}
	

}
