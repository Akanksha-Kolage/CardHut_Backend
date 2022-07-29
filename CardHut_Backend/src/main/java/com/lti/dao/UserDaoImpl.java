package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.User;


@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	EntityManager em;

	
	@Transactional
	public User addOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		User persistedUser=null;
		
		try {
			persistedUser=em.merge(user);
			return persistedUser;
			
		} catch (Exception e) {
			// TODO: handle exception
			return persistedUser;
		}
		
		
	}

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		User user=null;
		try {
			user=em.find(User.class, userId);
			return user;
			
		} catch (Exception e) {
			// TODO: handle exception
			return user;
		}
		
	
	}

	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		String jpql="select u from User u";
		TypedQuery<User> query=em.createQuery(jpql, User.class);
		return query.getResultList();
	}

	public boolean login(int userId, String password) {
		// TODO Auto-generated method stub
		String jpql="select u from User u where u.userId=:uid and u.userPassword=:pwd";
		
		TypedQuery<User> query=em.createQuery(jpql, User.class);
		query.setParameter("uid", userId);
		query.setParameter("pwd", password);
		
		User user=null;
		try {
			user=query.getSingleResult();
		}
		catch(Exception e){
			
			return false;
			
		}
		
		return user!=null?true:false;
	}

	public boolean addJoiningFee(int userId,double joiningFee) {
		// TODO Auto-generated method stub
		
		return false;
	}



}
