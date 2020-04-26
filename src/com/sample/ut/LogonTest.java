/**
 * 
 */
package com.sample.ut;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sample.Login;

/**
 * @author xuguang
 *
 */
public class LogonTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.sample.Angel#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link com.sample.Angel#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getParameter("username")).thenReturn("me");
		when(request.getParameter("password")).thenReturn("secret");

		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		try {
			when(response.getWriter()).thenReturn(writer);
			new Login().doPost(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		verify(request, atLeast(1)).getParameter("username"); // only if you want to verify username was called...
		writer.flush(); // it may not have been flushed yet...
		assertTrue(stringWriter.toString().contains("me"));

	}

}
