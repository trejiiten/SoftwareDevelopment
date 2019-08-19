package com.fdmgroup.piggybank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class handles the conversion logic for
 * a currency to Euro, or from Euro to a currency.
 * @author Khoi Phan
 * @version 1.0.0
 */
public class ConverterController {
	private UserInput userInput;
	private BigDecimal convertedCurrencyAmount;	
	Logger logger = LogManager.getLogger("com.fdmgroup.piggybank.ConverterController");  
	
	public BigDecimal getConvertedCurrencyAmount() {
		return convertedCurrencyAmount;
	}
	public void setConvertedCurrencyAmount(BigDecimal convertedCurrencyAmount) {
		this.convertedCurrencyAmount = convertedCurrencyAmount;
	}
	public void setUserInput(UserInput userInput) {
		this.userInput = userInput;
	}
	public UserInput getUserInput() {
		return userInput; 
	}
	
	  /**
	   * This method takes the currency and amount, that the user
	   * is comparing to Euros, and converts it to Euros, or from Euros
	   * to the user selected currency and amount.
	   * @see java.math.BigDecimal#multiply(BigDecimal)
	   * @return BigDecimal This returns the converted currency amount.
	   */
	public BigDecimal convert() {
		BigDecimal result, convRate;
		UserInput userInput;
		userInput = getUserInput();//getter
		convRate = getConversionRate();
	
		try {   
	        logger.debug("UserInput object: "+userInput);  
	        logger.debug("ConversionRate: "+convRate); 
	    } catch (SecurityException e) { e.printStackTrace();}  

	    
		result = userInput.getAmount().multiply(convRate);
		setConvertedCurrencyAmount(result);
		View.printConversion(getUserInput(), result);
		return result; 
	}
	
	
	  /**
	   * This method gets the conversion rate, 
	   * for the current Currency the user is comparing to Euros.
	   * {@link java.util.HashMap#get(Object)}, java.math.BigDecimal#divide(BigDecimal, int, RoundingMode)
	   * @return BigDecimal This returns the conversion rate for Euro 
	   * 			to a Currency, or the Currency to Euro conversion rate.
	   */
	public BigDecimal getConversionRate() {
		BigDecimal rate = null;
		try {   
	        logger.debug("ConversionRates HashMap of currencyXML: "+ConversionRates.currencyMap);  
	    } catch (SecurityException e) { e.printStackTrace();} 
		rate = ConversionRates.currencyMap.get(getUserInput().getCurrency());//gets BigDecimal from a HashMap<String, BigDecimal>
		 		
		if(userInput.getToOrFromEuro()) { 
			rate = new BigDecimal("1").divide(rate, 100, RoundingMode.HALF_UP);
		}
		return rate; 
	}
}
