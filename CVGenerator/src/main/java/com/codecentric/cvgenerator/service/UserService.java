package com.codecentric.cvgenerator.service;

import java.util.List;

import com.codecentric.cvgenerator.api.entities.User;



public interface UserService {
	
	 User save(User user);

	 List<User> getList();

}
