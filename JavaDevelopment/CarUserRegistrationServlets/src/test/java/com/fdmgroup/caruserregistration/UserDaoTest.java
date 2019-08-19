package com.fdmgroup.caruserregistration;

import static org.junit.Assert.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fdmgroup.caruserregistration.dao.EntityManagerFactorySingleton;
import com.fdmgroup.caruserregistration.dao.UserDao;
import com.fdmgroup.caruserregistration.persistence.JPAdao;
import com.fdmgroup.caruserregistration.persistence.UserDoesNotExist;
import com.fdmgroup.caruserregistration.persistence.UsernameAlreadyExists;
import com.fdmgroup.caruserregistration.pojo.User;

public class UserDaoTest {
	private static EntityManagerFactory emf;
	private static User superUser;
	private static UserDao userDao;
	private static User user;

	@BeforeClass
	public static void setUp() throws Exception {
		emf = EntityManagerFactorySingleton.getInstance();
		superUser = new User("Todd", "Rings", "todd.rings@test.com", "user1", "h3l!0");
		user = new User("first", "last", "user@test.com", "user3", "pass3");
		userDao = new JPAdao(emf);
		userDao.create(superUser);
		userDao.create(user);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userDao.remove("user1");
		userDao.remove("user2");
		userDao.remove("Ghost");
	}

	@Test
	public void test_createPersistsUserToDatabase() throws UsernameAlreadyExists, UserDoesNotExist {
		User user2 = new User("first", "last", "user@test.com", "user2", "pass");
		userDao.create(user2);
		assertEquals(user2, userDao.get(user2.getUsername()));
	}
	
	@Test(expected=UsernameAlreadyExists.class)
	public void test_createDuplicatePersistsUserToDatabase() throws UsernameAlreadyExists, UserDoesNotExist {
		User user2 = new User("first", "last", "user@test.com", "user3", "pass");
		User user3 = new User("first", "last", "user@test.com", "user3", "pass");
		userDao.create(user2);
		userDao.create(user3);
	}

	@Test
	public void test_getUserFromDatabase_ByUsername() throws UsernameAlreadyExists, UserDoesNotExist {
		userDao.get(superUser.getUsername());
		assertEquals(superUser, userDao.get(superUser.getUsername()));
	}

	@Test
	public void test_getUserFromDatabase_ByUsernameAndPassword() throws UsernameAlreadyExists, UserDoesNotExist {
		userDao.get(user.getUsername(), user.getPassword());
		assertEquals(user, userDao.get(user.getUsername(), user.getPassword()));
	}

	@Test
	public void test_UpdateUserFromDatabase() throws UsernameAlreadyExists, UserDoesNotExist {
		User user2 = new User("Joe", "Blo", "joe@test.com", "HiHo34", "Janitor");
		userDao.create(user2);
		user2.setFirstName("John");
		user2.setLastName("Snow");
		user2.setEmail("you.know.nothing@winterfell.net");
		user2.setUsername("Ghost");
		user2.setPassword("1Am7he6R347357");
		userDao.update(user2);
		assertEquals(user2.getUsername(), userDao.get("Ghost").getUsername());
	}

	@Test(expected = NoResultException.class)
	public void test_removeUserFromDatabase() throws UsernameAlreadyExists, UserDoesNotExist {
		userDao.remove(user.getUsername());
		userDao.get(user.getUsername());
	}
}
