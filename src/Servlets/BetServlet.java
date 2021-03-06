package Servlets;

import java.io.IOException;
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
	long CurrentBetID = 0;

	private static final long serialVersionUID = 1L;

	public DBConnection place_bet = DBConnection.getInstance();

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
	// @SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Placing bet...");
		try {
			if (Integer.parseInt(place_bet
					.ExecuteQuery(
							"SELECT account, Bets FROM players WHERE Username = \""
									+ UsernameValidation(request
											.getParameter("username")) + "\";")
					.get(0).get(0)) == 0
					&& Integer.parseInt(place_bet
							.ExecuteQuery(
									"SELECT account, Bets FROM players WHERE Username = \""
											+ UsernameValidation(request
													.getParameter("username"))
											+ "\";").get(0).get(1)) >= 3) {

				// free users cannot make more than 3 bets
				// New location to be redirected
				String site = new String("Pages/MoreThan3Bets.html");

				response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", site);
				System.out.println("Free user trying to make more than 3 bets");
			} else {
				try {
					int account_type = Integer.parseInt(place_bet.ExecuteQuery(
									"SELECT account FROM players WHERE Username = \""
											+ UsernameValidation(request
													.getParameter("username"))
											+ "\";")
							.get(0).get(0));
					place_bet
							.ExecuteQuery("INSERT INTO bets (USERNAME, BetID, RiskLevel, Amount) VALUES (\""
									+ UsernameValidation(request
											.getParameter("username"))
									+ "\", \""
									+ GenerateBetID()
									+ "\", \""
									+ ValidateRiskLevel(account_type,
											Integer.parseInt(request
													.getParameter("risk_lvl")))
									+ "\", \""
									+ ValidateBetAmount(
											account_type,
											Integer.parseInt(request
													.getParameter("bet_amt")),
											getTotalBetAmount(place_bet
													.ExecuteQuery(
															"SELECT sum(amount) FROM bets WHERE Username = \""
																	+ UsernameValidation(request
																			.getParameter("username"))
																	+ "\";")
													.get(0))) + "\");");

					place_bet
							.ExecuteQuery("UPDATE players SET Bets = Bets+1 WHERE username = \""
									+ request.getParameter("username") + "\";");

					// New location to be redirected
					String site = new String("Pages/BetSuccess.html");

					response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
					response.setHeader("Location", site);
				} catch (UnsupportedOperationException oe) {
					// New location to be redirected
					BetServlet.this.CurrentBetID--;
					String site = new String("Pages/InvalidRisk.html");

					response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
					response.setHeader("Location", site);
					oe.printStackTrace();
				} catch (SQLException se) {
					// New location to be redirected
					BetServlet.this.CurrentBetID--;
					String site = new String("Pages/InvalidBetAmount.html");

					response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
					response.setHeader("Location", site);
					se.printStackTrace();
				}
			}

		} catch (MySQLIntegrityConstraintViolationException primarykey_violation) {
			BetServlet.this.CurrentBetID--;
			System.out.println("There exists a bet with the same bet ID!");
		} catch (Exception e) {
			BetServlet.this.CurrentBetID--;

			// New location to be redirected
			String site = new String("Pages/MaxCumulativeBets.html");

			response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);

			System.out.println("Invalid Bet Parameters");
			e.printStackTrace();
		}
	}

	public void init() {
		try {
			ArrayList<ArrayList<String>> last_id = new ArrayList<>(
					place_bet.ExecuteQuery("SELECT max(BetID) FROM bets;"));
			if (last_id.get(0).get(0) != null)
				this.CurrentBetID = Long.parseLong(last_id.get(0).get(0));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			throws UnsupportedOperationException {
		if (((account_type == 0) && (risk_level == 0))
				|| ((account_type == 1) && (risk_level >= 0) && (risk_level < 3))) {
			return risk_level;
		} else
			throw new UnsupportedOperationException();
	}

	public int ValidateBetAmount(int account_type, int bet_amount,
			int total_bets) throws SQLException, Exception {

		if (bet_amount > 0
				&& total_bets >= 0
				&& (((account_type == 0) && (bet_amount <= 5)) || ((account_type == 1) && ((total_bets + bet_amount) <= 5000)))) {
			return bet_amount;

		} else if ((account_type == 1) && ((total_bets + bet_amount) > 5000)) {
			throw new Exception();
		}

		else {
			throw new SQLException();
		}
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
