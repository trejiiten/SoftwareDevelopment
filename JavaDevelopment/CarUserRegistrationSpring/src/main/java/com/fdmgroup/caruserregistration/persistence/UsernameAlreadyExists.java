package com.fdmgroup.caruserregistration.persistence;

public class UsernameAlreadyExists extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2696185506075782102L;

	public UsernameAlreadyExists() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsernameAlreadyExists(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UsernameAlreadyExists(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UsernameAlreadyExists(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
