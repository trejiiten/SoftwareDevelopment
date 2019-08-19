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
import com.fdmgroup.caruserregistration.persistence.UsernameAlreadyExists;
import com.fdmgroup.caruserregistration.pojo.User;


/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 6670043070206663035L;

	private static Logger log = LogManager.getLogger();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/views/registration.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String cPassword = request.getParameter("cPassword");
		
		User user = new User(firstName, lastName, email, username, password);
		UserDao userDao;
		
		request.setAttribute("user", user);
		RequestDispatcher rdRegister = request.getRequestDispatcher("./WEB-INF/views/registration.jsp");
		
		String regex = "(?-i)(?=^.{8,}$)((?!.*\\s)(?=.*[A-Z])(?=.*[a-z]))((?=(.*\\d){1,})|(?=(.*\\W){1,}))^.*$";
		boolean isValid = password.matches(regex);
		boolean isValidConfirm = cPassword.matches(regex);
		if(!isValid || !isValidConfirm) {
			request.setAttribute("exception", "Your password must be longer than 8 characters, and it must contain UPPERCASE letters, lowercase letters, and digits.");
			rdRegister.forward(request, response);
		} else if(!password.equals(cPassword)) {
			request.setAttribute("exception", "Your passwords must match");
			rdRegister.forward(request, response);
		} else {
		ServletContext appContext = request.getSession().getServletContext();
		userDao = new JPAdao((EntityManagerFactory) appContext.getAttribute("emf"));
		try {
			userDao.create(new User(firstName, lastName, email, username, password));
		} catch (UsernameAlreadyExists e) {
			log.error(e);
			request.setAttribute("exception", "The username you have entered is already taken.");
			rdRegister.forward(request, response);
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		RequestDispatcher rdLogin = request.getRequestDispatcher("./WEB-INF/views/registrationConfirmation.jsp");
		rdLogin.forward(request, response);
		}
	}
}
