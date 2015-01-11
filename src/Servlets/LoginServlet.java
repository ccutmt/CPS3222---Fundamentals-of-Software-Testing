package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.DBConnection;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DBConnection login_player = DBConnection.getInstance();
	public ArrayList<ArrayList<String>> users = new ArrayList<>();
	public ArrayList<ArrayList<String>> check_logins = new ArrayList<>();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Executing Login Servlet");

		try {
			users = login_player.ExecuteQuery("SELECT Username, Password FROM PLAYERS WHERE Username = \""
							+ UsernameValidation(request
									.getParameter("username")) + "\";");

			// Set response content type
			response.setContentType("text/html");

			if (users.size() == 0) {
				// user not in database
				// New location to be redirected
				String site = new String("Pages/UserNotFound.html");

				response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", site);

				System.out.println("User not registered yet");
			} else {
				ArrayList<String> user = users.get(0);
				// check for any attempted logins
				check_logins = login_player.ExecuteQuery("SELECT last_login, attempts_amount FROM attempted_logins WHERE Username = \""
								+ UsernameValidation(request
										.getParameter("username")) + "\";");

				if (check_logins.size() == 0
						|| Integer.parseInt(check_logins.get(0).get(1)) < 3
						|| CheckforFiveMinutes(check_logins.get(0).get(0))) {
					// authenticate user

					if (!user.get(0).isEmpty()
							&& (user.get(1)
									.contentEquals(PasswordValidation(request
											.getParameter("password"))))) {

						// user authenticated successfully
						System.out.println(user.get(0) + " logged on");

						// remove attempted logins for the user
						login_player
								.ExecuteQuery("DELETE FROM attempted_logins WHERE username = \""
										+ user.get(0) + "\";");

						HttpSession session = request.getSession();
						session.setAttribute("usernameforbet", user.get(0));

						// New location to be redirected
						String site = new String("BetPage.jsp");

						response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
						response.setHeader("Location", site);
					} else {
						// invalid password
						// get current time
						DateFormat dateFormat = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
						Calendar cal = Calendar.getInstance();

						try {
							login_player
									.ExecuteQuery("INSERT INTO attempted_logins (username, last_login, attempts_amount) VALUES (\""
											+ user.get(0)
											+ "\", \""
											+ dateFormat.format(cal.getTime())
											+ "\", \"1\");");
						} catch (MySQLIntegrityConstraintViolationException e) {
							login_player
									.ExecuteQuery("UPDATE attempted_logins SET last_login = \""
											+ dateFormat.format(cal.getTime())
											+ "\", attempts_amount = attempts_amount+1 WHERE username = \""
											+ user.get(0) + "\";");
						}

						// last update
						/*
						 * if(CheckforFiveMinutes(check_logins.getResults().get(0
						 * ).get(0)) && !(user.get(1)
						 * .contentEquals(PasswordValidation(request
						 * .getParameter("password"))))) { //5minutes passed but
						 * password is incorrect // New location to be
						 * redirected String site = new
						 * String("Pages/LoginTimeout.html");
						 * 
						 * response.setStatus(HttpServletResponse.
						 * SC_MOVED_TEMPORARILY); response.setHeader("Location",
						 * site);
						 * 
						 * } else {
						 */
						// New location to be redirected

						String site = new String("Pages/LoginFailed.html");

						response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
						response.setHeader("Location", site);
						// }
						System.out.println("Failed to authenticate user");
					}
				} else {
					// user has to wait 5 minutes
					// New location to be redirected
					String site = new String("Pages/LoginTimeout.html");

					response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
					response.setHeader("Location", site);
				}
			}

		} catch (Exception e) {

			// New location to be redirected

			String site = new String("Pages/LoginFailed.html");

			response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);

			// writer.println("Unable to Login");
			System.out.println("Failed to login user");
			e.printStackTrace();
		}

		// writer.println("Login Servlet");
	}

	public Boolean CheckforFiveMinutes(String last_login) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		long time_diff = cal.getTimeInMillis()
				- dateFormat.parse(last_login).getTime();
		long diffMinutes = time_diff / (60 * 1000) % 60;

		System.out.println("Remaining time: " + diffMinutes);

		if (diffMinutes >= 5)
			return true;
		else
			return false;
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

	public String PasswordValidation(String password) throws SQLException {
		if (password.length() > 8) {
			return password;
		} else {
			throw new SQLException();
		}
	}

}
