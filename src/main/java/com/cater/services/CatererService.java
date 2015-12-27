/**
 * 
 */
package com.cater.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cater.beans.converters.CatererConverter;
import com.cater.dao.CatererDao;
import com.cater.tos.beans.Caterer;

/**
 * @author armaank
 *
 */
@Service
public class CatererService {

	@Autowired
	CatererDao catererDao;

	public boolean saveCaterer(Caterer caterer,String otp) {
		com.cater.dto.beans.Caterer catererDto = new CatererConverter().convertToDto(caterer);
		catererDto.setOtp(otp);
		return catererDao.saveCaterer(catererDto);
		
	}
}
