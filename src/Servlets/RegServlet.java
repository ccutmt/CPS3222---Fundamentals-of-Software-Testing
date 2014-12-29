package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
					"INSERT INTO PLAYERS ( Username, Password, Name, Surname, DOB, Account, CCNum, CCExpDate, CVV, Bets )"
							+ " VALUES ( \""
							+ UsernameValidation(request
									.getParameter("username"))
							+ "\", \""
							+ PasswordValidation(request
									.getParameter("password"))
							+ "\""
							+ ", \""
							+ NameValidation(request.getParameter("name"))
							+ "\", \""
							+ SurnameValidation(request.getParameter("surname"))
							+ "\", "
							+ "\""
							+ DOBValidation(request.getParameter("dob"))
							+ "\", "
							+ request.getParameter("account_type")
							+ ", "
							+ CCNumValidation(request.getParameter("cc_num"))
							+ ", \""
							+ CCExpiryDateValidation(request
									.getParameter("cc_exp")
									+ "-"
									+ GetMaxDate(request.getParameter("cc_exp")))
							+ "\", "
							+ CVVValidation(request.getParameter("cvv"))
							+ ", 0 );");
			writer.println("User added Successfully");
			System.out.println("Added new User");

			// Set response content type
			response.setContentType("text/html");

			HttpSession session = request.getSession(true);
			session.setAttribute("usernameforbet",
					request.getParameter("username"));

			// New location to be redirected
			String site = new String("Pages/RegistrationSuccess.html");

			response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);
		} catch (MySQLIntegrityConstraintViolationException e1) {
			writer.println("User already Exists!");
			System.out.println("User already exists");
			e1.printStackTrace();

			// Set response content type
			response.setContentType("text/html");

			// New location to be redirected
			String site = new String("Pages/ErrorAlreadyExists.html");

			response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);
		} catch (SQLException e2) {
			writer.println("Cannot add new user to db");
			System.out.println("Failed to add new user");
			e2.printStackTrace();

			// Set response content type
			response.setContentType("text/html");

			// New location to be redirected
			String site = new String("Pages/AddUserFailed.html");

			response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);
		}
	}

	public int GetMaxDate(String date) {
		// method used for cc expiry date to find the maximum date for the
		// particular month, in order to fit in db field
		//System.out.println((date));
		Calendar calendar = Calendar.getInstance();
		String year = date.substring(0, 4);
		String month = date.substring(5, 7);
		calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
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

	public String CVVValidation(String cvv) throws SQLException {
		Pattern p = Pattern.compile("^[0-9]{3}$");
		Matcher m = p.matcher(cvv);
		boolean b = m.find();
		if (b == true) {
			return cvv;
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

	public boolean containsNumbers(String n) {
		Pattern p = Pattern.compile("^[A-Za-z]+$");
		Matcher m = p.matcher(n);
		boolean b = m.find();
		if (b == true) {
			return false;
		} else {
			return true;
		}
	}

	public String NameValidation(String name) throws SQLException {
		if (name == null || name == "") {
			throw new SQLException();
		} else if (containsNumbers(name) == true) {
			throw new SQLException();
		} else {
			return name;
		}
	}

	public String SurnameValidation(String surname) throws SQLException {
		if (surname == null || surname == "") {
			throw new SQLException();
		} else if (containsNumbers(surname) == true) {
			throw new SQLException();
		} else {
			return surname;
		}
	}

	public String DOBValidation(String dob) throws SQLException {
		Calendar pl_dob = Calendar.getInstance();

		String year = dob.substring(0, 4);
		String month = dob.substring(5, 7);
		String day = dob.substring(8, 10);

		pl_dob.set(Integer.parseInt(year), Integer.parseInt(month) - 1,
				Integer.parseInt(day));

		int pl_dob_year = pl_dob.get(Calendar.YEAR);
		int pl_dob_month = pl_dob.get(Calendar.MONTH);
		int pl_dob_day = pl_dob.get(Calendar.DAY_OF_MONTH);

		Calendar today = Calendar.getInstance();

		int td_year = today.get(Calendar.YEAR);
		int td_month = today.get(Calendar.MONTH);
		int td_day = today.get(Calendar.DAY_OF_MONTH);

		if ((td_year - pl_dob_year) > 18) {
			return dob;
		} else if ((td_year - pl_dob_year) == 18) {
			if ((td_month) >= pl_dob_month) {
				if (td_day >= pl_dob_day) {
					return dob;
				} else {
					throw new SQLException();
				}
			} else {
				throw new SQLException();
			}
		} else {
			throw new SQLException();
		}
	}

	public String CCExpiryDateValidation(String cc_exp) throws SQLException {
		Calendar exp = Calendar.getInstance();

		String year = cc_exp.substring(0, 4);
		String month = cc_exp.substring(5, 7);
		String day = cc_exp.substring(8, 9);

		exp.set(Integer.parseInt(year), Integer.parseInt(month) - 1,
				Integer.parseInt(day));

		int exp_year = exp.get(Calendar.YEAR);
		int exp_month = exp.get(Calendar.MONTH);

		Calendar today = Calendar.getInstance();

		int td_year = today.get(Calendar.YEAR);
		int td_month = today.get(Calendar.MONTH);

		if (exp_year > td_year) {
			return cc_exp;
		} else if (exp_year == td_year) {
			if (exp_month >= td_month) {
				return cc_exp;
			} else {
				throw new SQLException();
			}
		} else {
			throw new SQLException();
		}
	}

	public int validateCCType(String ccnum) {

		// if type remains 0, card type not accepted
		int cctype = 0;

		// eliminate non-digit characters
		ccnum = ccnum.replaceAll("[^0-9]", "");

		Pattern vp = Pattern.compile("^4[0-9]{12,15}$");
		Matcher vm = vp.matcher(ccnum);
		boolean v = vm.find();

		Pattern mcp = Pattern.compile("^5[1-5][0-9]{14}$");
		Matcher mcm = mcp.matcher(ccnum);
		boolean mc = mcm.find();

		Pattern aep = Pattern.compile("^3[47][0-9]{13}$");
		Matcher aem = aep.matcher(ccnum);
		boolean ae = aem.find();

		if (v == true) {
			// VISA: 4 and 12/15 digits
			cctype = 1;
		} else if (mc == true) {
			// Mastercard
			cctype = 2;
		} else if (ae == true) {
			// American Express
			cctype = 3;
		}

		return cctype;
	}

	public boolean CreditCardNum_Luhm(String ccnum) {
		// accept only digits, dashes or spaces, RegEx expression
		Pattern p = Pattern.compile("[^0-9- \t\n\r\f]+");
		Matcher m = p.matcher(ccnum);
		boolean b = m.find();

		if (b == true) {
			return false;
		} else {
			int result = 0;
			int intNum = 0;
			boolean even = false;

			// select all non digit string and eliminate
			ccnum = ccnum.replaceAll("[^0-9]", "");

			// start from the back of number
			for (int n = ccnum.length() - 1; n >= 0; n--) {
				char strNum = ccnum.charAt(n);

				// convert back to digit
				intNum = Integer.parseInt("" + strNum, 10);

				// alternate numbers
				if (even) {
					if ((intNum *= 2) > 9)
						// same result as summing the digits of the product
						intNum -= 9;
				}

				result += intNum;
				even = !even;
			}

			// if no remainder true else false
			int remainder = (result % 10);

			if (remainder == 0) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public String CCNumValidation(String ccnum) throws SQLException {
		if ((validateCCType(ccnum) != 0) && (CreditCardNum_Luhm(ccnum) == true)) {
			return ccnum;
		} else {
			throw new SQLException();
		}
	}

}
