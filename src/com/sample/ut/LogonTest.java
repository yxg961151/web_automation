/**
 * 
 */
package com.sample.ut;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sample.Login;

import junit.framework.TestCase;

/**
 * @author xuguang
 *
 */
public class LogonTest extends TestCase {

	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;
	@Mock
	HttpSession session;
	@Mock
	RequestDispatcher rd;

	@Before
	protected void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testServletLogonSuccess() throws Exception, IOException {

		when(request.getParameter("username")).thenReturn("xuguang1");
		when(request.getParameter("password")).thenReturn("secret1");
		when(request.getSession()).thenReturn(session);
		when(request.getRequestDispatcher("homepage.jsp")).thenReturn(rd);

		new Login().doPost(request, response);

		// Verify the session attribute value
		verify(session).setAttribute("username", "xuguang1");
		verify(rd).forward(request, response);
	}

	@Test
	public void testServletLogonFail() throws Exception, IOException {

		when(request.getParameter("username")).thenReturn("");
		when(request.getParameter("password")).thenReturn("");
		when(request.getSession()).thenReturn(session);
		when(request.getRequestDispatcher("logon.jsp")).thenReturn(rd);

		new Login().doPost(request, response);

		// Verify the session attribute value
		verify(session).setAttribute("username", "");
		// Verify the request dispatch path
		verify(rd).include(request, response);
	}
}
