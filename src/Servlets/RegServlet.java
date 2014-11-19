package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DBConnection;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet(description = "Servlet for registration page", urlPatterns = { "/ServletRegistration" })
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Executing Registration Servlet");
		PrintWriter writer = response.getWriter();
		try {
			DBConnection db = new DBConnection(
					"INSERT INTO PLAYERS ( Username, Password, Name, Surname, DOB, Account, CCNum, CCExpDate, CVV )"
							+ " VALUES ( \""
							+ request.getParameter("username")
							+ "\", \""
							+ request.getParameter("password")
							+ "\""
							+ ", \""
							+ request.getParameter("name")
							+ "\", \""
							+ request.getParameter("surname")
							+ "\", "
							+ "\""
							+ request.getParameter("dob")
							+ "\", "
							+ request.getParameter("account_type")
							+ ", "
							+ request.getParameter("cc_num")
							+ ", \""
							+ request.getParameter("cc_exp")
							+ "-30\", "
							+ request.getParameter("cvv") + " );");
			writer.println("User added Successfully");
			System.out.println("Added new User");
		} catch (MySQLIntegrityConstraintViolationException ex) {
			writer.println("User already Exists!");
			System.out.println("User already exists");
			ex.printStackTrace();
		} catch (SQLException e) {
			writer.println("Cannot add new user to db");
			System.out.println("Failed to add new user");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
