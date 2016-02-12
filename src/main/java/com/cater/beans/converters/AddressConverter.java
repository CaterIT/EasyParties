/**
 * 
 */
package com.cater.beans.converters;

import com.cater.tos.beans.AddressDetails;

/**
 * @author armaank
 *
 */
public class AddressConverter {
	public AddressDetails convertFromDTO(com.cater.dto.beans.AddressDetails add){
		if(add==null){
			return null;
		}
		AddressDetails addressDetails=new AddressDetails();
		addressDetails.setId(add.getId());
		addressDetails.setLine1(add.getLine1());
		addressDetails.setLine2(add.getLine1());
		addressDetails.setLine3(add.getLine1());
		return addressDetails;
		
	}
	
	public com.cater.dto.beans.AddressDetails convertToDTO(AddressDetails add){
		if(add==null){
			return null;
		}
		com.cater.dto.beans.AddressDetails addressDetails=new com.cater.dto.beans.AddressDetails();
		addressDetails.setId(add.getId());
		addressDetails.setLine1(add.getLine1());
		addressDetails.setLine2(add.getLine1());
		addressDetails.setLine3(add.getLine1());
		return addressDetails;
		
	}
}
