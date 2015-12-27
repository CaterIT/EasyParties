/**
 * 
 */
package com.cater.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cater.dto.beans.Caterer;
import com.cater.dto.beans.User;

/**
 * @author armaank
 *
 */
public interface UserDao {
	public void createUser(User user);
	public List<Caterer> getCaterers();
}
