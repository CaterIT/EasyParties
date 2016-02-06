/**
 * 
 */
package com.cater.beans.converters;

import java.util.HashSet;
import java.util.Set;

import com.cater.dto.beans.AddressDetails;
import com.cater.dto.beans.Caterer;
import com.cater.dto.beans.CatererAddress;
import com.cater.dto.beans.MasterCity;
import com.cater.dto.beans.MasterCountry;
import com.cater.dto.beans.MasterState;

/**
 * @author armaank
 *
 */
public class CatererConverter {
	public Caterer convertToDto(com.cater.tos.beans.Caterer caterer) {
		if(caterer==null){
			return null;
		}
		Caterer converted = new Caterer();
		converted.setCatererId(caterer.getCatererId());
		converted.setDisplayName(caterer.getDisplayName());
		converted.setName(caterer.getName());
		converted.setOwnerName(caterer.getOwnerName());
		converted.setUsername(caterer.getUsername());
		converted.setPassword(caterer.getPassword());
		converted.setIsDeleted(caterer.isIsDeleted());
		Set<com.cater.tos.beans.CatererAddress> tempCatererAddressSet = new HashSet<com.cater.tos.beans.CatererAddress>();
		caterer.getCatererAddresses().addAll(tempCatererAddressSet);
//		tempCatererAddressSet.addAll(caterer.getCatererAddresses());
		converted.setCatererAddresses(convertToDto(tempCatererAddressSet));
		return converted;
	}

	public com.cater.tos.beans.Caterer convertFromDto(Caterer caterer) {
		if(caterer==null){
			return null;
		}
		com.cater.tos.beans.Caterer converted = new com.cater.tos.beans.Caterer();
		converted.setCatererId(caterer.getCatererId());
		converted.setDisplayName(caterer.getDisplayName());
		converted.setName(caterer.getName());
		converted.setOwnerName(caterer.getOwnerName());
		converted.setUsername(caterer.getUsername());
		converted.setPassword(caterer.getPassword());
		return converted;
	}
	
	public Set<CatererAddress> convertToDto(Set<com.cater.tos.beans.CatererAddress> caterAddress)
	{
		Set<CatererAddress> convertedCatererAddressSet = new HashSet<CatererAddress>();
		for(com.cater.tos.beans.CatererAddress caterAdd :  caterAddress)
		{
			CatererAddress convertedCatererAddress = new CatererAddress();
		convertedCatererAddress.setId(caterAdd.getId());
		convertedCatererAddress.setIsDeleted(caterAdd.isIsDeleted());
		convertedCatererAddress.setLat(caterAdd.getLat());
		convertedCatererAddress.setLng(caterAdd.getLng());
		convertedCatererAddress.setAddressDetails(convertToDto(caterAdd.getAddressDetails()));
		}
		return convertedCatererAddressSet;
	}
	
	public AddressDetails convertToDto(com.cater.tos.beans.AddressDetails caterAddressDetails)
	{
		AddressDetails addressDetails = new AddressDetails();
		addressDetails.setCatererAddresses(caterAddressDetails.getCatererAddresses());
		addressDetails.setId(caterAddressDetails.getId());
		addressDetails.setIsDeleted(caterAddressDetails.isIsDeleted());
		addressDetails.setLine1(caterAddressDetails.getLine1());
		addressDetails.setLine2(caterAddressDetails.getLine2());
		addressDetails.setLine3(caterAddressDetails.getLine3());
		addressDetails.setMasterCity(convertToDto(caterAddressDetails.getMasterCity()));
		addressDetails.setPincode(caterAddressDetails.getPincode());
		return addressDetails;
	}
	
	public MasterCity convertToDto(com.cater.tos.beans.MasterCity masterCity)
	{
		MasterCity convertedmasterCity = new MasterCity();
		convertedmasterCity.setCityId(masterCity.getCityId());
		convertedmasterCity.setCityName(masterCity.getCityName());
		convertedmasterCity.setMasterState(convertToDto(masterCity.getMasterState()));
		convertedmasterCity.setVisible(masterCity.isVisible());
		return convertedmasterCity;
	}
	
	public MasterState convertToDto(com.cater.tos.beans.MasterState masterState)
	{
		MasterState convertedMasterState = new MasterState();
		convertedMasterState.setStateId(masterState.getStateId());
		convertedMasterState.setStateName(masterState.getStateName());
		convertedMasterState.setMasterCountry(convertToDto(masterState.getMasterCountry()));
		convertedMasterState.setVisible(masterState.isVisible());
		convertedMasterState.setMasterCities(masterState.getMasterCities());
		return convertedMasterState;
	}
	
	public MasterCountry convertToDto(com.cater.tos.beans.MasterCountry masterCountry)
	{
		MasterCountry convertedMasterCountry = new MasterCountry();
		convertedMasterCountry.setCountryId(masterCountry.getCountryId());
		convertedMasterCountry.setCountryName(masterCountry.getCountryName());
		convertedMasterCountry.setVisible(masterCountry.isVisible());
		convertedMasterCountry.setMasterStates(masterCountry.getMasterStates());
		return convertedMasterCountry;
	}
}
