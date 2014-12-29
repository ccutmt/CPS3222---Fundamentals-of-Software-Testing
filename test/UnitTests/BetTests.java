package UnitTests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import Servlets.BetServlet;

public class BetTests {
	private BetServlet betservlet;

	@Before
	public void setUp() throws Exception {
		betservlet = new BetServlet();
	}

	@Test
	public void ValidateUsernameTest() throws SQLException {

		assertEquals("UsernameTesting",
				betservlet.UsernameValidation("UsernameTesting"));
	}

	@Test
	public void ValidateUsernameNumberTest() throws SQLException {

		assertEquals("UsernameTesting123",
				betservlet.UsernameValidation("UsernameTesting123"));
	}

	@Test
	public void ShortUsernameTest() {
		try {
			betservlet.UsernameValidation("chris");

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void UsernameSpecialCharTest() {
		try {
			betservlet.UsernameValidation("UsernameTesting!!");

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void ValidateRiskLevelFreeLow() throws SQLException {
		assertEquals(0, betservlet.ValidateRiskLevel(0, 0));
	}

	@Test
	public void ValidateRiskLevelFreeMed() throws SQLException {
		try {
			betservlet.ValidateRiskLevel(0, 1);

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void ValidateRiskLevelFreeHigh() throws SQLException {
		try {
			betservlet.ValidateRiskLevel(0, 2);

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void ValidateRiskLevelPremiumLow() throws SQLException {
		assertEquals(0, betservlet.ValidateRiskLevel(1, 0));
	}

	@Test
	public void ValidateRiskLevelPremiumMed() throws SQLException {
		assertEquals(1, betservlet.ValidateRiskLevel(1, 1));
	}

	@Test
	public void ValidateRiskLevelPremiumHigh() throws SQLException {
		assertEquals(2, betservlet.ValidateRiskLevel(1, 2));
	}

	@Test
	public void ValidateRiskLevelOutofBounds1() throws SQLException {
		// setting account type to 2 should fail
		try {
			betservlet.ValidateRiskLevel(2, 2);

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void ValidateRiskLevelOutofBounds2() throws SQLException {
		// setting risk level to 3 should fail
		try {
			betservlet.ValidateRiskLevel(1, 3);

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void ValidateBetAmountFreeZeroBet() throws SQLException {
		try {
			betservlet.ValidateBetAmount(0, 0, 0);

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void ValidateBetAmountFreeOverLimit() throws SQLException {
		try {
			betservlet.ValidateBetAmount(0, 10, 0);

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void ValidatBetAmountFreeValid1() throws SQLException {
		assertEquals(5, betservlet.ValidateBetAmount(0, 5, 0));
	}

	@Test
	public void ValidatBetAmountFreeValid2() throws SQLException {
		assertEquals(3, betservlet.ValidateBetAmount(0, 3, 0));
	}

	@Test
	public void ValidatBetAmountFreeValid3() throws SQLException {
		assertEquals(1, betservlet.ValidateBetAmount(0, 1, 0));
	}

	@Test
	public void ValidateBetAmountFreeOverTotal() throws SQLException {
		try {
			betservlet.ValidateBetAmount(0, 5, 15);

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void ValidatBetAmountFreeMaxCumulatuveBets() throws SQLException {
		assertEquals(5, betservlet.ValidateBetAmount(0, 5, 10));
	}

	@Test
	public void ValidateBetAmountPremiumZeroBet() throws SQLException {
		try {
			betservlet.ValidateBetAmount(1, 0, 0);

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void ValidateBetAmountPremiumOverLimit() throws SQLException {
		try {
			betservlet.ValidateBetAmount(1, 5001, 0);

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void ValidateBetAmountPremiumValidBet1() throws SQLException {
		assertEquals(1, betservlet.ValidateBetAmount(1, 1, 0));
	}

	@Test
	public void ValidateBetAmountPremiumValidBet2() throws SQLException {
		assertEquals(2000, betservlet.ValidateBetAmount(1, 2000, 0));
	}

	@Test
	public void ValidateBetAmountPremiumValidBet3() throws SQLException {
		assertEquals(5000, betservlet.ValidateBetAmount(1, 5000, 0));
	}

	@Test
	public void ValidateBetAmountPremiumMaxCumulativeBets() throws SQLException {
		assertEquals(2000, betservlet.ValidateBetAmount(1, 2000, 3000));
	}

	@Test
	public void ValidateBetAmountPremiumOverTotal() throws SQLException {
		try {
			betservlet.ValidateBetAmount(1, 2001, 3000);

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void ValidateBetAmountAccountOutofBounds() throws SQLException {
		try {
			betservlet.ValidateBetAmount(2, 0, 0);

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void ValidateBetAmountTotalOutofBounds() throws SQLException {
		try {
			betservlet.ValidateBetAmount(1, 0, -2000);

			fail("expected SQLException");

		} catch (SQLException e) {
			// ignore, this exception is expected.
		}
	}

	@Test
	public void GenerateBetID1() throws SQLException {
		assertEquals(1, betservlet.GenerateBetID());
	}

	@Test
	public void GenerateBetID2() throws SQLException {
		assertEquals(2, betservlet.GenerateBetID());
	}

	@Test
	public void GenerateBetID3() throws SQLException {
		assertEquals(3, betservlet.GenerateBetID());
	}
}
