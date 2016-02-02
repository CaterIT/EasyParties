/**
 * 
 */
package com.cater.utils.calculations;

import java.math.BigDecimal;

/**
 * @author sgupt040
 *
 */
public abstract class DishDecorator extends Dish 
{ 
	@Override 
	public abstract BigDecimal price(); 
}