package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.lti.dao.UserDao;
import com.lti.dto.UpdateUserDto;
import com.lti.entity.User;
import com.lti.exception.UserIdMissingException;
import com.lti.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	

	public String signUp(User user) {
		// TODO Auto-generated method stub
		User persistedUser = userDao.addOrUpdateUser(user);
		if (persistedUser != null) {
			try {

				String subject = "Registration confirmation";
				String text = "Your user id is " + persistedUser.getUserId();
				String email = persistedUser.getEmail();
//				emailService.sendEmailForSignUp(email, text, subject);

				return "Sign up successful. User ID is " + persistedUser.getUserId();
			} catch (Exception e) {

				return "Unexpected error occured during email verification";
			}
		}
		else {
			return "Error occured during registration";
		}

	}
	

	

	public User findUser(int userId) {
		// TODO Auto-generated method stub4
		
		try {
			if(userId==0) {
				throw new UserIdMissingException("Enter correct userId");
			}
			else if(userDao.getUserById(userId)==null) {
				throw new UserNotFoundException("User does not exist");
			}
			else {
				return userDao.getUserById(userId);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	
	}

	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return userDao.viewAllUsers();
	}

	public String userLogin(int userId, String password) {
		// TODO Auto-generated method stub
		return userDao.login(userId, password) ? "Login Successful" : "Invalid credentials";
	}

	public String addJoiningFee(int userId, double joiningFee) {
		// TODO Auto-generated method stub
		return null;
	}

	public UpdateUserDto updateUser(User user) {
		UpdateUserDto updatedUser = new UpdateUserDto();

		try {
			if (user.getUserId() == 0) {
				throw new UserIdMissingException("Please mention user id.");
			} else if (userDao.getUserById(user.getUserId()) == null) {
				throw new UserNotFoundException("User not found.");
			} else {
				User user2 = userDao.addOrUpdateUser(user);
				updatedUser.setUser(user2);
				updatedUser.setMessage("User has been updated");
				return updatedUser;
			}
		} catch (Exception e) {
			updatedUser.setMessage(e.getMessage());
			return updatedUser;
		}
	}

}
