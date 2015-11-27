package com.cater.services;

/**
 * @author armaank
 *
 */
import org.springframework.stereotype.Service;

import com.cater.tos.beans.User;

@Service
public class UserService {
	public User getUser() {
		User u = new User();
		u.setEmail("a@a.com");
		u.setUserName("Armaan");
		return u;
	}
}
