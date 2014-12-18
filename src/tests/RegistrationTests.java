package tests;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	public void DOBValidationTestUnder18EqualYearEqualMonth(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -18);
		cal.add(Calendar.DAY_OF_MONTH, +1);
		 try{
			 regservlet.DOBValidation(dateFormat.format(cal.getTime()));

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void CCNotExpiredTest() throws SQLException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, +2);
		assertEquals(dateFormat.format(cal.getTime()), regservlet.CCExpiryDateValidation(dateFormat.format(cal.getTime())));
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		assertEquals(dateFormat.format(cal.getTime()), regservlet.CCExpiryDateValidation(dateFormat.format(cal.getTime())));
	}
	
	@Test
	public void CCSameYearMonthExpiredTest() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -2);
		 try{
			 regservlet.CCExpiryDateValidation(dateFormat.format(cal.getTime()));

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void CCType_VisaTest1() throws SQLException{
		assertEquals(1, regservlet.validateCCType("4111111111111111"));
	}
	
	@Test
	public void CCType_VisaTest2() throws SQLException{
		assertEquals(1, regservlet.validateCCType("4012888888881881"));
	}
	
	@Test
	public void CCType_VisaTest3() throws SQLException{
		assertEquals(1, regservlet.validateCCType("4222222222222"));
	}
	
	@Test
	public void CCType_MasterCardTest1() throws SQLException{
		assertEquals(2, regservlet.validateCCType("5555555555554444"));
	}
	
	@Test
	public void CCType_MasterCardTest2() throws SQLException{
		assertEquals(2, regservlet.validateCCType("5105105105105100"));
	}
	
	@Test
	public void CCType_AmericanExpressTest1() throws SQLException{
		assertEquals(3, regservlet.validateCCType("378282246310005"));
	}
	
	@Test
	public void CCType_AmericanExpressTest2() throws SQLException{
		assertEquals(3, regservlet.validateCCType("371449635398431"));
	}
	
	@Test
	public void CCType_AustralianBankCardTest() throws SQLException{
		assertEquals(0, regservlet.validateCCType("5610591081018250"));
	}
	
	@Test
	public void CCType_RandomNumberTest() throws SQLException{
		assertEquals(0, regservlet.validateCCType("1259874635148965"));
	}
	
	
	/*@Test
	public void CC_AmericanExpress_ValidationTest() throws SQLException{
		assertEquals("378282246310005", regservlet.CreditCardNum_Luhm("378282246310005"));
	}*/
	
	
}
