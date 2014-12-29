package Mokito;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Database.DBConnection;
import Servlets.RegServlet;

public class RegisterServletTest {
	private RegServlet regservlet;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private PrintWriter writer;
	private HttpSession session;
	private DBConnection DB;

	@Before
	public void setUp() throws Exception {
		try{
			new DBConnection("DELETE from Players where username=\"chris1994\";");
		}catch(SQLException se){
			se.printStackTrace();
		}
		
		MockitoAnnotations.initMocks(this);
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		writer = Mockito.mock(PrintWriter.class);
		session = Mockito.mock(HttpSession.class);
		DB = Mockito.mock(DBConnection.class);
		Mockito.doReturn(session).when(request).getSession();
		regservlet = new RegServlet();
	}

	@Test
	public void CreateUserSuccessfulTest() throws ServletException, IOException {
		Mockito.doReturn("chris1994").when(request).getParameter("username");
		Mockito.doReturn("testing123").when(request).getParameter("password");
		Mockito.doReturn("Christopher").when(request).getParameter("name");
		Mockito.doReturn("Cutajar").when(request).getParameter("surname");
		Mockito.doReturn("1994-12-18").when(request).getParameter("dob");
		Mockito.doReturn("0").when(request).getParameter("account_type");
		Mockito.doReturn("378282246310005").when(request).getParameter("cc_num");
		Mockito.doReturn("2019-05").when(request).getParameter("cc_exp");
		Mockito.doReturn("123").when(request).getParameter("cvv");
		
		regservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/RegistrationSuccess.html");
	}
	
	@Test
	public void UserAlreadyExistsTest() throws ServletException, IOException {		
		Mockito.doReturn("ChrisTest").when(request).getParameter("username"); //already in database
		Mockito.doReturn("testing123").when(request).getParameter("password");
		Mockito.doReturn("Christopher").when(request).getParameter("name");
		Mockito.doReturn("Cutajar").when(request).getParameter("surname");
		Mockito.doReturn("1994-12-18").when(request).getParameter("dob");
		Mockito.doReturn("0").when(request).getParameter("account_type");
		Mockito.doReturn("378282246310005").when(request).getParameter("cc_num");
		Mockito.doReturn("2019-05").when(request).getParameter("cc_exp");
		Mockito.doReturn("123").when(request).getParameter("cvv");
		
		regservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/ErrorAlreadyExists.html");
	}

	@Test
	public void UserNotAddedTest() throws ServletException, IOException {		
		Mockito.doReturn("chris").when(request).getParameter("username"); //short username
		Mockito.doReturn("testing123").when(request).getParameter("password");
		Mockito.doReturn("Christopher").when(request).getParameter("name");
		Mockito.doReturn("Cutajar").when(request).getParameter("surname");
		Mockito.doReturn("1994-12-18").when(request).getParameter("dob");
		Mockito.doReturn("0").when(request).getParameter("account_type");
		Mockito.doReturn("5610591081018250").when(request).getParameter("cc_num"); //australianbank
		Mockito.doReturn("2019-05").when(request).getParameter("cc_exp");
		Mockito.doReturn("123").when(request).getParameter("cvv");
		
		regservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/AddUserFailed.html");
	}
	
}
