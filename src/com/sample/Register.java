package com.sample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");

		if (first_name.isEmpty() || last_name.isEmpty() || username.isEmpty() || password.isEmpty()
				|| username.equals("Denver")) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("first_name", first_name);
			session.setAttribute("last_name", last_name);
			session.setAttribute("address", address);
			session.setAttribute("contact", contact);
//			session.setAttribute("password", password);
			if (!username.equals("Denver")) {
				session.setAttribute("username", username);
			} else {
				session.setAttribute("username", null);
			}
			
			RequestDispatcher req = request.getRequestDispatcher("register.jsp");
			req.include(request, response);
		} else {
			HttpSession session = request.getSession();
			
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			RequestDispatcher req = request.getRequestDispatcher("logon.jsp");
			req.forward(request, response);
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			super.init(config);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
