/**
 * 
 */
package com.cater.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cater.dao.CatererDao;
import com.cater.dto.beans.Caterer;

/**
 * @author armaank
 *
 */
@Repository
public class CatererDaoImpl implements CatererDao {

	@Autowired
	SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cater.dao.CatererDao#saveCaterer(com.cater.dto.beans.Caterer)
	 */
	@Override
	public boolean saveCaterer(Caterer caterer) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(caterer);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cater.dao.CatererDao#getCatererByEmail(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Caterer getCatererByUserName(String username,String otp) {
		Session session = sessionFactory.openSession();
		Criteria catererCriteria = session.createCriteria(Caterer.class);
		catererCriteria.add(Restrictions.eq("username", username));
		catererCriteria.add(Restrictions.eq("otp", username));
		List<Caterer> caterer = catererCriteria.list();
		if (caterer != null && !caterer.isEmpty()) {
			return caterer.get(0);
		}
		return null;
	}

}
