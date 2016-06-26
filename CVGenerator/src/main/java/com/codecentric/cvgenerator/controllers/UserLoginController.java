package com.codecentric.cvgenerator.controllers;

import javax.inject.Inject;
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

import com.codecentric.cvgenerator.forms.UserLoginForm;
import com.codecentric.cvgenerator.service.UserService;
import com.codecentric.cvgenerator.validator.UserCreateFormPasswordValidator;




@Controller
public class UserLoginController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/user_login", method = RequestMethod.GET)
	public ModelAndView getLoginUserView() {

		logger.info("------------User Login--------------------------");
	    return new ModelAndView("user_login", "user_login_form", new UserLoginForm());
	}
	
	@RequestMapping(value = "/user_login", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("user_login_form")@Valid UserLoginForm form, BindingResult result) {
		 if (result.hasErrors()) {
	          return "user_login";
	     }
		 
	
		return "redirect:/user_page";
	}
	

}
