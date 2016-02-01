/**
 * 
 */
package com.cater.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

	public List<Caterer> getCaters(String lat, String lng, String radius){

		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Caterer> result =(List<Caterer>)session.createSQLQuery("SELECT distinct name, caterer.caterer_id, ( 6371 * "
				+ "acos( cos( radians("+ lat + ") ) * cos( radians( lat ) ) *"
				+ " cos( radians( lng ) - radians("+ lng + ") ) + sin( radians("+ lat +") ) * "
				+ "sin( radians( lat ) ) ) ) AS distance, address_id, lat, lng, address_details.line1 FROM caterer INNER JOIN caterer_address on caterer.caterer_id=caterer_address.id "
				+ "INNER JOIN address_details on caterer_address.address_id=address_details.id HAVING distance "
				+ "< " + radius +" ORDER BY distance LIMIT 0 , 5000;").list();
//		List<Caterer> result =(List<Caterer>)session.createSQLQuery("SELECT distinct name, id, ( 6371 * "
//				+ "acos( cos( radians("+ lat + ") ) * cos( radians( lat ) ) *"
//				+ " cos( radians( lng ) - radians("+ lng + ") ) + sin( radians("+ lat +") ) * "
//				+ "sin( radians( lat ) ) ) ) AS distance, address_id, lat, lng FROM caterer INNER JOIN caterer_address on caterer.caterer_id=caterer_address.id HAVING distance "
//				+ "< " + radius +" ORDER BY distance LIMIT 0 , 5000;")
		return result;
	}

	@Override
	public Caterer getCaterInfo(String id) {
		Caterer result = new Caterer();
//		Session session=sessionFactory.openSession();
//		@SuppressWarnings("unchecked")
////		List<Caterer> a= (List<Caterer>) session.createSQLQuery("select * from cater_db where name='"+id+"'").addEntity(Caterer.class).list();
//		Caterer a= (Caterer) session.createSQLQuery("select * from caterer where name='"+id+"'").addEntity(Caterer.class).list().get(0);
//		return a;
		Session session=sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Caterer.class);
		criteria.add(Restrictions.eq("name", id));
		List<Caterer> caterList =  (List<Caterer>)criteria.list();
		if(!caterList.isEmpty())
		{
			result = caterList.get(0);
		}
		
		return result;
	}
	/* (non-Javadoc)
	 * @see com.cater.dao.UserDao#getCaterDescription(java.lang.String)
	 */
	@Override
	public String getCaterDescription(String id) {
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Caterer result= (Caterer) session.createCriteria(Caterer.class);
		return result.getDisplayName();
}
}
