package com.codecentric.cvgenerator.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.model.UserDao;



public interface UserService {
	
	 User save(User user);
	 int  update(User user,String update_value,String flag);
	 User userLoginCheck(String email);
	 User findUserByName(String name);
	 List<User> getList();

}
