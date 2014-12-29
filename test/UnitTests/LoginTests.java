package UnitTests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import Servlets.LoginServlet;

public class LoginTests {
	private LoginServlet loginservlet;
	
	@Before
	public void setUp() throws Exception {
		loginservlet = new LoginServlet();
	}

	@Test
	public void ValidateUsernameTest() throws SQLException {

		assertEquals("UsernameTesting",
				loginservlet.UsernameValidation("UsernameTesting"));
	}

	@Test
	public void ValidateUsernameNumberTest() throws SQLException {

		assertEquals("UsernameTesting123",
				loginservlet.UsernameValidation("UsernameTesting123"));
	}

	@Test
	public void ShortUsernameTest() {
		try {
			loginservlet.UsernameValidation("chris");

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void UsernameSpecialCharTest() {
		try {
			loginservlet.UsernameValidation("UsernameTesting!!");

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void ValidatePasswordTest() throws SQLException {

		assertEquals("password1994",
				loginservlet.PasswordValidation("password1994"));
	}

	@Test
	public void ShortPasswordTest() {
		try {
			loginservlet.PasswordValidation("chris");

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void CheckforFiveMinutesPass() throws ParseException {
		assertEquals(true,
				loginservlet.CheckforFiveMinutes("2014-12-14 18:00:00"));
	}

	@Test
	public void CheckforFiveMinutesUsingSameTime() throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		assertEquals(false, loginservlet.CheckforFiveMinutes(dateFormat
				.format(cal.getTime())));
	}
	
	@Test
	public void CheckforFiveMinutesFail() throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -3);
		assertEquals(false, loginservlet.CheckforFiveMinutes(dateFormat
				.format(cal.getTime())));
	}
	
	@Test
	public void CheckforFiveMinutesIncorrectTimeFormat() throws ParseException {
		try {
			loginservlet.CheckforFiveMinutes("2014-12-14 18:00");

			fail("expected ParseException");

		} catch (ParseException e) {
			// ignore, this exception is expected.
		}
	}
	
	@Test
	public void CheckforFiveMinutesIncorrectDateFormat() throws ParseException {
		try {
			loginservlet.CheckforFiveMinutes("2014-12 18:00:00");

			fail("expected ParseException");

		} catch (ParseException e) {
			// ignore, this exception is expected.
		}
	}
}
