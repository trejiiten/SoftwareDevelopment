package com.fdmgroup.piggybank;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client {

	ConverterController converterController = new ConverterController();
	
	public static void main(String[] args) {
		UserInput ui = new UserInput();
		InputController ic = new InputController(ui);
		ConverterController cc = new ConverterController();

		while (ui.getToOrFromEuro() || !ui.getToOrFromEuro()) {
			ic.getUserPrompt();
			if (ic.getOption() == 1 || ic.getOption() == 2) {
				ic.getUserInputCurrency();
				if (ConversionRates.currencyMap.containsKey((ic.getCurrency().toUpperCase()))) {
					ic.getUserInputAmount();
					cc.setUserInput(ui);
					cc.convert();
//					break;
				}

			}

		}

	}

}
