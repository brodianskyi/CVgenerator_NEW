package com.codecentric.cvgenerator.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.exception.UserAlreadyExistsException;
import com.codecentric.cvgenerator.exception.UserNotCreateExceprion;
import com.codecentric.cvgenerator.model.UserDao;
import com.codecentric.cvgenerator.service.UserService;

import org.springframework.stereotype.Service;

@Service
@Validated
public class UserServiceImpl implements UserService{
	 
	 private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	 private final UserDao userRepository;
	
	 
	 @Inject
	 public UserServiceImpl(final UserDao userRepository) {
	        this.userRepository = userRepository;
	    }
	
	@Override
	@Transactional
	public User userLoginCheck(String email){
		
		User user = userRepository.findByEmail(email);
	
		
		
		if ( user == null) {
			logger.info("------------!!!!!!!!USER NULL");
			 throw new UserNotCreateExceprion(
	                    String.format("There not user with this data."));
		}
		logger.info("------------LoginCheck {} for" + user.getName());
		return user;
    }

	@Override
	@Transactional
	public User save(@NotNull @Valid final User user) {
		
		logger.info("Creating {}",user);
		User existing_vorname = userRepository.findByVorname(user.getVorname());
		User existing_name = userRepository.findByName(user.getName());
		User existing_email = userRepository.findByEmail(user.getEmail());
	//	userRepository.updateUserName(1L, "Pasha");
		
		if (existing_vorname != null || existing_name !=null || existing_email != null) {
			 throw new UserAlreadyExistsException(
	                    String.format("There already exists a user with id=%s", user.getName()));
			
	    }
		logger.info("-------------------",userRepository.findByVorname(user.getName()));
		return userRepository.save(user);
	}
	
	@Override
	@Transactional
	public int update(@NotNull @Valid final User user,String update_value,String flag){
		logger.info("Update {}",user);
		int result = 0;
		if (flag == "name"){
		   result = userRepository.updateUserName(user.getUser_id(), update_value);
		}else if (flag == "password"){
			result = userRepository.updateUserPassword(user.getUser_id(), update_value);
		}
		
	return result;
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getList() {
		logger.info("Retrieving the list of all users");
		return (List<User>) userRepository.findAll();
	}
	

	@Override
	@Transactional
	public User findUserByName(String name){
		return (User)userRepository.findByName(name);
	}
}
