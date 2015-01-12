package Mockito;

import java.io.IOException;
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
		
		Mockito.doReturn(session).when(request).getSession();
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
	}

	@Test
	public void UserAlreadyExistsTest() throws ServletException, IOException, SQLException {
		Mockito.doReturn("someString").when(request).getParameter(anyString());
		Mockito.doReturn("378282246310005").when(request).getParameter("cc_num");
		Mockito.doReturn("0").when(request).getParameter("account_type");
		Mockito.doReturn("1994-12-18").when(request).getParameter("dob");
		Mockito.doReturn("2019-05").when(request).getParameter("cc_exp");
		Mockito.doReturn("123").when(request).getParameter("cvv");
		Mockito.doThrow(new MySQLIntegrityConstraintViolationException()).when(DB).ExecuteQuery(anyString());		
		regservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location",
				"Pages/ErrorAlreadyExists.html");
	}

	@Test
	public void UserNotAddedTest() throws ServletException, IOException , SQLException{
		Mockito.doReturn("someString").when(request).getParameter(anyString());
		Mockito.doReturn("378282246310005").when(request).getParameter("cc_num");
		Mockito.doReturn("0").when(request).getParameter("account_type");
		Mockito.doReturn("1994-12-18").when(request).getParameter("dob");
		Mockito.doReturn("2019-05").when(request).getParameter("cc_exp");
		Mockito.doReturn("123").when(request).getParameter("cvv");
		Mockito.doThrow(new SQLException()).when(DB).ExecuteQuery(anyString());
		
		regservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location",
				"Pages/AddUserFailed.html");
	}
}
