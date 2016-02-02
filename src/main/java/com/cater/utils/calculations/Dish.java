/**
 * 
 */
package com.cater.utils.calculations;

import java.math.BigDecimal;

/**
 * @author sgupt040
 *
 */
public abstract class Dish 
{
	String description = "Dish";
	public String getDescription()
	{ 
		return description; 
	}
	public abstract BigDecimal price(); 
}
