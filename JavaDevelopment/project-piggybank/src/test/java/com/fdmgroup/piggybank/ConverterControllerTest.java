package com.fdmgroup.piggybank;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class ConverterControllerTest {
	
	ConverterController converterController;
	BigDecimal result;
	BigDecimal expected;
	//boolean toOrFrom; 
	
	
	@Before
	public void setUp() throws Exception {
		converterController = new ConverterController(); 
	}

	@Test
	public void test_ConvertUSDtoEuro() { //1euro = 1.1257 USD
		//arrange
		UserInput user1 = new UserInput("USD", new BigDecimal("100"), true);
		expected = new BigDecimal("88.83");
		//act
		converterController.setUserInput(user1);
		result = converterController.convert();
		//assert
		assertEquals(expected.doubleValue(), result.doubleValue(), 0.01);
	}
	
	@Test
	public void test_ConvertEuroToUSD() { //1euro = 1.1257 USD
		//arrange
		UserInput user1 = new UserInput("USD", new BigDecimal("88.83"), false);
		expected = new BigDecimal("100");
		//act
		converterController.setUserInput(user1);
		result = converterController.convert();
		//assert
		assertEquals(expected.doubleValue(), result.doubleValue(), 0.01);
	}
	
	@Test
	public void test_ConvertJPYtoEuro() { //1euro is 121.96 JPY
		//arrange
		UserInput user1 = new UserInput("JPY", new BigDecimal("12196"), true);
		expected = new BigDecimal("100");
		//act
		converterController.setUserInput(user1);
		result = converterController.convert();
		//assert
		assertEquals(expected.doubleValue(), result.doubleValue(), 0.01);
	}
	
	@Test
	public void test_ConvertEuroToJPY() { //1euro is 121.96 JPY
		//arrange
		UserInput user1 = new UserInput("JPY", new BigDecimal("100"), false);
		expected = new BigDecimal("12196");
		//act
		converterController.setUserInput(user1);
		result = converterController.convert();
		//assert
		assertEquals(expected.doubleValue(), result.doubleValue(), 0.01);
	}
	
	@Test
	public void test_ConvertHKDtoEuro() { //1Euro = 8.8257HKD
		//arrange
		UserInput user1 = new UserInput("HKD", new BigDecimal("882.57"), true);
		expected = new BigDecimal("100");
		//act
		converterController.setUserInput(user1);
		result = converterController.convert();
		//assert
		assertEquals(expected.doubleValue(), result.doubleValue(), 0.01);
	}
	
	@Test
	public void test_ConvertEuroToHKD() { //1Euro = 8.8257HKD
		//arrange
		UserInput user1 = new UserInput("HKD", new BigDecimal("100"), false);
		expected = new BigDecimal("882.57");
		//act
		converterController.setUserInput(user1);
		result = converterController.convert();
		//assert
		assertEquals(expected.doubleValue(), result.doubleValue(), 0.01);
	}
	
	
	
}

