package Mockito;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

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
import Servlets.BetServlet;

public class BetServletTest {
	BetServlet betservlet;

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	private HttpSession session;

	@Mock
	private DBConnection DB;

	@Mock
	private ArrayList<ArrayList<String>> results;

	@Mock
	private ArrayList<String> record;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		betservlet = new BetServlet();

		/*
		 * request = Mockito.mock(HttpServletRequest.class); response =
		 * Mockito.mock(HttpServletResponse.class); writer =
		 * Mockito.mock(PrintWriter.class); session =
		 * Mockito.mock(HttpSession.class); DB =
		 * Mockito.mock(DBConnection.class);
		 */

		betservlet.place_bet = Mockito.mock(DBConnection.class);
		DB = betservlet.place_bet;

		betservlet.account_details = Mockito.mock(ArrayList.class);

		Mockito.doReturn(session).when(request).getSession();

		/*
		 * try{ DB.ExecuteQuery(
		 * "INSERT INTO PLAYERS ( Username, Password, Name, Surname, DOB, Account, CCNum, CCExpDate, CVV, Bets )"
		 * +
		 * "VALUES ( \"bettest\", \"testing123\",\"Christopher\",\"Cutajar\",\"1994-12-18\",\"0\",\"378282246310005\",\"2019-05-31\",\"123\",\"0\");"
		 * ); DB.ExecuteQuery("DELETE from Bets where BetID=\"1\";");
		 * }catch(SQLException se){ se.printStackTrace(); }
		 */
	}

	@Test
	public void MoreThan3BetsTest() throws ServletException, IOException,
			SQLException {

		Mockito.doReturn("0").when(record).get(0);
		Mockito.doReturn("3").when(record).get(1);

		Mockito.doReturn(record).when(betservlet.account_details).get(0);

		Mockito.doReturn("someString").when(request).getParameter("username");
		Mockito.doReturn(betservlet.account_details).when(DB)
				.ExecuteQuery(anyString());

		betservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location",
				"Pages/MoreThan3Bets.html");
	}

	@Test
	public void FreeSuccessfulBetTest() throws ServletException, IOException,
			SQLException {

		Mockito.doReturn("0").when(record).get(0);
		Mockito.doReturn("0").when(record).get(1);

		Mockito.doReturn(record).when(betservlet.account_details).get(0);

		Mockito.doReturn("someString").when(request).getParameter("username");
		Mockito.doReturn("0").when(request).getParameter("risk_lvl");
		Mockito.doReturn("5").when(request).getParameter("bet_amt");

		Mockito.doReturn(betservlet.account_details).when(DB)
				.ExecuteQuery(anyString());

		betservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location", "Pages/BetSuccess.html");
	}

	@Test
	public void PremiumHighSuccessfulBetTest() throws ServletException,
			IOException, SQLException {

		Mockito.doReturn("1").when(record).get(0);
		Mockito.doReturn("0").when(record).get(1);

		Mockito.doReturn(record).when(betservlet.account_details).get(0);

		Mockito.doReturn("someString").when(request).getParameter("username");
		Mockito.doReturn("2").when(request).getParameter("risk_lvl");
		Mockito.doReturn("10").when(request).getParameter("bet_amt");

		Mockito.doReturn(betservlet.account_details).when(DB)
				.ExecuteQuery(anyString());

		betservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location", "Pages/BetSuccess.html");
	}

	@Test
	public void PremiumMediumSuccessfulBetTest() throws ServletException,
			IOException, SQLException {

		Mockito.doReturn("1").when(record).get(0);
		Mockito.doReturn("0").when(record).get(1);

		Mockito.doReturn(record).when(betservlet.account_details).get(0);

		Mockito.doReturn("someString").when(request).getParameter("username");
		Mockito.doReturn("1").when(request).getParameter("risk_lvl");
		Mockito.doReturn("10").when(request).getParameter("bet_amt");

		Mockito.doReturn(betservlet.account_details).when(DB)
				.ExecuteQuery(anyString());

		betservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location", "Pages/BetSuccess.html");
	}

	@Test
	public void PremiumLowSuccessfulBetTest() throws ServletException,
			IOException, SQLException {

		Mockito.doReturn("1").when(record).get(0);
		Mockito.doReturn("0").when(record).get(1);

		Mockito.doReturn(record).when(betservlet.account_details).get(0);

		Mockito.doReturn("someString").when(request).getParameter("username");
		Mockito.doReturn("0").when(request).getParameter("risk_lvl");
		Mockito.doReturn("10").when(request).getParameter("bet_amt");

		Mockito.doReturn(betservlet.account_details).when(DB)
				.ExecuteQuery(anyString());

		betservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location", "Pages/BetSuccess.html");
	}

	@Test
	public void FreeMediumUnSuccessfulBetTest() throws ServletException,
			IOException, SQLException, UnsupportedOperationException {

		Mockito.doReturn("0").when(record).get(0);
		Mockito.doReturn("0").when(record).get(1);

		Mockito.doReturn(record).when(betservlet.account_details).get(0);

		Mockito.doReturn("someString").when(request).getParameter("username");
		Mockito.doReturn("1").when(request).getParameter("risk_lvl");
		Mockito.doReturn("5").when(request).getParameter("bet_amt");

		Mockito.doReturn(betservlet.account_details).when(DB)
				.ExecuteQuery(anyString());
		
		//Mockito.doThrow(new UnsupportedOperationException()).when(DB)
		//.ExecuteQuery(anyString());

		betservlet.doGet(request, response);

		Mockito.verify(response)
				.setHeader("Location", "Pages/InvalidRisk.html");
	}

	@Test
	public void FreeHighUnSuccessfulBetTest() throws ServletException,
			IOException, SQLException, UnsupportedOperationException {
		
		Mockito.doReturn("0").when(record).get(0);
		Mockito.doReturn("0").when(record).get(1);

		Mockito.doReturn(record).when(betservlet.account_details).get(0);

		Mockito.doReturn("someString").when(request).getParameter("username");
		Mockito.doReturn("2").when(request).getParameter("risk_lvl");
		Mockito.doReturn("5").when(request).getParameter("bet_amt");
		
		Mockito.doReturn(betservlet.account_details).when(DB)
		.ExecuteQuery(anyString());

		//Mockito.doThrow(new UnsupportedOperationException()).when(DB)
			//	.ExecuteQuery(anyString());

		betservlet.doGet(request, response);

		Mockito.verify(response)
				.setHeader("Location", "Pages/InvalidRisk.html");
	}

	@Test//(expected = SQLException.class)
	public void FreeUnSuccessfulBetOver5Test() throws ServletException,
			IOException, SQLException {
		
		Mockito.doReturn("0").when(record).get(0);
		Mockito.doReturn("0").when(record).get(1);

		Mockito.doReturn(record).when(betservlet.account_details).get(0);

		Mockito.doReturn("someString").when(request).getParameter("username");
		Mockito.doReturn("0").when(request).getParameter("risk_lvl");
		Mockito.doReturn("10").when(request).getParameter("bet_amt");
		
		Mockito.doReturn(betservlet.account_details).when(DB)
		.ExecuteQuery(anyString());

		//Mockito.doThrow(new SQLException()).when(DB).ExecuteQuery(anyString());

		betservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location",
				"Pages/InvalidBetAmount.html");
	}

	@Test
	public void PremiumSuccessfulBetOver5Test() throws ServletException,
			IOException, SQLException {
		
		Mockito.doReturn("1").when(record).get(0);
		Mockito.doReturn("0").when(record).get(1);

		Mockito.doReturn(record).when(betservlet.account_details).get(0);

		Mockito.doReturn("someString").when(request).getParameter("username");
		Mockito.doReturn("2").when(request).getParameter("risk_lvl");
		Mockito.doReturn("200").when(request).getParameter("bet_amt");
		
		Mockito.doReturn(betservlet.account_details).when(DB)
		.ExecuteQuery(anyString());


		betservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location", "Pages/BetSuccess.html");
	}

	@Test
	public void PremiumUnSuccessfulBetOver5000Test() throws ServletException,
			IOException, Exception {
		
		Mockito.doReturn("1").when(record).get(0);
		Mockito.doReturn("0").when(record).get(1);

		Mockito.doReturn(record).when(betservlet.account_details).get(0);

		Mockito.doReturn("someString").when(request).getParameter("username");
		Mockito.doReturn("2").when(request).getParameter("risk_lvl");
		Mockito.doReturn("5001").when(request).getParameter("bet_amt");

		Mockito.doReturn(betservlet.account_details).when(DB)
		.ExecuteQuery(anyString());

		betservlet.doGet(request, response);

		Mockito.verify(response).setHeader("Location",
				"Pages/MaxCumulativeBets.html");
	}

	@After
	public void tearDown() throws Exception {

	}

}
