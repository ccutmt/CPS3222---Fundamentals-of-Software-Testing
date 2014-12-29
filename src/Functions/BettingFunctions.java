package Functions;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Database.DBConnection;

public class BettingFunctions {
	public String getAllBets(String username) {
		String html = "";
		try {
			DBConnection bets = new DBConnection(
					"SELECT BetID, RiskLevel, Amount FROM bets WHERE Username = \""
							+ UsernameValidation(username) + "\";");

			for (int i = 0; i < bets.getResults().size(); i++) {
				html += "<tr>";
				html += "<td>" + bets.getResults().get(i).get(0) + "</td>";
				if (bets.getResults().get(i).get(1).equals("0")) {
					html += "<td>" + "Low" + "</td>";
				} else if (bets.getResults().get(i).get(1).equals("1")) {
					html += "<td>" + "Middle" + "</td>";
				} else {
					html += "<td>" + "High" + "</td>";
				}
				html += "<td>" + bets.getResults().get(i).get(2) + "</td>\n";
				html += "</tr>";
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return html;
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
}