package com.fdmgroup.piggybank;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ConversionRatesTester.class, ConverterControllerTest.class, InputControllerTest.class, ViewTest.class })
public class AllTests {

}
