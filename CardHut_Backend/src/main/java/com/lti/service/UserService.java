package com.lti.service;

import java.util.List;

import com.lti.dto.UpdateUserDto;
import com.lti.entity.User;

public interface UserService {
	String signUp(User user);
	
	UpdateUserDto updateUser(User user);
	
	User findUser(int userId);
	List<User> viewAllUsers();
	String userLogin(int userId,String password);
	
	String addJoiningFee(int userId,double joiningFee);

}
