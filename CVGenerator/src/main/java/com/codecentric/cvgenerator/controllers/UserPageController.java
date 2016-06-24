package com.codecentric.cvgenerator.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.forms.UserPageForm;
import com.codecentric.cvgenerator.service.UserService;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class UserPageController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserService userService;
	
	@Inject
	public UserPageController (UserService userService){
		this.userService = userService;
	}
	
	
	
	
	
	@RequestMapping(value = "/user_page", method = RequestMethod.GET)
	public ModelAndView getUserPageFormView(){
		logger.info("Received request for user_page_form view");
		return new ModelAndView("user_page","user_page_form",new UserPageForm());
		
	}
	@RequestMapping(value = "/user_page", method = RequestMethod.POST)
	public String userPageFormView(@ModelAttribute("user_page_form") @Valid UserPageForm form,BindingResult result,
			HttpServletRequest request, HttpServletResponse response){
				return "user_page"; 
		
	}
	
	
/*	@RequestMapping(value = "/user_page_form", method = RequestMethod.POST)
	public String userPageFormView(@ModelAttribute("user_page_form") @Valid UserPageForm form,BindingResult result,
			HttpServletRequest request, HttpServletResponse response){
		logger.info("----------- userPageFormView -------------"+form.getName());
		 if (result.hasErrors()) {
	           return "user_page";
	      }
		 String update_value = "";
		
		HttpSession userSession = request.getSession();
		if (update_value == request.getAttribute("change_name")){
		userService.update((User)userSession.getAttribute("user"), update_value);
		}
		 
		
	}
	
	*/

}
