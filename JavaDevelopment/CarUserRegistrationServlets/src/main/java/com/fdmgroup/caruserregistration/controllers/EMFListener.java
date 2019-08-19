package com.fdmgroup.caruserregistration.controllers;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fdmgroup.caruserregistration.dao.EntityManagerFactorySingleton;

/**
 * Application Lifecycle Listener implementation class EMFListener
 *
 */
public class EMFListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public EMFListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	ServletContext appContext = sce.getServletContext();
        EntityManagerFactory emf = (EntityManagerFactory) appContext.getAttribute("emf");
        emf.close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext appContext = sce.getServletContext();
    	appContext.setAttribute("emf", EntityManagerFactorySingleton.getInstance());
    }
	
}
