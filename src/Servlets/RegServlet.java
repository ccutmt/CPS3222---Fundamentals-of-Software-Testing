package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;

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
			new DBConnection(
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
							+ "-"
							+ GetMaxDate(request.getParameter("cc_exp"))
							+ "\", " + request.getParameter("cvv") + " );");
			writer.println("User added Successfully");
			System.out.println("Added new User");
		} catch (MySQLIntegrityConstraintViolationException e1) {
			writer.println("User already Exists!");
			System.out.println("User already exists");
			e1.printStackTrace();
		} catch (SQLException e2) {
			writer.println("Cannot add new user to db");
			System.out.println("Failed to add new user");
			e2.printStackTrace();
		}
	}

	private int GetMaxDate(String date) {
		//method used for cc expiry date to find the maximum date for the particular month, in order to fit in db field
		System.out.println((date));
		Calendar calendar = Calendar.getInstance();
		String year = date.substring(0, 4);
		String month = date.substring(5, 7);
		calendar.set(Integer.parseInt(year), Integer.parseInt(month)-1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

}
