/**
 * 
 */
package com.cater.dao;

import java.util.List;

import com.cater.dto.beans.MasterCity;
import com.cater.dto.beans.MasterState;

/**
 * @author armaank
 *
 */
public interface GeneralDao {
	public List<MasterCity> getAllCities();
	public List<MasterCity> getCitiesByState(MasterState state);
	public List<MasterState> getAllStates();
}
