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
import com.fdmgroup.caruserregistration.persistence.UserDoesNotExist;
import com.fdmgroup.caruserregistration.pojo.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 3124956093050892189L;
	private static Logger log = LogManager.getLogger();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/views/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		UserDao userDao;
		
		
		request.setAttribute("user", user);
		
		RequestDispatcher rdLogin = request.getRequestDispatcher("./WEB-INF/views/login.jsp");
		
		
		ServletContext appContext = request.getSession().getServletContext();
		userDao = new JPAdao((EntityManagerFactory) appContext.getAttribute("emf"));
		try {
			user = userDao.get(username, password);
		} catch (UserDoesNotExist e) {
			log.error(e);
			request.setAttribute("exception", "You have entered the incorrect credentials");
			rdLogin.forward(request, response);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		RequestDispatcher rdLogged = request.getRequestDispatcher("./WEB-INF/views/loginConfirmation.jsp");
		rdLogged.forward(request, response);
		}
	

}
