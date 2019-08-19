package com.fdmgroup.caruserregistration.dao;

import com.fdmgroup.caruserregistration.persistence.UserDoesNotExist;
import com.fdmgroup.caruserregistration.persistence.UsernameAlreadyExists;
import com.fdmgroup.caruserregistration.pojo.User;

public interface UserDao {
	void create(User user) throws UsernameAlreadyExists;

	User get(String username) throws UserDoesNotExist;

	void remove(String username) throws UserDoesNotExist;

	User update(User user);

	User get(String username, String password) throws UserDoesNotExist;

}
