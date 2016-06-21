package com.codecentric.cvgenerator.controllers;

import javax.inject.Inject;
import javax.persistence.NonUniqueResultException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codecentric.cvgenerator.api.entities.MainEntity;
import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.exception.UserAlreadyExistsException;
import com.codecentric.cvgenerator.forms.UserCreateForm;
import com.codecentric.cvgenerator.model.UserDao;
import com.codecentric.cvgenerator.service.UserService;
import com.codecentric.cvgenerator.validator.UserCreatePasswordValidator;





@Controller
public class UserCreateController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserService userService;
	private UserCreatePasswordValidator passwordValidator;

	
	@Inject
    public UserCreateController(UserService userService, UserCreatePasswordValidator passwordValidator) {
        this.userService = userService;
        this.passwordValidator = passwordValidator;
        
    }
	
	@InitBinder("user_create_form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(passwordValidator);
    }
	
	@RequestMapping(value = "/user_create", method = RequestMethod.GET)
    public ModelAndView getCreateUserView() {
		logger.info("Received request for user create view");
        return new ModelAndView("user_create", "user_created_form", new UserCreateForm());
    }

	

    @RequestMapping(value = "/user_create", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user_created_form") @Valid UserCreateForm form, BindingResult result) {
    	logger.info("----------- user_create.html -------------"+form.getName());
        if (result.hasErrors()) {
            return "user_create";
        }
        try {
        	
        	userService.save(new User(form.getName(),
        			form.getVorname(),form.getPassword_one(),
        			form.getPassword_two(),form.getGeburtsdatum(),
        			form.getWohnort(),form.getNationalitaet(),
        			form.getSprachen(),form.getTelefon(),form.getEmail()));
        }catch (UserAlreadyExistsException e) {
        	logger.info ("Tried to create user with existing name", e);
        
        	 result.reject("user.error.exists");
        	
         return "user_create";
        }catch (NonUniqueResultException e){
        	result.reject("user.error.exists");	
         return "user_create";	
        }catch ( IncorrectResultSizeDataAccessException e){
        	result.reject("user.error.exists");	
            return "user_create";	
        }
       
        return "redirect:/test";
    }
   


}
