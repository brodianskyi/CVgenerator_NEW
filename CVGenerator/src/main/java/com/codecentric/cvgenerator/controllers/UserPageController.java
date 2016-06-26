package com.codecentric.cvgenerator.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.forms.UserChangePasswordForm;
import com.codecentric.cvgenerator.forms.UserPageForm;
import com.codecentric.cvgenerator.service.UserService;
import com.codecentric.cvgenerator.validator.UserCreateFormPasswordValidator;
import com.codecentric.cvgenerator.validator.UserPageFormPasswordValidator;

import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class UserPageController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserService userService;
	private UserPageFormPasswordValidator passwordValidator;
	
	@Inject
	public UserPageController (UserService userService, UserPageFormPasswordValidator passwordValidator){
		this.userService = userService;
		this.passwordValidator = passwordValidator;
	}
	
	@InitBinder("password_form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(passwordValidator);
    }
	
	@RequestMapping(value = "/user_page", method = RequestMethod.GET)
	public ModelAndView  getUserPageFormView(Model model){
		
		
		ModelAndView modelAndView = new ModelAndView("user_page");
		modelAndView.addObject("user_page_form",new UserPageForm());
		modelAndView.addObject("password_form",new UserChangePasswordForm());
	return modelAndView;
		
	}
	@RequestMapping(value = "/user_page", method = RequestMethod.POST)
	public  ModelAndView userPageFormView(@ModelAttribute("user_page_form") @Valid UserPageForm form,BindingResult result,
			@ModelAttribute("password_form")  UserChangePasswordForm form1,
			HttpServletRequest request, HttpServletResponse response){
	
		 if (result.hasErrors()) {
			 
			 return new ModelAndView("user_page");
	      }
		
		 HttpSession userSession = request.getSession();
		 User user = ((User)userSession.getAttribute("user"));
		 String update_value = "";
		 String flag = "";
		 String message = form.getMessage();
		 update_value = form.getName();
		 logger.info("------------------------- form.getName()-------------" + update_value);
		 logger.info("------------------------- user.getName()-------------" + user.getName());
		 if (update_value != user.getName()){
			flag = "name"; 
			userService.update(user, update_value,flag);
		 }
		 user = userService.findUserByName(update_value);
		 
		 userSession.setAttribute("user", user);//
		 logger.info("------------------------- NEW NAME-------------"+user.getName());
		 ModelAndView model = new ModelAndView("user_page");
		 model.addObject("message",message);
		
     return model; 
		
	}
	
	@RequestMapping(value = "/change_password", method = RequestMethod.POST)
	public String changeUserPassword(@ModelAttribute("password_form") @Valid UserChangePasswordForm form,BindingResult result,
			@ModelAttribute("user_page_form") UserPageForm  form1,
			HttpServletRequest request, HttpServletResponse response){
		logger.info("----------- /change_password -------------");
		
			 if (result.hasErrors()) {
	           return "user_page";
	      }
/*		 HttpSession userSession = request.getSession();
		 User user = ((User)userSession.getAttribute("user"));
		 String update_value = "";
		 String flag = "";
		 update_value = form.getPassword_two(); 
		 if (update_value != user.getPassword()){
			 flag = "password"; 
		     userService.update(user, update_value,flag); 
		 }
		 */
		return "user_page";
	}
	
	
	
	

/*	@RequestMapping(value = "/user_page", method = RequestMethod.GET)
	public ModelAndView getserPasswordView(){
		logger.info("Received request for user_change_password_form");
		return new ModelAndView("user_page","user_change_password_form",new UserChangePasswordForm());
		
	}
*/	
	
	
	
	
	
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
