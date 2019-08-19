package com.fdmgroup.piggybank;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utilizes printf statements to output 
 * a human readable result for the conversion to the user
 * @see java.io.PrintStream#printf(Locale,String,Object...)
 * @author madhukar.mantravadi
 * @version 1.0.0, 06/05/2019
 */
public class View {
	
	
	UserInput userInput;
	/**
	 * This object parameter is generated in the {@link Client} 
	 * through a Scanner.
	 * @see java.util.Scanner
	 * @param userInput This object contains the currency type other than Euro, 
	 * the amount of money, and whether they are converting to or from Euros.
	 * @param convertedAmount This BigDecimal contains the amount in the currency being converted to.
	 */
	public static void printConversion(UserInput userInput, BigDecimal convertedAmount) {
		Logger logger = LogManager.getLogger("com.fdmgroup.piggybank");
		
		if (!userInput.getToOrFromEuro()) {
			logger.debug("Entered If (Euro To)");
			
			
			System.out.println(String.format("+%77s +"," ").replace(' ', '='));
			
			System.out.println(
					String.format("|%32S%3S %-42S%c","Euro to ",userInput.getCurrency(),"Conversion Results",'|'));
			
			System.out.println(String.format("|%77s |"," ").replace(' ', '='));
	
			System.out.printf("| %-39s| %-36s|%n","Amount of Euros to Convert","Converted Amount of "+userInput.getCurrency());
	
		    System.out.println(String.format("|%77s |"," ").replace(' ', '-'));
		    logger.trace("Printing out converted amount and input amount (Euro to Other)");
		    System.out.printf("| %-39.2f| %-36.2f|%n",userInput.getAmount().floatValue(), convertedAmount.floatValue());
	
		    System.out.println(String.format("'%77s '"," ").replace(' ', '='));
		    
		    

		} else if (userInput.getToOrFromEuro()) {
			logger.debug("Entered else if (Other Currency To)");

			
			System.out.println(String.format("+%77s +"," ").replace(' ', '='));
		
			System.out.println(
					String.format("|%27S %-50S%c",userInput.getCurrency(),"to Euro Conversion Results",'|'));
			
			System.out.println(String.format("|%77s |"," ").replace(' ', '='));
	
			System.out.printf("| %-10s%-3s%-26s| %-36s|%n","Amount of ",userInput.getCurrency()," to Convert","Converted Amount of Euro");
	
		    System.out.println(String.format("|%77s |"," ").replace(' ', '-'));
		    
		    logger.trace("Printing out converted amount and input amount (Other to Euro)");
		    System.out.printf("| %-39.2f| %-36.2f|%n",userInput.getAmount().floatValue(), convertedAmount.floatValue());
	
		    System.out.println(String.format("'%77s '"," ").replace(' ', '='));
		    
		    
		}
	}
}


	

