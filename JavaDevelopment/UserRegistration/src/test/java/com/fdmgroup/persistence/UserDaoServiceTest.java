package com.fdmgroup.persistence;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fdmgroup.userregistration.DuplicateUniqueKeyException;
import com.fdmgroup.userregistration.NoEntryPresentException;
import com.fdmgroup.userregistration.User;

public class UserDaoServiceTest {
	UserDaoService service;
	 User user;
	EntityManagerFactory emf;
	
	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("user_registration_test");
		service = new UserDaoService(emf);
	}
	

	@Test
	public void test_addUserToDatabase() throws DuplicateUniqueKeyException {
		user = new User("Joe1","Joe","HiHo34","Janitor");
		User user2 = new User("Joe1","Joe","HiHo34","Janitor");
		service.create(user);
		service.create(user2);
		assertEquals(user, service.read(user.getId()));
	}
	
	@Test
	public void test_ReadUserByUsernameFromDatabase() throws DuplicateUniqueKeyException {
		user = new User("Joe3","Joe","HiHo34","Janitor");
		service.create(user);
		assertEquals(user,service.read(user.getUsername()));
	}
	
	@Test
	public void test_UpdateUserInDatabase() throws DuplicateUniqueKeyException {
		user = new User("Joe3","Joe","HiHo34","Janitor");
		service.create(user);
		user.setName("Jimmy");
		service.update(user);
		assertEquals(user.getName(),service.read(user.getUsername()).getName());
	}
	
	@Test(expected=NoResultException.class)
	public void test_DeleteUserInDatabase() throws DuplicateUniqueKeyException, NoEntryPresentException {
		user = new User("Joe3","Joe","HiHo34","Janitor");
		User user2 = new User("Joe4","Joe","HiHo34","Janitor");
		service.create(user);
		service.create(user2);
		user2.setName("Jimmy");
		service.update(user2);
		service.delete(user);
		service.read(user.getUsername());
	}
	
	@Test
	public void test_getAll() throws DuplicateUniqueKeyException {
		user = new User("Joe3","Joe","HiHo34","Janitor");
		User user2 = new User("Joe4","Joe","HiHo34","Janitor");
		service.create(user);
		service.create(user2);
		List<User> users = service.getAll();
		assertTrue(users.contains(user));
	}

}
