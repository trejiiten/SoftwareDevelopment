package com.fdmgroup.userregistration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="User_table")
@NamedQueries({ 
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = ?1"),
	@NamedQuery(name = "User.deleteUser", query = "SELECT u FROM User u WHERE u.username = ?1 AND u.id = ?2")
})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
	@SequenceGenerator(name = "user_id_generator", sequenceName = "user_id_sequence", allocationSize = 1)
	private long id;
	private String name;
	private String password;
	private String roll;
	private String username;
	
	public User() {
		
	}
	
	public User(long id, String name, String password, String roll) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.roll = roll;
	}


	public User(String name, String password, String roll) {
		this.name = name;
		this.password = password;
		this.roll = roll;
	}

	public User(long id, String username, String name, String password, String roll) {
		this.id = id;
		this.username= username;
		this.name = name;
		this.password = password;
		this.roll = roll;
	}
	
	public User(String username, String name, String password, String roll) {
		this.username= username;
		this.name = name;
		this.password = password;
		this.roll = roll;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	@Override
	public String toString() {
		return id + "," + name + id + "," + name + "," + password + "," + roll;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	

}
