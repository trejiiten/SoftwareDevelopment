package com.fdmgroup.piggybank;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.logging.log4j.*;

/**
 * UserInput utilizing the Scanner Utility, InputStream IO, and BigDecimal Math
 * API. User inputs for "Currency" and "Amount" will then be set to their values
 * in the UserInput Object.
 * 
 * @author Todd.Rings
 * @version 1.0.0
 * 
 */
public class InputController {

	private UserInput userInput;
	private Scanner in;
	private static Logger logger;
	private int option;
	private String currency;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public InputController() {
		this.in = new Scanner(System.in);
	}

	public InputController(UserInput userInput) {
		this.userInput = userInput;
		this.in = new Scanner(System.in);
	}

	public InputController(UserInput userInput, InputStream in) {
		this.in = new Scanner(in);
		this.userInput = userInput;
	}

	/**
	 * 
	 * Give the user a prompt for type of conversion they wish to perform
	 * 
	 * @return UserInput (toOrFromEuro boolean) is returned 
	 */
	public UserInput getUserPrompt() throws NullPointerException {
		logger = LogManager.getRootLogger();
		try {
			System.out.println(ConversionRates.currencyMap.toString());
			System.out.println("Please choose your type of conversion:");
			System.out.println("1) Euro to Foreign Currency");
			System.out.println("2) Foreign Currency to Euro");
			option = Integer.parseInt(in.nextLine());
			if (option == 1) {
				userInput.setToOrFromEuro(false);
			} else if (option == 2) {
				userInput.setToOrFromEuro(true);
			} else {
				logger.error("Sorry, that option does not exist.");
			}
		} catch (NumberFormatException e) {
			logger.error("Please make a selection.");
		}
		return userInput;
	}

	/**
	 * 
	 * Takes in an input (Currency name) and stores to the UserInput currency
	 * variable. Check to make sure the inputed value is present in the
	 * CurrencyRates.currencyMap
	 * 
	 * @return UserInput (String currency) is returned
	 */

	public UserInput getUserInputCurrency() throws NullPointerException {
		logger = LogManager.getRootLogger();
		try {
			System.out.println("Please enter your 3-letter currency symbol: ");
			 currency = in.nextLine();
			if (ConversionRates.currencyMap.containsKey(currency.toUpperCase())) {
				userInput.setCurrency(currency.toUpperCase());
				return userInput;
			} else {
				logger.error("Your currency symbol does not exist.");
				return userInput;
			}
		} catch (NullPointerException e) {
			logger.error("Please include a currency symbol.");
		}
		return userInput;

	}

	/**
	 * 
	 * Takes in an input (amount) and stores to the UserInput amount variable.
	 * 
	 * @return UserInput (BigDecimal amount) is returned
	 */
	public UserInput getUserInputAmount() throws NumberFormatException, NoSuchElementException {
		logger = LogManager.getRootLogger();

		try {
			System.out.println("Please enter the amount you wish to convert: ");
			BigDecimal amount = new BigDecimal(in.nextLine());
			userInput.setAmount(amount);
		} catch (NumberFormatException e) {
			logger.error("Only money, please!");
		} catch (NoSuchElementException e) {
			logger.error("You forgot the monies");
		}
		return userInput;

	}

}
