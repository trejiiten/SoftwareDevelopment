package com.fdmgroup.caruserregistration.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fdmgroup.caruserregistration.dao.UserDao;
import com.fdmgroup.caruserregistration.pojo.User;

public class JPAdao implements UserDao {

	private static Logger log = LogManager.getLogger();
	private EntityManagerFactory emf;
	User user;

	public JPAdao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void create(User user) throws UsernameAlreadyExists {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			log.error(e);
			throw new UsernameAlreadyExists();
		} finally {
			em.close();
		}
	}

	@Override
	public User get(String username) throws UserDoesNotExist {
		EntityManager em = emf.createEntityManager();
		TypedQuery<User> query = em.createNamedQuery("User.findByUsername", User.class);
		try {
			query.setParameter(1, username);
		} catch (NoResultException e) {
			log.error(e);
			throw new UserDoesNotExist();
		}
		return query.getSingleResult();
	}

	@Override
	public void remove(String username) throws UserDoesNotExist {
		User user = get(username);
		EntityManager em = emf.createEntityManager();
		if (user != null) {
			em.getTransaction().begin();
			Query query = em.createNamedQuery("User.deleteUser", User.class);
			query.setParameter(1, user.getUsername());
			query.setParameter(2, user.getId());
			em.remove(query.getSingleResult());
			em.getTransaction().commit();
		}
		em.close();
	}

	@Override
	public User update(User user) {
		EntityManager em = emf.createEntityManager();
		if (user != null) {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
		}
		em.close();
		return user;
	}

	@Override
	public User get(String username, String password) throws UserDoesNotExist {
		EntityManager em = emf.createEntityManager();
		TypedQuery<User> query = em.createNamedQuery("User.findByUsernameAndPassword", User.class);
		try {
			query.setParameter(1, username);
			query.setParameter(2, password);
			return query.getSingleResult();
		} catch (NoResultException e) {
			log.error(e);
			throw new UserDoesNotExist();
		}
	}

}
