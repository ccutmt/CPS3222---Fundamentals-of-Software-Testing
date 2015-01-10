package Mokito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import Database.DBConnection;
import Servlets.RegServlet;

public class RegisterServletTest {
	private RegServlet regservlet;

	@Mock
	private HttpServletRequest request;
	
	@Mock
	private HttpServletResponse response;
	
	@Mock
	private HttpSession session;
	
	@Mock
	private DBConnection DB;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		regservlet = new RegServlet();
		
		regservlet.insert_player = Mockito.mock(DBConnection.class);
		DB = regservlet.insert_player;
		
		/*request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		writer = Mockito.mock(PrintWriter.class);
		session = Mockito.mock(HttpSession.class);
		DB = Mockito.mock(DBConnection.class);*/
		
		Mockito.doReturn(session).when(request).getSession();

		/*try {

			DB.ExecuteQuery("INSERT INTO PLAYERS ( Username, Password, Name, Surname, DOB, Account, CCNum, CCExpDate, CVV, Bets )"
					+ "VALUES ( \"useralreadyexiststest\", \"testing123\",\"Christopher\",\"Cutajar\",\"1994-12-18\",\"0\",\"378282246310005\",\"2019-05-31\",\"123\",\"0\");");
		} catch (SQLException se) {
			se.printStackTrace();
		}*/
	}

	@Test
	public void CreateUserSuccessfulTest() throws ServletException, IOException {
		
		Mockito.doReturn("chris1994").when(request).getParameter("username");
		Mockito.doReturn("testing123").when(request).getParameter("password");
		Mockito.doReturn("Christopher").when(request).getParameter("name");
		Mockito.doReturn("Cutajar").when(request).getParameter("surname");
		Mockito.doReturn("1994-12-18").when(request).getParameter("dob");
		Mockito.doReturn("0").when(request).getParameter("account_type");
		Mockito.doReturn("378282246310005").when(request)
				.getParameter("cc_num");
		Mockito.doReturn("2019-05").when(request).getParameter("cc_exp");
		Mockito.doReturn("123").when(request).getParameter("cvv");
		
		regservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location",
				"Pages/RegistrationSuccess.html");
		
		/*try {
			DBConnection delete_player = new DBConnection();
			delete_player.ExecuteQuery("DELETE from Players where username=\"chris1994\";");
		} catch (SQLException se) {
			se.printStackTrace();
		}*/
	}

	@Test//(expected = Exception.class)
	public void UserAlreadyExistsTest() throws ServletException, IOException, SQLException {
		//Mockito.when(request.getParameter(anyString())).thenThrow(new MySQLIntegrityConstraintViolationException());
		
		
		//Mockito.when((DB.ExecuteQuery(anyString()))).thenThrow(new MySQLIntegrityConstraintViolationException());
		Mockito.doReturn("someString").when(request).getParameter(anyString());
		Mockito.doReturn("378282246310005").when(request).getParameter("cc_num");
		Mockito.doThrow(new MySQLIntegrityConstraintViolationException()).when(DB).ExecuteQuery(anyString());
		/*Mockito.doReturn("testing123").when(request).getParameter("password");
		Mockito.doReturn("Christopher").when(request).getParameter("name");
		Mockito.doReturn("Cutajar").when(request).getParameter("surname");
		Mockito.doReturn("1994-12-18").when(request).getParameter("dob");
		Mockito.doReturn("0").when(request).getParameter("account_type");
		Mockito.doReturn("378282246310005").when(request)
				.getParameter("cc_num");
		Mockito.doReturn("2019-05").when(request).getParameter("cc_exp");
		Mockito.doReturn("123").when(request).getParameter("cvv");*/
		
		regservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location",
				"Pages/ErrorAlreadyExists.html");
	}

	@Test(expected = Exception.class)
	public void UserNotAddedTest() throws ServletException, IOException {
		Mockito.when(request).thenThrow(new SQLException());
		/*Mockito.doReturn("few").when(request).getParameter("username"); // short username
		Mockito.doReturn("testing123").when(request).getParameter("password");
		Mockito.doReturn("Christopher").when(request).getParameter("name");
		Mockito.doReturn("Cutajar").when(request).getParameter("surname");
		Mockito.doReturn("1994-12-18").when(request).getParameter("dob");
		Mockito.doReturn("0").when(request).getParameter("account_type");
		Mockito.doReturn("5610591081018250").when(request)
				.getParameter("cc_num"); // australianbank
		Mockito.doReturn("2019-05").when(request).getParameter("cc_exp");
		Mockito.doReturn("123").when(request).getParameter("cvv");*/

		regservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location",
				"Pages/AddUserFailed.html");
	}

	@After
	public void teardown() throws Exception {
		/*try {
			System.out.println("delete");
			DB.ExecuteQuery("DELETE from Players where username=\"chris1994\";");
			System.out.println("delete done");
			//DB.ExecuteQuery("DELETE from Players where username=\"useralreadyexiststest\";");
		} catch (SQLException se) {
			System.out.println("catch");
			se.printStackTrace();
		}*/
	}
}
