package com.fdmgroup.caruserregistration.pojo;

public class UserFactory {

	private static long idCounter;
	User user;
	
	public static User createUser(String first_name, String last_name, String email, String username, String password) {
		return new User(idCounter++, first_name, last_name, email, username, password);
	}
	
	public static long getIdCounter() {
		return idCounter;
	}
}
