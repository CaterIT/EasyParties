package com.cater.services;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author armaank
 *
 */
import org.springframework.stereotype.Service;

import com.cater.dao.UserDao;
import com.cater.tos.beans.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public User getUser() {
		User u = new User();
		u.setEmail("a@a.com");
		u.setUserName("Armaan");
		return u;
	}

	public User saveUser() {
		User u = new User();
		u.setEmail("a@a.com");
		u.setUserName("Armaan");
		userDao.createUser(u);
		return u;
	}
}
