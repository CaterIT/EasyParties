/**
 * 
 */
package com.cater.dao.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cater.dao.CatererDao;
import com.cater.dto.beans.Caterer;

/**
 * @author armaank
 *
 */
@Repository
public class CatererDaoImpl implements CatererDao{

	@Autowired
	SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see com.cater.dao.CatererDao#saveCaterer(com.cater.dto.beans.Caterer)
	 */
	@Override
	public boolean saveCaterer(Caterer caterer) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		try{
		session.save(caterer);
		transaction.commit();
		}
		catch(Exception e){
			transaction.rollback();
			return false;
		}
		finally{
			session.close();
		}
		
		return true;
	}

}
