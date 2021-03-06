/**
 * 
 */
package com.cater.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cater.dao.UserDao;
import com.cater.dto.beans.User;

/**
 * @author armaank
 *
 */
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public void createUser(User user){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
}
