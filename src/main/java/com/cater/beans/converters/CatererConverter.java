/**
 * 
 */
package com.cater.beans.converters;

import com.cater.dto.beans.Caterer;

/**
 * @author armaank
 *
 */
public class CatererConverter {
	public Caterer convertToDto(com.cater.tos.beans.Caterer caterer) {
		Caterer converted = new Caterer();
		converted.setCatererId(caterer.getCatererId());
		converted.setDisplayName(caterer.getDisplayName());
		converted.setName(caterer.getName());
		converted.setOwnerName(caterer.getOwnerName());
		converted.setUsername(caterer.getUsername());
		converted.setPassword(caterer.getPassword());
		return converted;
	}

	public com.cater.tos.beans.Caterer convertFromDto(Caterer caterer) {
		com.cater.tos.beans.Caterer converted = new com.cater.tos.beans.Caterer();
		converted.setCatererId(caterer.getCatererId());
		converted.setDisplayName(caterer.getDisplayName());
		converted.setName(caterer.getName());
		converted.setOwnerName(caterer.getOwnerName());
		converted.setUsername(caterer.getUsername());
		converted.setPassword(caterer.getPassword());
		return converted;
	}
}
