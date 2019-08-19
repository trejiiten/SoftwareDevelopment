package com.fdmgroup.caruserregistration.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	private static EntityManagerFactory emf;

	private EntityManagerFactorySingleton() {
	}
	
	public static EntityManagerFactory getInstance() {
		if(emf==null) {
			EntityManagerFactorySingleton.emf = Persistence.createEntityManagerFactory("caruserregistration");
		}
		return emf;
	}
}
