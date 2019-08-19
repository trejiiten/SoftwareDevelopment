package com.fdmgroup.userregistration;

public class UserFactory {

	private static long idCounter;
	User user;

	public UserFactory() {}

	public User createUser(String name, String password, String roll) {
		
		return new User(idCounter++, name, password, roll);
	}
	
	public User createUser(String username, String name, String password, String roll) {
		return new User(username, name, password,roll);
	}

	public static long getIdCounter() {
		return idCounter;
	}

	
}
