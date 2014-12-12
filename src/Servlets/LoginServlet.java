package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DBConnection;

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

			if (!db.getUsername().isEmpty()
					&& (db.getPassword()
							.contentEquals(PasswordValidation(request
									.getParameter("password"))))) {
				System.out.println(db.getUsername()+" logged on");
				writer.println("Welcome "+ db.getUsername());
			} else {
				writer.println("Invalid Password");
				System.out.println("Faied to authenticate user");
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
