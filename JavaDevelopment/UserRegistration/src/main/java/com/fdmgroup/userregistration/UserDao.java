package com.fdmgroup.userregistration;

public abstract class UserDao implements Dao<User, String> {
	public abstract User read(String user);
}
