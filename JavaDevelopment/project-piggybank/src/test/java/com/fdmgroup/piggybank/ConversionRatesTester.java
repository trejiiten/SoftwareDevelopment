package com.fdmgroup.piggybank;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

public class ConversionRatesTester {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_readCurrencyXMLReadsXMLProvided() {
		int allCurrencies = ConversionRates.currencyMap.size();
		assertEquals(32, allCurrencies);
	}

	@Test
	public void test_CurrencyMapPullsTheCorrectRateForEuroToUSD() {
		BigDecimal dollarRate = ConversionRates.currencyMap.get("USD");

		BigDecimal correctRate = new BigDecimal(1.12572).setScale(4, RoundingMode.DOWN);

		assertEquals(correctRate, dollarRate);
	}

}
