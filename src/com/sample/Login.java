package com.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.isEmpty() || password.isEmpty()) {
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			RequestDispatcher req = request.getRequestDispatcher("logon.jsp");
			req.include(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			RequestDispatcher req = request.getRequestDispatcher("homepage.jsp");
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
