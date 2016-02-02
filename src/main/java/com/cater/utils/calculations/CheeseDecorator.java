/**
 * 
 */
package com.cater.utils.calculations;

import java.math.BigDecimal;

/**
 * @author sgupt040
 *
 */
public class CheeseDecorator extends DishDecorator
{ 
	Dish currentDish; 
	public CheeseDecorator(Dish dish)
	{ 
		currentDish = dish; 
	}
	
	@Override 
	public String getDescription()
	{ 
		return currentDish.getDescription() + ", Cheese"; 
		} 
	@Override 
	public BigDecimal price() 
	{ 
		return currentDish.price().add(new BigDecimal("0.50")); 
		} 
	}

