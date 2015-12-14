package com.cater.services;

import java.sql.SQLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author armaank
 *
 */
import org.springframework.stereotype.Service;

import com.cater.dao.UserDao;
import com.cater.tos.beans.Caterer;
import com.cater.tos.beans.User;
import com.cater.utils.rsToXML;

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
	public String getCaterer() throws ParserConfigurationException, SQLException, Exception {
		List<Caterer> l=userDao.getCaterers();
		return rsToXML.getXML(l);
		
	}
}
