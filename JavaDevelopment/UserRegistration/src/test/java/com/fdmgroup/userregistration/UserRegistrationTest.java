package com.fdmgroup.userregistration;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class UserRegistrationTest {
	RegistrationController rc;
	User user;
	User mockUser;
	Dao mockDao;
	UserFactory mockUserFactory;
	UserFactory uf;
	
	@Before
	public void setUp() throws Exception {
		mockUser = mock(User.class);
		mockUserFactory = mock(UserFactory.class);
		mockDao = mock(Dao.class);
		uf = new UserFactory();
		user = new User();
		rc = new RegistrationController(mockUserFactory, mockDao);
	}

	@Test
	public void test_UserFactoryCreatesNewUser() {
		
		String name = "Bob";
		String password = "1234";
		String roll = "HR";
		when(mockUserFactory.createUser(name, password, roll)).thenReturn(new User());
		rc.registerNewUser(name, password, roll);
		verify(mockUserFactory).createUser(name, password, roll);
	}
	
	
	
	@Test
	public void test_idCounter() {
		RegistrationController rc = new RegistrationController(uf, mockDao);
		rc.registerNewUser("Bob", "1234", "HR");
		rc.registerNewUser("Bob", "1234", "HR");
		rc.registerNewUser("Bob", "1234", "HR");
		rc.registerNewUser("Bob", "1234", "HR");
		long result = UserFactory.getIdCounter();
		assertEquals(4, result);
	}
	

	
	
	

}
