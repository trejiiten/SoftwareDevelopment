package com.fdmgroup.userregistration;

public class RegistrationController {

	private UserFactory userFactory;
	private Dao<User, String> dao;

	public RegistrationController(UserFactory userFactory, Dao<User, String> dao) {
		this.userFactory = userFactory;
		this.dao = dao;
	}

	public void registerNewUser(String name, String password, String roll) {
	userFactory.createUser(name, password, roll);
	}
	
	public void registerNewUser(String username, String name, String password, String roll) {
		userFactory.createUser(username, name, password, roll);
		}

}
