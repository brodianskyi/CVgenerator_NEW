package com.codecentric.cvgenerator.service;

import java.util.List;

import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.model.UserDao;



public interface UserService {
	
	 User save(User user);
	 int update(User user,String update_value);

	 List<User> getList();

}
