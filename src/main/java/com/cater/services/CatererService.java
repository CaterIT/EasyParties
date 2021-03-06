/**
 * 
 */
package com.cater.services;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cater.beans.converters.AddressConverter;
import com.cater.beans.converters.CatererConverter;
import com.cater.dao.CatererDao;
import com.cater.dto.beans.CatererAddress;
import com.cater.tos.beans.AddressDetails;
import com.cater.tos.beans.Caterer;
import com.cater.utils.rsToXML;

/**
 * @author armaank
 *
 */
@Service
public class CatererService {

	@Autowired
	private HttpSession httpSession;

	@Autowired
	CatererDao catererDao;

	public boolean saveCaterer(Caterer caterer) {
		com.cater.dto.beans.Caterer catererDto = new CatererConverter().convertToDto(caterer);
		return catererDao.saveCaterer(catererDto);
	}
	public boolean saveCaterer(Caterer caterer,String otp) {
		com.cater.dto.beans.Caterer catererDto = new CatererConverter().convertToDto(caterer);
		catererDto.setOtp(otp);
		return catererDao.saveCaterer(catererDto);
	}
	
	public String getCaters(String lat, String lng, String radius) throws ParserConfigurationException, SQLException, Exception {
		List<com.cater.dto.beans.Caterer> l=catererDao.getCaters(lat, lng, radius);
		return rsToXML.getXML(l);
	}

	/**
	 * @param id
	 * @return
	 */
	public String getCaterDescription(String id) {
		return catererDao.getCaterDescription(id);
	}

	/**
	 * @param id
	 * @return
	 */
	public com.cater.dto.beans.Caterer getCaterObject(String id) {
//		CatererConverter converter = new CatererConverter();
		return catererDao.getCaterInfo(id);
	}

	public Caterer getCatererByUsernameAndOTP(String username,String otp) {
		CatererConverter converter = new CatererConverter();
		Caterer catererTos=null;
		com.cater.dto.beans.Caterer caterer= catererDao.getCatererByUserNameAndOTP(username, otp);
		if(caterer!=null){
			catererTos=converter.convertFromDto(caterer);
		}
		return catererTos;
	}
	public Caterer getCatererByUsernameAndPassword(Caterer caterer){
		CatererConverter converter = new CatererConverter();
		caterer=converter.convertFromDto(catererDao.getCatererByUsernamePassword(converter.convertToDto(caterer)));
		return caterer;
	}
	public boolean addCatererAddress(com.cater.tos.beans.CatererAddress catererAddressTos){
		CatererConverter converter = new CatererConverter();
		AddressConverter addressConverter=new AddressConverter();
		CatererAddress address=new CatererAddress();
		address.setAddressDetails(addressConverter.convertToDTO(catererAddressTos.getAddressDetails()));
		address.setCaterer(converter.convertToDto(catererAddressTos.getCaterer()));
		address.setLat(catererAddressTos.getLat());
		address.setLng(catererAddressTos.getLng());
		return catererDao.saveAddress(address);
	}
}
