/**
 * 
 */
package com.cater.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cater.tos.beans.User;

/**
 * @author armaank
 *
 */
public interface UserDao {
	public void createUser(User user);
}