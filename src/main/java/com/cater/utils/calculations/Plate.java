/**
 * 
 */
package com.cater.utils.calculations;

import java.math.BigDecimal;

/**
 * @author sgupt040
 *
 */
public class Plate extends Dish{
	
	public Plate(String desc) {
		this.description = desc;
	}

	@Override
	public BigDecimal price() {
		// TODO Auto-generated method stub
		return new BigDecimal(430);
	}
}
