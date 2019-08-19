package com.fdmgroup.caruserregistration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fdmgroup.caruserregistration.dao.EntityManagerFactorySingleton;
import com.fdmgroup.caruserregistration.persistence.JPAdao;
import com.fdmgroup.caruserregistration.persistence.UserDoesNotExist;
import com.fdmgroup.caruserregistration.persistence.UsernameAlreadyExists;
import com.fdmgroup.caruserregistration.pojo.User;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= "com.fdmgroup.caruserregistration")
@Import(value = { WebConfig.class })
public class AppConfig {

	@Bean
	@Scope("prototype")
	public User user() {
		return new User();
	}
	
	@Bean 
	public UserDoesNotExist userDoesNotExist() {
		return new UserDoesNotExist();
	}
	
	@Bean
	public UsernameAlreadyExists usernameAlreadyExists() {
		return new UsernameAlreadyExists();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public JPAdao userDao() {
		return new JPAdao(EntityManagerFactorySingleton.getInstance());
	}
}
