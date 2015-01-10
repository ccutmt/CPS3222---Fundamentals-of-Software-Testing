package Mokito;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import Database.DBConnection;
import Servlets.LoginServlet;

public class LoginServletTest {
	private LoginServlet logservlet;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private PrintWriter writer;
	private HttpSession session;
	private DBConnection DB;

	@Before
	public void setUp() throws Exception {		
		MockitoAnnotations.initMocks(this);
		logservlet = new LoginServlet();
		
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		writer = Mockito.mock(PrintWriter.class);
		session = Mockito.mock(HttpSession.class);
		DB = Mockito.mock(DBConnection.class);
		
		logservlet.login_player = Mockito.mock(DBConnection.class);
		DB = logservlet.login_player;
		
		Mockito.doReturn(session).when(request).getSession();
		
		/*String query = "INSERT INTO PLAYERS ( Username, Password, Name, Surname, DOB, Account, CCNum, CCExpDate, CVV, Bets )"
				+ "VALUES ( \"logintest\", \"testing123\",\"Christopher\",\"Cutajar\",\"1994-12-18\",\"0\",\"378282246310005\",\"2019-05-31\",\"123\",\"0\");";
		DB.ExecuteQuery(DB, query);*/
		
		try{
			DB.ExecuteQuery("INSERT INTO PLAYERS ( Username, Password, Name, Surname, DOB, Account, CCNum, CCExpDate, CVV, Bets )"
					+ "VALUES ( \"logintest\", \"testing123\",\"Christopher\",\"Cutajar\",\"1994-12-18\",\"0\",\"378282246310005\",\"2019-05-31\",\"123\",\"0\");");
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	@Test
	public void UserNotFoundTest() throws ServletException, IOException {
		
		Mockito.doReturn("usernotindb").when(request).getParameter("username");
		Mockito.doReturn("testing123").when(request).getParameter("password");
		
		logservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/UserNotFound.html");
	}
	
	@Test
	public void UserLoginTest() throws ServletException, IOException {
		Mockito.doReturn("logintest").when(request).getParameter("username");
		Mockito.doReturn("testing123").when(request).getParameter("password");
		
		logservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "BetPage.jsp");
	}
	
	@Test(expected = Exception.class)
	public void UserFailedLoginTest() throws ServletException, IOException {
		/*Mockito.doReturn("logintest").when(request).getParameter("username");
		Mockito.doReturn("testing1234564").when(request).getParameter("password");*/
		Mockito.when(request).thenThrow(new Exception());
		
		logservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/LoginFailed.html");
	}
	
	@Test
	public void UserFailedLoginTimeoutTest() throws ServletException, IOException, SQLException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar test_cal = Calendar.getInstance();
		test_cal.add(Calendar.MINUTE, -2);
		System.out.println(dateFormat.format(test_cal.getTime()));

		try {
			DB.ExecuteQuery("INSERT INTO attempted_logins (username, last_login, attempts_amount) VALUES (\"logintest\",\""+ dateFormat.format(test_cal.getTime())+ "\",\"3\");");
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}

		Mockito.doReturn("logintest").when(request).getParameter("username");
		Mockito.doReturn("testing123").when(request).getParameter("password");
		logservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location", "Pages/LoginTimeout.html");
	}
	
	@Test
	public void UserLoginFailedAfterTimeoutTest() throws ServletException, IOException, SQLException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -8);
		System.out.println(dateFormat.format(cal.getTime()));
		
		try {
			DB.ExecuteQuery("INSERT INTO attempted_logins (username, last_login, attempts_amount) VALUES (\"logintest\",\""+ dateFormat.format(cal.getTime())+ "\",\"3\");");
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		
		Mockito.doReturn("logintest").when(request).getParameter("username");
		Mockito.doReturn("testing123898").when(request).getParameter("password");
		logservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/LoginFailed.html");
	}

	@Test
	public void UserLoginAfterTimeoutTest() throws ServletException, IOException, SQLException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -8);
		
		try {
			DB.ExecuteQuery("INSERT INTO attempted_logins (username, last_login, attempts_amount) VALUES (\"logintest\",\""+ dateFormat.format(cal.getTime())+ "\",\"3\");");
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		
		Mockito.doReturn("logintest").when(request).getParameter("username");
		Mockito.doReturn("testing123").when(request).getParameter("password");
		
		logservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "BetPage.jsp");
	}
	
	@After
	public void tearDown() throws Exception {
		try{
			DB.ExecuteQuery("DELETE from attempted_logins where  username=\"logintest\";");
			DB.ExecuteQuery("DELETE from Players where username=\"logintest\";");
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
}
