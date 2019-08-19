package com.fdmgroup.piggybank;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class InputControllerTest {
	
	InputController inputController;
	UserInput mockUserInput;
	
	
	@Before
	public void setUp() throws Exception {	
		mockUserInput = mock(UserInput.class);
		inputController = new InputController(mockUserInput);
	}

	@Test
	public void test_ControllerInteractsWithGetUserInputCurrency() {
		InputStream in = new ByteArrayInputStream("USD".getBytes());
		inputController = new InputController(mockUserInput, in);
		String currency = "USD";
		when(mockUserInput.getCurrency()).thenReturn(currency);
		inputController.getUserInputCurrency();
		verify(mockUserInput).setCurrency(currency);
	}
	
//	@Test
//	public void test_ControllerInteractsWithNoGetUserInputAmount() {
//		InputStream in = new ByteArrayInputStream("".getBytes());
//		inputController = new InputController(mockUserInput, in);
//		BigDecimal amount = new BigDecimal("100");
//		when(mockUserInput.getAmount()).thenReturn(amount);
//		inputController.getUserInputAmount();
//		verify(mockUserInput).setAmount(amount);
//	}
	
	@Test
	public void test_ControllerInteractsWithGetUserInputAmount() {
		InputStream in = new ByteArrayInputStream("100".getBytes());
		inputController = new InputController(mockUserInput, in);
		BigDecimal amount = new BigDecimal("100");
		when(mockUserInput.getAmount()).thenReturn(amount);
		inputController.getUserInputAmount();
		verify(mockUserInput).setAmount(amount);
	}
	
//	@Test
//	public void test_ControllerInteractsWithIncorrectGetUserInputAmount() {
//		InputStream in = new ByteArrayInputStream("10fff".getBytes());
//		inputController = new InputController(mockUserInput, in);
//		BigDecimal amount = new BigDecimal("100");
//		when(mockUserInput.getAmount()).thenReturn(amount);
//		inputController.getUserInputAmount();
//		verify(mockUserInput).setAmount(amount);
//	}
	
	@Test
	public void test_InputtedCurrencyNameIsContainedInCurrencyMap() {
		InputStream in = new ByteArrayInputStream("USD".getBytes());
		inputController = new InputController(mockUserInput, in);
		UserInput expected = new UserInput("USD");
		UserInput result = inputController.getUserInputCurrency();
		when(mockUserInput.getCurrency()).thenReturn("USD");
		assertEquals(expected.getCurrency(),result.getCurrency());
	}
	
	@Test
	public void test_InputtedCurrencyNameNotInCurrencyMap() {
		InputStream in = new ByteArrayInputStream("BTW".getBytes());
		inputController = new InputController(mockUserInput, in);
		UserInput expected = new UserInput();
		UserInput result = inputController.getUserInputCurrency();
		when(mockUserInput.getCurrency()).thenReturn(null);
		assertEquals(expected.getCurrency(),result.getCurrency());
	}
	
	@Test
	public void test_UserPromptForConversionMethod_True() {
		InputStream in = new ByteArrayInputStream("1".getBytes());
		inputController = new InputController(mockUserInput, in);
		UserInput expected = inputController.getUserPrompt();
		when(mockUserInput.getToOrFromEuro()).thenReturn(true);
		assertTrue(expected.getToOrFromEuro());
	}
	
	@Test
	public void test_UserPromptForConversionMethod_False() {
		InputStream in = new ByteArrayInputStream("2".getBytes());
		inputController = new InputController(mockUserInput, in);
		UserInput expected = inputController.getUserPrompt();
		when(mockUserInput.getToOrFromEuro()).thenReturn(false);
		assertFalse(expected.getToOrFromEuro());
	}
	
	@Test
	public void test_UserPromptForConversionMethod_Other() {
		InputStream in = new ByteArrayInputStream("3".getBytes());
		inputController = new InputController(mockUserInput, in);
		UserInput expected = inputController.getUserPrompt();
		when(mockUserInput.getToOrFromEuro()).thenReturn(true);
		assertTrue(expected.getToOrFromEuro());
	}
}
