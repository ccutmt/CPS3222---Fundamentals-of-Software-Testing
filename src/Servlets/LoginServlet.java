package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Executing Login Servlet");

		PrintWriter writer = response.getWriter();

		try {
			DBConnection db = new DBConnection(
					"SELECT Username, Password FROM PLAYERS WHERE Username = \""
							+ UsernameValidation(request
									.getParameter("username")) + "\";");

			// Set response content type
			response.setContentType("text/html");

			if (db.getUsername().isEmpty()) {
				// user not in database
				// New location to be redirected
				String site = new String("ErrorPages/UserNotFound.html");

				response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", site);

				System.out.println("User not registered yet");
			}

			else if (!db.getUsername().isEmpty()
					&& (db.getPassword()
							.contentEquals(PasswordValidation(request
									.getParameter("password"))))) {
				
				// testing start
//				ResultSet results = db.getResults();
//				int size = 0;
//				if (results != null) {
//					results.beforeFirst();
//					results.last();
//					size = results.getRow();
//				}
//				System.out.println("Testing result set: " + size);
				// testing end
				
				// user authenticated successfully
				System.out.println(db.getUsername() + " logged on");

				// remove attempted logins for the user
				new DBConnection(
						"DELETE FROM attempted_logins WHERE username = \""
								+ db.getUsername() + "\";");

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
					new DBConnection(
							"INSERT INTO attempted_logins (username, last_login, attempts_amount) VALUES (\""
									+ db.getUsername()
									+ "\", \""
									+ dateFormat.format(cal.getTime())
									+ "\", \"1\");");
				} catch (MySQLIntegrityConstraintViolationException e) {
					new DBConnection(
							"UPDATE attempted_logins SET last_login = \""
									+ dateFormat.format(cal.getTime())
									+ "\", attempts_amount = attempts_amount+1 WHERE username = \""
									+ db.getUsername() + "\";");
				}

				// New location to be redirected

				String site = new String("ErrorPages/LoginFailed.html");

				response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", site);

				System.out.println("Failed to authenticate user");
			}

		} catch (Exception e) {
			writer.println("Unable to Login");
			System.out.println("Failed to login user");
			e.printStackTrace();
		}

		writer.println("Login Servlet");
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

	public String PasswordValidation(String password) throws SQLException {
		if (password.length() > 8) {
			return password;
		} else {
			throw new SQLException();
		}
	}

}
