package Functions;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import Database.DBConnection;

public class BettingFunctions {	
	public void getAllBets(String username) {
		try {
			DBConnection bets = new DBConnection(
					"SELECT BetID, RiskLevel, Amount FROM bets WHERE Username = \""
							+ UsernameValidation(username) + "\";");

			for(int i = 0; i < bets.getResults().size(); i++) {
				System.out.println(bets.getResults().get(i).get(0) + " " + bets.getResults().get(i).get(1) + " " + bets.getResults().get(i).get(2));				
			}
		} catch (SQLException se) {
			se.printStackTrace();
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
}