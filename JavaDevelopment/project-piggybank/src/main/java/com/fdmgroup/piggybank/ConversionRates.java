package com.fdmgroup.piggybank;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

/**
 * Utilizes JDOM2 to parse through an XML document
 * from the European Central Bank.
 * 
 * @see <a href="https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml">Euro Conversion Rates</a>
 * 
 * @author Mason.Scott
 * @version 1.0.0
 */

public class ConversionRates {
	private static Logger logger = LogManager.getLogger("com.fdmgroup.piggybank");
	
	
	/**
	 * Acting as a "database" is a static HashMap which contains 
	 * currency names and their rate compared to Euros. Created
	 * at runtime.
	 * 
	 * @see java.util.HashMap#HashMap()
	 */
	public static Map<String, BigDecimal> currencyMap = new HashMap<>();
	
	static {
		
	
	try {
	URL url = new URL("https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
	
	SAXBuilder saxBuilder = new SAXBuilder();
	Document document = saxBuilder.build(url);
	
	Element rootElement = document.getRootElement();
	Element childElement = rootElement.getChild("Cube", Namespace.getNamespace("http://www.ecb.int/vocabulary/2002-08-01/eurofxref"));
	Element cube = childElement.getChild("Cube", Namespace.getNamespace("http://www.ecb.int/vocabulary/2002-08-01/eurofxref"));
	List<Element> elementList = cube.getChildren();
	
	
	
	for (int i=0; i < elementList.size(); i++) {
		String currencyName = elementList.get(i).getAttribute("currency").getValue();
		BigDecimal conversionRate = new BigDecimal(elementList.get(i).getAttribute("rate").getValue());
		currencyMap.put(currencyName, conversionRate);
		
	}
	
	} catch (MalformedURLException me) {
		logger.fatal("Malformed URL passed");
	} catch (IOException ioe) {
		logger.fatal("I/O exception occurred");
	} catch (JDOMException jde) {
		logger.fatal("XML is not well formed");
	}
	

	
	
	}
	
}
