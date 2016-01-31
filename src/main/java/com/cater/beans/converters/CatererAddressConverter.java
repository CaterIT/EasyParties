/**
 * 
 */
package com.cater.beans.converters;

import com.cater.tos.beans.CatererAddress;

/**
 * @author armaank
 *
 */
public class CatererAddressConverter {
	public CatererAddress convertFromDTO(com.cater.dto.beans.CatererAddress add){
		if(add==null){
			return null;
		}
		CatererAddress ca=new CatererAddress();
		ca.setLat(add.getLat());
		ca.setLng(add.getLng());
		ca.setId(add.getId());
		return ca;
	}
}
