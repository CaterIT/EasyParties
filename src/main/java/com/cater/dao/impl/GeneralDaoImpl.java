/**
 * 
 */
package com.cater.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.engine.spi.TypedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cater.dao.GeneralDao;
import com.cater.dto.beans.Caterer;
import com.cater.dto.beans.MasterCity;
import com.cater.dto.beans.MasterState;
import com.cater.dto.beans.User;

/**
 * @author armaank
 *
 */
@Repository
public class GeneralDaoImpl implements GeneralDao {
	@Autowired
	SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.cater.dao.GeneralDao#getAllCities()
	 */
	@Override
	public List<MasterCity> getAllCities() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<MasterCity> cities=(List<MasterCity>)session.createCriteria(MasterCity.class).list();
		session.close();
		return cities;
	}

	/* (non-Javadoc)
	 * @see com.cater.dao.GeneralDao#getCitiesByState(com.cater.dto.beans.MasterState)
	 */
	@Override
	public List<MasterCity> getCitiesByState(MasterState state) {
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Criteria criteria=session.createCriteria(MasterCity.class);
//		criteria.add(new Criterion)
		List<MasterCity> cities=(List<MasterCity>)criteria.list();
		session.close();
		return cities;
	}

	/* (non-Javadoc)
	 * @see com.cater.dao.GeneralDao#getAllStates()
	 */
	@Override
	public List<MasterState> getAllStates() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<MasterState> states=(List<MasterState>)session.createCriteria(MasterState.class).list();
		session.close();
		return states;
	}
	
	
}
