package com.fdmgroup.userregistration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileUserDao extends UserDao {

	private String name = null;
	private String password = null;
	private String roll = null;
	private String username = null;

	@Override
	public void create(User user) {
		File file = new File("users.txt");
		try (FileWriter writer = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(writer)) {
			if (!file.exists()) {
				file.createNewFile();
			}
			bw.write(user.toString());
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User user) {
		FileUserDao fileUserDao = new FileUserDao();
		fileUserDao.read(username);
		

	}

	@Override
	public List<User> getAll() {
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get("./users.txt"));
			System.out.println(lines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User read(String username) {
		try (FileReader reader = new FileReader("users.txt"); BufferedReader br = new BufferedReader(reader)) {
			List<String> lines = Files.readAllLines(Paths.get("users.txt"));
			System.out.println(lines);
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts[0].equals(username)) {
					username=parts[0];
					long id = Long.parseLong(parts[1]);
					name = parts[2];
					password = parts[3];
					roll = parts[4];
					System.out.println(parts);
					System.out.println(id + " " + name + " " + password + " " + roll);
					return new User(id, name, password, roll);
				}
			}
			if (!line.contains(username)) {
				System.err.println("The username " + username + " does not exist.");
			}
		} catch (IOException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User update(User user) {
		FileUserDao fileUserDao = new FileUserDao();
		String username=null;
		fileUserDao.read(username);
		fileUserDao.delete(user);
		fileUserDao.create(user);
		return new User();
	}

}
