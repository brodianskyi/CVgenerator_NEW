package com.codecentric.cvgenerator.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codecentric.cvgenerator.api.entities.Helper;
import com.codecentric.cvgenerator.api.entities.User;

@Controller
public class UserCreateController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/user_create", method = RequestMethod.GET)
    public ModelAndView getCreateUserView() {
		logger.info("Received request for user create view");
        return new ModelAndView("user_create", "user", new User());
    }

    @RequestMapping(value = "/user_create", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
    	logger.info("----------- user_create.html -------------");
        if (result.hasErrors()) {
            return "user_create";
        }
       
        return "redirect:/test";
    }

}
