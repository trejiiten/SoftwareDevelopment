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
 * Servlet implementation class ChangePasswordServlet
 */
public class ChangePasswordServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7908442664884545372L;
	private static Logger log = LogManager.getLogger();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rdChangePassword = request.getRequestDispatcher("./WEB-INF/views/changePassword.jsp");
		rdChangePassword.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		String nPassword = request.getParameter("nPassword");
		String cPassword = request.getParameter("cPassword");

		UserDao userDao;

		ServletContext context = request.getSession().getServletContext();
		HttpSession session = request.getSession();

		RequestDispatcher rdChangePassword = request.getRequestDispatcher("./WEB-INF/views/changePassword.jsp");

		String regex = "(?-i)(?=^.{8,}$)((?!.*\\s)(?=.*[A-Z])(?=.*[a-z]))((?=(.*\\d){1,})|(?=(.*\\W){1,}))^.*$";
		boolean isValid = password.matches(regex);
		boolean isValidConfirm = cPassword.matches(regex);
		if (!isValid || !isValidConfirm) {
			request.setAttribute("exception",
					"Your password must be longer than 8 characters, and it must contain UPPERCASE letters, lowercase letters, and digits.");
			rdChangePassword.forward(request, response);
		}

		if (!nPassword.equals(cPassword)) {
			request.setAttribute("exception", "Your passwords must match");
			rdChangePassword.forward(request, response);
		}
		
		if (!(password.equals(((User) session.getAttribute("user")).getPassword()))) {
			request.setAttribute("exception", "You entered the incorrect credentials");
			rdChangePassword.forward(request, response);
		} else {
			userDao = new JPAdao((EntityManagerFactory) context.getAttribute("emf"));
			User user = (User) session.getAttribute("user");
			user.setPassword(nPassword);
			userDao.update(user);
			RequestDispatcher rdSettings = request.getRequestDispatcher("./WEB-INF/views/settings.jsp");
			rdSettings.forward(request, response);
		}
	}

}
