package com.fdmgroup.userregistration;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DatabaseDaoTest {
	private static DatabaseDao dbDao;
	private static User user;
	private static User user2;

	@BeforeClass
	public static void setUp() throws Exception {
		dbDao = new DatabaseDao("jdbc:oracle:thin:@localhost:1521:XE", "test", "password");
		user = new User(1,"Dan7", "Dan", "Hello123", "CEO");
		user2 = new User(2,"Dan1", "Dan", "Hello123", "CEO");
		dbDao.create(user);
		dbDao.create(user2);
	}

	@AfterClass
	public static void tearDown() throws Exception {
	}

	@Test
	public void test_addUserToDatabase() throws DuplicateUniqueKeyException {
		User user3 = new User(3,"Dan8", "Dan", "Hello123", "CEO");
		dbDao.create(user3);
		assertEquals(user3.getId(), dbDao.read(user3.getUsername()).getId());
	}

	

	@Test
	public void test_RemoveUserFromDatabase() throws NoEntryPresentException, DuplicateUniqueKeyException {
		User user3 = new User(3,"Dan8", "Dan", "Hello123", "CEO");
		dbDao.create(user3);
		dbDao.delete(user3);
		dbDao.read(user3.getUsername());
	}

	@Test(expected=NoEntryPresentException.class)
	public void test_RemoveNullFromDatabase() throws NoEntryPresentException {
		String name = "";
		User user = dbDao.read(name);
		dbDao.delete(user);
		User user2 = dbDao.read(name);
		assertNull(user2);
	}

	@Test
	public void test_UpdateUserInDatabase() throws DuplicateUniqueKeyException {
		
		user2.setUsername("Joe5");
		user2.setName("Joe");
		user2.setPassword("YOYOYO2312");
		user2.setRoll("basic");
		User result = dbDao.update(user2);
		User expected = dbDao.read(user2.getUsername());

		assertEquals(user2.getId(), expected.getId());

	}

	@Test
	public void test_ReadUserInDatabase() throws NullPointerException {
		
		User result = dbDao.read(user.getUsername());
		System.out.println(result.getId());

	}

	@Test
	public void test_GetListOfUsersFromDatabase() throws DuplicateUniqueKeyException {
//		User user3 = new User(3,"Dan6", "Dan", "Hello123", "CEO");
//		User user4 = new User(4,"Dan9", "Dan", "Hello123", "CEO");
//		dbDao.create(user3);
//		dbDao.create(user4);
		List<User> users = dbDao.getAll();
		assertTrue(users.contains(user));
	}

}
