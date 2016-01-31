/**
 * 
 */
package com.cater.dao;

import com.cater.dto.beans.Caterer;

/**
 * @author armaank
 *
 */
public interface CatererDao {

	public boolean saveCaterer(Caterer caterer);
	public Caterer getCatererByUserName(String caterer, String otp);
}
