package UnitTests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import Functions.BettingFunctions;

public class BettingFunctionsTests {
	private BettingFunctions betfunctions;
	
	@Before
	public void setUp() throws Exception {
		betfunctions = new BettingFunctions();
	}
	
	@Test
	public void ValidateUsernameTest() throws SQLException {
		assertEquals("UsernameTesting", betfunctions.UsernameValidation("UsernameTesting"));
	}

	@Test
	public void ValidateUsernameNumberTest() throws SQLException {
		assertEquals("UsernameTesting123", betfunctions.UsernameValidation("UsernameTesting123"));
	}

	@Test
	public void ShortUsernameTest() {
		try {
			betfunctions.UsernameValidation("chris");

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void UsernameSpecialCharTest() {
		try {
			betfunctions.UsernameValidation("UsernameTesting!!");

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

}
