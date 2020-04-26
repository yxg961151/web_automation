/**
 * 
 */
package com.sample.ut;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sample.Register;

import junit.framework.TestCase;

/**
 * @author xuguang
 *
 */
public class RegisterTest extends TestCase{

	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;
	@Mock
	HttpSession session;
	@Mock
	RequestDispatcher rd;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}


	/**
	 * Test method for {@link com.sample.Register#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws Exception 
	 * @throws ServletException 
	 */
	@Test
	public void testServletRegisterSuccess() throws ServletException, Exception {

		when(request.getParameter("first_name")).thenReturn("xuguang");
		when(request.getParameter("last_name")).thenReturn("yang");
		when(request.getParameter("username")).thenReturn("xuguang");
		when(request.getParameter("password")).thenReturn("secret");
		when(request.getParameter("address")).thenReturn("address");
		when(request.getParameter("contact")).thenReturn("contact");
		
		when(request.getSession()).thenReturn(session);
		when(request.getRequestDispatcher("logon.jsp")).thenReturn(rd);
		

		new Register().doPost(request, response);
		// Verify the session attribute value
		verify(session).setAttribute("username", "xuguang");
		verify(session).setAttribute("password", "secret");
		verify(rd).forward(request, response);

	}

	/**
	 * Test method for {@link com.sample.Register#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws Exception 
	 * @throws ServletException 
	 */
	@Test
	public void testServletRegisterFail1() throws ServletException, Exception {

		when(request.getParameter("first_name")).thenReturn("xuguang");
		when(request.getParameter("last_name")).thenReturn("yang");
		when(request.getParameter("username")).thenReturn("Denver");
		when(request.getParameter("password")).thenReturn("secret");
		when(request.getParameter("address")).thenReturn("address");
		when(request.getParameter("contact")).thenReturn("");
		
		when(request.getSession()).thenReturn(session);
		when(request.getRequestDispatcher("register.jsp")).thenReturn(rd);
		

		new Register().doPost(request, response);		

		// Verify the session attribute value
		verify(session).setAttribute("username", null);
		verify(session).setAttribute("first_name", "xuguang");
		verify(session).setAttribute("last_name", "yang");
		verify(session).setAttribute("password", "secret");
		verify(session).setAttribute("address", "address");
		verify(session).setAttribute("contact", "");

		
		verify(rd).include(request, response);
	}
	
	@Test
	public void testServletRegisterFail2() throws ServletException, Exception {

		when(request.getParameter("first_name")).thenReturn("");
		when(request.getParameter("last_name")).thenReturn("");
		when(request.getParameter("username")).thenReturn("xuguang");
		when(request.getParameter("password")).thenReturn("");
		when(request.getParameter("address")).thenReturn("address");
		when(request.getParameter("contact")).thenReturn("contact");
		
		when(request.getSession()).thenReturn(session);
		when(request.getRequestDispatcher("register.jsp")).thenReturn(rd);
		

		new Register().doPost(request, response);

		
		// Verify the session attribute value
		verify(session).setAttribute("username", "xuguang");
		verify(session).setAttribute("first_name", "");
		verify(session).setAttribute("last_name", "");
		verify(session).setAttribute("password", "");
		verify(session).setAttribute("address", "address");
		verify(session).setAttribute("contact", "contact");
		
		verify(rd).include(request, response);
	}
}
