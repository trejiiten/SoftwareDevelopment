package com.fdmgroup.userregistration;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FileUserDaoTest {

	FileUserDao mockFileUserDao;
	FileUserDao fileUserDao;
	User mockUser;
	
	@Before
	public void setUp() throws Exception {
		mockUser = mock(User.class);
		mockFileUserDao = mock(FileUserDao.class);
		fileUserDao = new FileUserDao();
	}

	@Test
	public void test_createUserWritesToFile() throws FileNotFoundException {
		File f = new File("users.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		User user = new User(Long.parseLong("5"),"Bob","123456","HR");
		fileUserDao.create(user);
		String expected = "Bob5,5,Bob,123456,HR";
//		assertEquals(user, fileUserDao.create(user));
	}
	
	@Test
	public void test_ReadUserReadsFromFile() throws IOException {
		User user = new User(Long.parseLong("3"),"Bob","123456","HR");
		fileUserDao.create(user);
		String username = "Bob3";
		mockFileUserDao.read(username);
		verify(mockFileUserDao).read(username);
	}
	
	@Test
	public void test_ReadUserFromFile() {
		User user = new User(Long.parseLong("3"),"Bob","123456","HR");
		User user2 = new User(Long.parseLong("5"),"Bob","123456","HR");
		fileUserDao.create(user);
		fileUserDao.create(user2);
		fileUserDao.read("Bob3");
		fileUserDao.read("Bob5");
//		String expected1="Bob3,3,Bob,123456,HR";
//		String expected2="Bob5,5,Bob,123456,HR";
		assertEquals(user.getName(), fileUserDao.read("Bob3").getName());
		assertEquals(user2.getName(), fileUserDao.read("Bob5").getName());
		
	}
	
	
	@Test
	public void test_getAll() {
		List<User> list = new ArrayList<>();
		list.add(mockUser);
		list.add(mockUser);
		list.add(mockUser);
		list.add(mockUser);
		when(mockFileUserDao.getAll()).thenReturn(list);
		mockFileUserDao.getAll();
		System.out.println(list);
		verify(mockFileUserDao).getAll();
	}
	
//	@Test
//	public void test_UpdateUserRegularName() {
//		String name = "Bob";
//		String newName = "Randy";
//		when(mockFileUserDao.update(mockUser)).thenReturn(new User(newName));
//		mockFileUserDao.update(mockUser);
//		System.out.println(mockUser.getName());
//		verify(mockFileUserDao).update(mockUser);
//	}

}
