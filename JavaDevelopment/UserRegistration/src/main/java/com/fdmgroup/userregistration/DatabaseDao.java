package com.fdmgroup.userregistration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseDao implements Dao<User, String> {
	private static Logger log = LogManager.getLogger();

	private String url;
	private String username;
	private String password;

	public DatabaseDao(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public DatabaseDao() {	}

	Connection conn = null;

	@Override
	public void create(User user) throws DuplicateUniqueKeyException{
		if(read(user.getUsername()) == null) {
			try {
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				conn = DriverManager.getConnection(url, username, password);

				if (conn == null) {
					return;
				}
				
				if(user.getUsername().equals(null)){
					log.warn("Please answer every prompt");
					return;
				}
				String function = "{call addUser(?,?,?,?,?)}";

				CallableStatement statement = conn.prepareCall(function);

				statement.setLong(1, user.getId());
				statement.setString(2, user.getUsername());
				statement.setString(3, user.getName());
				statement.setString(4, user.getPassword());
				statement.setString(5, user.getRoll());

				statement.executeUpdate();
			} catch (SQLException | NullPointerException e) {
				log.error(e.getMessage());
				throw new DuplicateUniqueKeyException();
			} finally {
				try {
					conn.close();
				} catch (SQLException sqle) {
					log.error(sqle.getMessage());
				}
			}
		}  else {
			log.warn("This user already exists");
			return;
		} 
		
	}

	@Override
	public User read(String name) throws NullPointerException {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection(url, username, password);

			if (conn == null)
				return null;
			String query = "SELECT id,USERNAME,NAME,PASSWORD,ROLL FROM USER_TABLE WHERE USERNAME = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, name);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return new User(rs.getLong("id"), rs.getString("USERNAME"), rs.getString("NAME"),
						rs.getString("PASSWORD"), rs.getString("ROLL"));
			}
		} catch (SQLException | NullPointerException e) {
			log.error(e.getMessage());
		
			return null;
			
		} finally {

			try {
				conn.close();
			} catch (SQLException sqle) {
				log.error(sqle.getMessage());
			}
		}
		return null;

	}

	@Override
	public void delete(User user) throws NoEntryPresentException {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection(url, username, password);

			if (conn == null)
				return;
			String query = "DELETE FROM USER_TABLE WHERE ID = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setLong(1, user.getId());

			preparedStatement.executeQuery();

		} catch (SQLException | NullPointerException e) {
			log.error(e.getMessage());
			throw new NoEntryPresentException();
		} finally {
			try {
				conn.close();
			} catch (SQLException sqle) {
				log.error(sqle.getMessage());
			}
		}
	}

	@Override
	public User update(User user) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection(url, username, password);

			if (conn == null)
				return null;
			String function = "{call updateUser(?,?,?,?,?)}";

			CallableStatement statement = conn.prepareCall(function);

			statement.setString(1, user.getUsername());
			statement.setString(2, user.getName());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getRoll());
			statement.setLong(5, user.getId());

			statement.executeUpdate();
			
			return user;
		} catch (SQLException e) {
			log.error(e);
			return null;
		}
	}

	@Override
	public List<User> getAll() {
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection(url, username, password);

			if (conn == null) {
				return null;
			}
			
			String query = "SELECT id, USERNAME, NAME, PASSWORD, ROLL FROM USER_TABLE";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			List<User> users = new ArrayList<>();
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
			users.add(new User(rs.getLong("id"), rs.getString("USERNAME"), rs.getString("NAME"),
						rs.getString("PASSWORD"), rs.getString("ROLL")));
			}
			return users;
			
		} catch (SQLException e) {
			log.error(e);
			return null;
		}
		
	}

}
