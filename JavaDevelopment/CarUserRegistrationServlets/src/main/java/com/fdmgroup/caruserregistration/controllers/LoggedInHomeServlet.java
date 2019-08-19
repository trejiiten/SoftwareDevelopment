package com.fdmgroup.caruserregistration.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogedInHome
 */
public class LoggedInHomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3974494994064550298L;

	/**
	 * 
	 */
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoggedInHomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rdHome = request.getRequestDispatcher("./WEB-INF/views/home.jsp");
		rdHome.forward(request, response);
	}

}
