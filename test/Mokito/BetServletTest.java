package Mokito;

import static org.junit.Assert.*;

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
import org.mockito.Mockito;

import Database.DBConnection;
import Servlets.BetServlet;

public class BetServletTest {
	BetServlet betservlet;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private PrintWriter writer;
	private HttpSession session;
	private DBConnection DB;

	@Before
	public void setUp() throws Exception {
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		writer = Mockito.mock(PrintWriter.class);
		session = Mockito.mock(HttpSession.class);
		DB = Mockito.mock(DBConnection.class);
		Mockito.doReturn(session).when(request).getSession();
		
		betservlet = new BetServlet();

		try{
			new DBConnection("INSERT INTO PLAYERS ( Username, Password, Name, Surname, DOB, Account, CCNum, CCExpDate, CVV, Bets )"
					+ "VALUES ( \"bettest\", \"testing123\",\"Christopher\",\"Cutajar\",\"1994-12-18\",\"0\",\"378282246310005\",\"2019-05-31\",\"123\",\"0\");");
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	@Test
	public void MoreThan3BetsTest() throws ServletException, IOException {
		try {
			new DBConnection("UPDATE players SET Bets = 3 WHERE username=\"bettest\";");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		Mockito.doReturn("bettest").when(request).getParameter("username");
		
		betservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/MoreThan3Bets.html");
	}
	
	@Test
	public void FreeSuccessfulBetTest() throws ServletException, IOException {		
		Mockito.doReturn("bettest").when(request).getParameter("username");
		Mockito.doReturn("0").when(request).getParameter("risk_lvl");
		Mockito.doReturn("5").when(request).getParameter("bet_amt");
		
		betservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/BetSuccess.html");
	}
	
	@Test
	public void PremiumHighSuccessfulBetTest() throws ServletException, IOException {	
		try {
			new DBConnection("UPDATE players SET Account = \"1\" WHERE username=\"bettest\";");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		Mockito.doReturn("bettest").when(request).getParameter("username");
		Mockito.doReturn("2").when(request).getParameter("risk_lvl");
		Mockito.doReturn("10").when(request).getParameter("bet_amt");
		
		betservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/BetSuccess.html");
	}
	
	@Test
	public void PremiumMediumSuccessfulBetTest() throws ServletException, IOException {	
		try {
			new DBConnection("UPDATE players SET Account = \"1\" WHERE username=\"bettest\";");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		Mockito.doReturn("bettest").when(request).getParameter("username");
		Mockito.doReturn("1").when(request).getParameter("risk_lvl");
		Mockito.doReturn("10").when(request).getParameter("bet_amt");
		
		betservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/BetSuccess.html");
	}
	
	@Test
	public void PremiumLowSuccessfulBetTest() throws ServletException, IOException {	
		try {
			new DBConnection("UPDATE players SET Account = \"1\" WHERE username=\"bettest\";");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		Mockito.doReturn("bettest").when(request).getParameter("username");
		Mockito.doReturn("0").when(request).getParameter("risk_lvl");
		Mockito.doReturn("10").when(request).getParameter("bet_amt");
		
		betservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/BetSuccess.html");
	}
	
	@Test
	public void FreeMediumUnSuccessfulBetTest() throws ServletException, IOException {
		Mockito.doReturn("bettest").when(request).getParameter("username");
		Mockito.doReturn("1").when(request).getParameter("risk_lvl");
		Mockito.doReturn("5").when(request).getParameter("bet_amt");
		
		betservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/InvalidRisk.html");
	}
	
	@Test
	public void FreeHighUnSuccessfulBetTest() throws ServletException, IOException {
		Mockito.doReturn("bettest").when(request).getParameter("username");
		Mockito.doReturn("2").when(request).getParameter("risk_lvl");
		Mockito.doReturn("5").when(request).getParameter("bet_amt");
		
		betservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/InvalidRisk.html");
	}
	
	@Test
	public void FreeUnSuccessfulBetOver5Test() throws ServletException, IOException {
		Mockito.doReturn("bettest").when(request).getParameter("username");
		Mockito.doReturn("0").when(request).getParameter("risk_lvl");
		Mockito.doReturn("10").when(request).getParameter("bet_amt");
		
		betservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/MaxCumulativeBets.html");
	}
	
	@Test
	public void PremiumSuccessfulBetOver5Test() throws ServletException, IOException {	
		try {
			new DBConnection("UPDATE players SET Account = \"1\" WHERE username=\"bettest\";");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		Mockito.doReturn("bettest").when(request).getParameter("username");
		Mockito.doReturn("2").when(request).getParameter("risk_lvl");
		Mockito.doReturn("200").when(request).getParameter("bet_amt");
		
		betservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/BetSuccess.html");
	}
	
	@Test
	public void PremiumUnSuccessfulBetOver5000Test() throws ServletException, IOException {	
		try {
			new DBConnection("UPDATE players SET Account = \"1\" WHERE username=\"bettest\";");
			//new DBConnection("INSERT INTO Bets (Username, BetI SET Account = \"1\" WHERE username=\"bettest\";");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		Mockito.doReturn("bettest").when(request).getParameter("username");
		Mockito.doReturn("2").when(request).getParameter("risk_lvl");
		Mockito.doReturn("50000").when(request).getParameter("bet_amt");
		
		betservlet.doGet(request, response);
		
		Mockito.verify(response).setHeader("Location", "Pages/MaxCumulativeBets.html");
	}
	@After
	public void tearDown() throws Exception {
		try {
			new DBConnection("DELETE from Bets where username=\"bettest\";");
			new DBConnection("DELETE from Players where username=\"bettest\";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}