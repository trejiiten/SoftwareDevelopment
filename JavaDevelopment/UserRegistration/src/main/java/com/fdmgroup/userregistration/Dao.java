package com.fdmgroup.userregistration;

import java.util.List;

public interface Dao <User, String> {

	void create(User user) throws DuplicateUniqueKeyException;
	User read(String name) ;
	void delete(User user) throws NoEntryPresentException ;
	User update(User user) ;
	List<User> getAll();
	

}
