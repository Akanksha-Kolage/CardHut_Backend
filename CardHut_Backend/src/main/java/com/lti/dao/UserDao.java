package com.lti.dao;

import java.util.List;

import com.lti.entity.User;

public interface UserDao {
	
	User addOrUpdateUser(User user);
	User getUserById(int userId);
	List<User> viewAllUsers();
	boolean login(int userId,String password);
	
	boolean addJoiningFee(int userId,double joiningFee);
	
	


}
