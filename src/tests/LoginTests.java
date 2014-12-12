package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;

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
		
		assertEquals("UsernameTesting", loginservlet.UsernameValidation("UsernameTesting"));
	}
	
	@Test
	public void ValidateUsernameNumberTest() throws SQLException {
		
		assertEquals("UsernameTesting123", loginservlet.UsernameValidation("UsernameTesting123"));
	}
	
	@Test
	public void ShortUsernameTest() {
		 try{
			 loginservlet.UsernameValidation("chris");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void UsernameSpecialCharTest() {
		 try{
			 loginservlet.UsernameValidation("UsernameTesting!!");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
	
	@Test
	public void ValidatePasswordTest() throws SQLException {
		
		assertEquals("password1994", loginservlet.PasswordValidation("password1994"));
	}
	
	@Test
	public void ShortPasswordTest() {
		 try{
			 loginservlet.PasswordValidation("chris");

		        fail("expected SQLException");

		    } catch(SQLException e){
		        //ignore, this exception is expected.
		    }
	}
}
