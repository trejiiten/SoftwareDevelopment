package com.fdmgroup.caruserregistration.controllers;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fdmgroup.caruserregistration.dao.UserDao;
import com.fdmgroup.caruserregistration.persistence.JPAdao;
import com.fdmgroup.caruserregistration.pojo.User;

/**
 * Servlet implementation class UserSettingsServlet
 */
public class UserSettingsServlet extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 8674582279089189284L;
	private static Logger log = LogManager.getLogger();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public UserSettingsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rdSettings = request.getRequestDispatcher("./WEB-INF/views/settings.jsp");
		rdSettings.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		RequestDispatcher rdRegister = request.getRequestDispatcher("./WEB-INF/views/editInformation.jsp");
		
		UserDao userDao;
		User user;
		
		ServletContext appContext = request.getSession().getServletContext();
		userDao = new JPAdao((EntityManagerFactory) appContext.getAttribute("emf"));
		HttpSession session = request.getSession();
		user = (User) session.getAttribute("user");
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		userDao.update(user);
		session.setAttribute("user", user);
		RequestDispatcher rdLogin = request.getRequestDispatcher("./WEB-INF/views/settings.jsp");
		rdLogin.forward(request, response);
	}

}
