package tests;

import java.sql.SQLException;

import Servlets.RegServlet;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RegistrationTests {

	private RegServlet regservlet;
	
	@Before
	public void setUp() throws Exception {
		 regservlet = new RegServlet();
	}

	@Test
	public void ValidateUsernameTest() throws SQLException {
		
		assertEquals("UsernameTesting", regservlet.UsernameValidation("UsernameTesting"));
	}
	
	@Test
	public void ValidateUsernameNumberTest() throws SQLException {
		
		assertEquals("UsernameTesting123", regservlet.UsernameValidation("UsernameTesting123"));
	}
	
	@Test
	public void ShortUsernameTest() {
		 try{
			 regservlet.UsernameValidation("chris");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void UsernameSpecialCharTest() {
		 try{
			 regservlet.UsernameValidation("UsernameTesting!!");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void ValidateCVV3DigitTest() throws SQLException {
		
		assertEquals("123", regservlet.CVVValidation("123"));
	}
	
	@Test
	public void LongCVVTest() {
		 try{
			 regservlet.CVVValidation("12345");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void CVVLetterTest() {
		 try{
			 regservlet.CVVValidation("1d2");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void ValidatePasswordTest() throws SQLException {
		
		assertEquals("password1994", regservlet.PasswordValidation("password1994"));
	}
	
	@Test
	public void ShortPasswordTest() {
		 try{
			 regservlet.PasswordValidation("chris");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void StringLettersOnly() {
		assertFalse(regservlet.containsNumbers("NoNumbers"));
	}
	
	@Test
	public void StringLettersNumbers() {
		assertTrue(regservlet.containsNumbers("Numbers12345"));
	}
	
	@Test
	public void NameValidationTest() throws SQLException{
		assertEquals("Andreas", regservlet.NameValidation("Andreas"));
	}
	
	@Test
	public void NameWithNumbersTest() {
		 try{
			 regservlet.NameValidation("Andreas45");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void NullNameTest() {
		 try{
			 regservlet.NameValidation(null);

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void EmptyNameTest() {
		 try{
			 regservlet.NameValidation("");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void SurnameValidationTest() throws SQLException{
		assertEquals("Spiteri", regservlet.SurnameValidation("Spiteri"));
	}
	
	@Test
	public void SurNameWithNumbersTest() {
		 try{
			 regservlet.SurnameValidation("Spiteri1002");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void NullSurnameTest() {
		 try{
			 regservlet.SurnameValidation(null);

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void EmptySurnameTest() {
		 try{
			 regservlet.SurnameValidation("");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void DOBValidationTestOver18() throws SQLException{
		assertEquals("1994-12-18", regservlet.DOBValidation("1994-12-18"));
	}
	
	@Test
	public void DOBUnder18() {
		 try{
			 regservlet.DOBValidation("1997-10-02");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void DOBValidationTestOver18EqaulYear() throws SQLException{
		assertEquals("1996-10-18", regservlet.DOBValidation("1996-10-18"));
	}
	
	@Test
	public void DOBValidationTestOver18EqaulYearEqualMonth() throws SQLException{
		assertEquals("1996-12-05", regservlet.DOBValidation("1996-12-05"));
	}
	
	@Test
	public void DOBValidationTestUnder18EqaulYearEqualMonth() {
		 try{
			 regservlet.DOBValidation("1996-12-21");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void CCNotExpiredTest() throws SQLException{
		assertEquals("2016-12-31", regservlet.CCExpiryDateValidation("2016-12-31"));
	}
	
	@Test
	public void CCExpiredTest() {
		 try{
			 regservlet.CCExpiryDateValidation("2012-12-02");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void CCSameMonthNotExpiredTest() throws SQLException{
		assertEquals("2014-12-31", regservlet.CCExpiryDateValidation("2014-12-31"));
	}
	
	@Test
	public void CCSameMonthExpiredTest() {
		 try{
			 regservlet.CCExpiryDateValidation("2014-12-02");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
}
