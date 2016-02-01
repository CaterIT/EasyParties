/**
 * 
 */
package com.cater.dao;

import java.util.List;

import com.cater.dto.beans.Caterer;

/**
 * @author armaank
 *
 */
public interface CatererDao {

	public boolean saveCaterer(Caterer caterer);
	public Caterer getCatererByUserName(String caterer, String otp);
	public List<Caterer> getCaters(String lat, String lng, String radius);
 	public String getCaterDescription(String id);
 	public Caterer getCaterInfo(String id);
}
