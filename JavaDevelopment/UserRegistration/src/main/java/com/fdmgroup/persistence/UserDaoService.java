package com.fdmgroup.persistence;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fdmgroup.userregistration.Dao;
import com.fdmgroup.userregistration.DuplicateUniqueKeyException;
import com.fdmgroup.userregistration.NoEntryPresentException;
import com.fdmgroup.userregistration.User;

public class UserDaoService implements Dao<User, String> {

	private static Logger log = LogManager.getLogger();
	private EntityManagerFactory emf;
	
	public UserDaoService(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void create(User user) throws DuplicateUniqueKeyException {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(user);
		} catch (PersistenceException e) {
			log.error(e);
			throw new DuplicateUniqueKeyException();
		}
		em.getTransaction().commit();
		em.close();
	
	}

	public User read(long id) {
		EntityManager em = emf.createEntityManager();
		return em.find(User.class, id);
	}

	
	public User read(String name) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<User> query = em.createNamedQuery("User.findByUsername" , User.class);
		query.setParameter(1, name);
		return query.getSingleResult();
	}

	@Override
	public void delete(User user) throws NoEntryPresentException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("User.deleteUser", User.class);
		query.setParameter(1, user.getUsername());
		query.setParameter(2, user.getId());
		try {
			em.remove(query.getSingleResult());
		} catch (NoResultException e) {
			log.error(e);
			throw new NoEntryPresentException();
		}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public User update(User user) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		em.close();
		return user;
	}

	@Override
	public List<User> getAll() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

}
