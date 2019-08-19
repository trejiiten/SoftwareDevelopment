package com.fdmgroup.piggybank;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.math.BigDecimal;
import org.junit.Test;

public class ViewTest {

	@Test
	public void test_toCheckThatAllUserInputGettersRun_WhenTrue() {
		UserInput mockUserInput = mock(UserInput.class);
		when(mockUserInput.getAmount()).thenReturn(new BigDecimal(100));
		when(mockUserInput.getCurrency()).thenReturn("JPY");
		when(mockUserInput.getToOrFromEuro()).thenReturn(true);
		View.printConversion(mockUserInput, new BigDecimal(1000));
		verify(mockUserInput).getAmount();
		verify(mockUserInput, times(2)).getCurrency();
		verify(mockUserInput).getToOrFromEuro();
	}

}
