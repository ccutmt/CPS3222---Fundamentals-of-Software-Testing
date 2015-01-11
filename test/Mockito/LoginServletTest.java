package Mockito;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;

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
	
	@Mock
	ArrayList<String> record2;
	
	@Mock
	ArrayList<ArrayList<String>> results2;
	
	@Mock
	Calendar cal;
	
	@Mock
	Date date;
	
	private InduceTimeout timeout = new InduceTimeout();
	
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
		
		/*logservlet.users = Mockito.mock(ArrayList.class);
		logservlet.check_logins = Mockito.mock(ArrayList.class);*/
		
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
	public void UserNotFoundTest() throws ServletException, IOException, SQLException {
		
		doReturn("someUsername").when(request).getParameter("username");
		
		Mockito.when(results.size()).thenReturn(0);
		
		logservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/UserNotFound.html");
	}

	@Test
	public void UserLoginTest() throws ServletException, IOException, SQLException {	
		
		doReturn("someString").when(record).get(0);
		doReturn("testing123").when(record).get(1);

		doReturn(record).when(results).get(0);
		
		Mockito.doReturn("someString").when(request).getParameter("username");
		Mockito.doReturn("testing123").when(request).getParameter("password");
		
		Mockito.when(results.size()).thenReturn(1);
		Mockito.when(logservlet.login_player.ExecuteQuery(anyString())).thenReturn(results);
		Mockito.when(logservlet.login_player.ExecuteQuery("SELECT last_login, attempts_amount FROM attempted_logins WHERE Username = \""
				+ "someString"	+ "\";")).thenReturn(results2);
		//Mockito.when(results2.size()).thenReturn(0);
		
		logservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location", "BetPage.jsp");
	}

	@Test
	 public void UserFailedLoginTest() throws ServletException, IOException, Exception {
	  
	  doReturn("someString").when(record).get(0);
	  doReturn("testing1").when(record).get(1);

	  doReturn(record).when(results).get(0);
	  
	  Mockito.doReturn("someString").when(request).getParameter("username");
	  Mockito.doReturn("testing123").when(request).getParameter("password");
	  
	  Mockito.when(results.size()).thenReturn(1);
	  Mockito.when(logservlet.login_player.ExecuteQuery(anyString())).thenReturn(results);
	  Mockito.when(logservlet.login_player.ExecuteQuery("SELECT last_login, attempts_amount FROM attempted_logins WHERE Username = \""
	    + "someString" + "\";")).thenReturn(results2);
	  //Mockito.when(results2.size()).thenReturn(0);
	  
	  logservlet.doGet(request, response); 
	  
	  Mockito.verify(response).setHeader("Location", "Pages/LoginFailed.html");
	 }
	
	@Test
	public void UserFailedLoginTimeoutTest() throws ServletException, IOException, SQLException {

		doReturn("someString").when(record).get(0);
		doReturn("testing123").when(record).get(1);

		doReturn(record).when(results).get(0);
		
		Mockito.doReturn("someString").when(request).getParameter("username");
		Mockito.doReturn("testing123").when(request).getParameter("password");
		
		doReturn(timeout.turnBackTime()).when(record2).get(0);
		doReturn("3").when(record2).get(1);
		
		doReturn(record2).when(results2).get(0);
		
		Mockito.when(results.size()).thenReturn(1);
		Mockito.when(logservlet.login_player.ExecuteQuery("SELECT Username, Password FROM PLAYERS WHERE Username = \"someString\";")).thenReturn(results);
		Mockito.when(logservlet.login_player.ExecuteQuery("SELECT last_login, attempts_amount FROM attempted_logins WHERE Username = \"someString\";")).thenReturn(results2);
		//Mockito.when(results2.size()).thenReturn(0);
		Mockito.when(results2.size()).thenReturn(1);
		
		logservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location", "Pages/LoginTimeout.html");
	}

	@Test
	public void UserLoginAfterTimeoutTest() throws ServletException, IOException, SQLException {
		doReturn("someString").when(record).get(0);
		doReturn("testing123").when(record).get(1);

		doReturn(record).when(results).get(0);
		
		Mockito.doReturn("someString").when(request).getParameter("username");
		Mockito.doReturn("testing123").when(request).getParameter("password");
		
		doReturn("2015-01-11 18:30:11").when(record2).get(0);
		doReturn("3").when(record2).get(1);
		
		doReturn(record2).when(results2).get(0);
		
		Mockito.when(results.size()).thenReturn(1);
		Mockito.when(logservlet.login_player.ExecuteQuery("SELECT Username, Password FROM PLAYERS WHERE Username = \"someString\";")).thenReturn(results);
		Mockito.when(logservlet.login_player.ExecuteQuery("SELECT last_login, attempts_amount FROM attempted_logins WHERE Username = \"someString\";")).thenReturn(results2);
		//Mockito.when(results2.size()).thenReturn(0);
		Mockito.when(results2.size()).thenReturn(1);
		
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
