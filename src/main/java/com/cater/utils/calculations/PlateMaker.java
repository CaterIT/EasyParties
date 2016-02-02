/**
 * 
 */
package com.cater.utils.calculations;

/**
 * @author sgupt040
 *
 */
public class PlateMaker {
	   
    public static void main(String args[]){
       
        Dish myDish = new Plate("Gazar ka halwa");
        System.out.printf("Price of %s is $%.2f %n", myDish.getDescription(), 
        		myDish.price());
       
        //adding extra cheese using Decorator Pattern
        myDish = new CheeseDecorator(myDish);
        System.out.printf("Price of %s is $%.2f %n", myDish.getDescription(), 
        		myDish.price());
    }
}