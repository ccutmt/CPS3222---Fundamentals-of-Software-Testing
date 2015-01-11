package Mockito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import Database.DBConnection;
import Servlets.LoginServlet;

public class LoginServletTest {
	private LoginServlet logservlet;
	
	@Mock
	private HttpServletRequest request;
	
	@Mock
	private HttpServletResponse response;
	
	@Mock
	private PrintWriter writer;
	
	@Mock
	private HttpSession session;
	
	@Mock
	private DBConnection DB;
	
	@Mock
	ArrayList<String> record;
	
	@Mock
	ArrayList<ArrayList<String>> results;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {		
		MockitoAnnotations.initMocks(this);
		logservlet = new LoginServlet();
		
		/*request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		writer = Mockito.mock(PrintWriter.class);
		session = Mockito.mock(HttpSession.class);
		DB = Mockito.mock(DBConnection.class);*/
		
		logservlet.login_player = Mockito.mock(DBConnection.class);
		DB = logservlet.login_player;
		
		logservlet.users = Mockito.mock(ArrayList.class);
		logservlet.check_logins = Mockito.mock(ArrayList.class);
		
		Mockito.doReturn(session).when(request).getSession();
		
		/*String query = "INSERT INTO PLAYERS ( Username, Password, Name, Surname, DOB, Account, CCNum, CCExpDate, CVV, Bets )"
				+ "VALUES ( \"logintest\", \"testing123\",\"Christopher\",\"Cutajar\",\"1994-12-18\",\"0\",\"378282246310005\",\"2019-05-31\",\"123\",\"0\");";
		DB.ExecuteQuery(DB, query);*/
		
		/*try{
			DB.ExecuteQuery("INSERT INTO PLAYERS ( Username, Password, Name, Surname, DOB, Account, CCNum, CCExpDate, CVV, Bets )"
					+ "VALUES ( \"logintest\", \"testing123\",\"Christopher\",\"Cutajar\",\"1994-12-18\",\"0\",\"378282246310005\",\"2019-05-31\",\"123\",\"0\");");
		}catch(SQLException se){
			se.printStackTrace();
		}*/
	}
	
	@Test
	public void UserNotFoundTest() throws ServletException, IOException {
		
		Mockito.doReturn("usernotindb").when(request).getParameter("username");
		Mockito.doReturn("testing123").when(request).getParameter("password");
		
		logservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/UserNotFound.html");
	}

	@Test
	public void UserLoginTest() throws ServletException, IOException, SQLException {	

		Mockito.doReturn("someString").when(record).get(0);
		Mockito.doReturn("someString123").when(record).get(1);

		Mockito.doReturn(record).when(logservlet.users).get(0);		
		Mockito.doReturn(1).when(logservlet.users).size();
		Mockito.doReturn(logservlet.users).when(DB).ExecuteQuery(anyString());
		
		//System.out.println(logservlet.users.size());
		
		Mockito.doReturn("").when(record).get(0);
		Mockito.doReturn("").when(record).get(1);

		Mockito.doReturn(record).when(logservlet.check_logins).get(0);
		Mockito.doReturn(logservlet.check_logins).when(DB).ExecuteQuery(anyString());
		
		Mockito.doReturn("someString").when(request).getParameter("username");
		Mockito.doReturn("someString123").when(request).getParameter("password");
		
		logservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location", "BetPage.jsp");
	}

	@Test
	public void UserFailedLoginTest() throws ServletException, IOException, Exception {
		
		Mockito.doReturn("").when(request).getParameter("username");
		Mockito.doReturn("").when(request).getParameter("password");
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
		/*try{
			DB.ExecuteQuery("DELETE from attempted_logins where  username=\"logintest\";");
			DB.ExecuteQuery("DELETE from Players where username=\"logintest\";");
		}catch(SQLException se){
			se.printStackTrace();
		}*/
	}
}
