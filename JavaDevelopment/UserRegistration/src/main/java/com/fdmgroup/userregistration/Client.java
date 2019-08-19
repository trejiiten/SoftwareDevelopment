package com.fdmgroup.userregistration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Client {

	public static void main(String[] args) {
		Properties properties = loadProperties("db.properties");
		if (properties == null)
			return;

		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
	}
	
	public static Properties loadProperties(String filename) {

		try {
			InputStream inputStream = DatabaseDao.class.getResourceAsStream("/" + filename);
			Properties properties = new Properties();

			properties.load(inputStream);
			return properties;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
