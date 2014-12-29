package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DBConnection;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class BetServlet
 */
@WebServlet("/BetServlet")
public class BetServlet extends HttpServlet {
	long CurrentBetID;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Placing bet...");
		PrintWriter writer = response.getWriter();
		try {
			DBConnection account_details = new DBConnection(
					"SELECT account, Bets FROM players WHERE Username = \""
							+ UsernameValidation(request
									.getParameter("username")) + "\";");

			DBConnection total_bets = new DBConnection(
					"SELECT sum(amount) FROM bets WHERE Username = \""
							+ UsernameValidation(request
									.getParameter("username")) + "\";");

			if (Integer.parseInt(account_details.getResults().get(0).get(0)) == 0
					&& Integer.parseInt(account_details.getResults().get(0)
							.get(1)) >= 3) {

				// free users cannot make more than 3 bets
				// New location to be redirected
				String site = new String("ErrorPages/MoreThan3Bets.html");

				response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", site);
				// writer.println("You are not allowed to make more than 3 bets! \n Please register as a premium user");
				System.out.println("Free user trying to make more than 3 bets");
			} else {
				new DBConnection(
						"INSERT INTO bets (USERNAME, BetID, RiskLevel, Amount) VALUES (\""
								+ UsernameValidation(request
										.getParameter("username"))
								+ "\", \""
								+ GenerateBetID()
								+ "\", \""
								+ ValidateRiskLevel(Integer
										.parseInt(account_details.getResults()
												.get(0).get(0)), Integer
										.parseInt(request
												.getParameter("risk_lvl")))
								+ "\", \""
								+ ValidateBetAmount(Integer
										.parseInt(account_details.getResults()
												.get(0).get(0)), Integer
										.parseInt(request
												.getParameter("bet_amt")),
										getTotalBetAmount(total_bets
												.getResults().get(0))) + "\");");

				writer.println("Bet Placed Successfully");

				new DBConnection(
						"UPDATE players SET Bets = Bets+1 WHERE username = \""
								+ request.getParameter("username") + "\";");

				writer.println(request.getParameter("username"));
				writer.println(request.getParameter("risk_lvl"));
				writer.println(request.getParameter("bet_amt"));
			}

		} catch (MySQLIntegrityConstraintViolationException primarykey_violation) {
			BetServlet.this.CurrentBetID--;
			System.out.println("There exists a bet with the same bet ID!");
		} catch (SQLException se) {
			BetServlet.this.CurrentBetID--;

			// New location to be redirected
			String site = new String("ErrorPages/InvalidBetParam.html");

			response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);

			System.out.println("Invalid Bet Parameters");
			se.printStackTrace();
		}
	}

	public void destroy() {
		try {
			new DBConnection("DELETE FROM bets;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public String UsernameValidation(String username) throws SQLException {
		Pattern p = Pattern.compile("^[A-Za-z0-9]+$");
		Matcher m = p.matcher(username);
		boolean b = m.find();
		if (b == true && username.length() >= 6) {
			return username;
		} else {
			throw new SQLException();
		}
	}

	public int ValidateRiskLevel(int account_type, int risk_level)
			throws SQLException {
		if (((account_type == 0) && (risk_level == 0))
				|| ((account_type == 1) && (risk_level >= 0) && (risk_level < 3))) {
			return risk_level;
		} else
			throw new SQLException();
	}

	public int ValidateBetAmount(int account_type, int bet_amount,
			int total_bets) throws SQLException {
		if (bet_amount > 0
				&& total_bets >= 0
				&& (((account_type == 0) && (bet_amount <= 5) && (total_bets
						+ bet_amount <= 15)) || ((account_type == 1) && ((total_bets + bet_amount) <= 5000)))) {
			return bet_amount;
		} else
			throw new SQLException();
	}

	public long GenerateBetID() {
		try {
			BetServlet.this.CurrentBetID++;
		} catch (Exception e) {
			BetServlet.this.CurrentBetID = 1;
		}

		return CurrentBetID;
	}

	public int getTotalBetAmount(ArrayList<String> arraylist) {
		if (arraylist.get(0) == null) {
			return 0;
		} else
			return Integer.parseInt(arraylist.get(0));
	}
}
