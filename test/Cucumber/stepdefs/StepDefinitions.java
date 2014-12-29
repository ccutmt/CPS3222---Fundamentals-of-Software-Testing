package Cucumber.stepdefs;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Database.DBConnection;
import Selenium.Registration.FillRegistration;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	WebDriver browser;
	FillRegistration form;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		browser = new ChromeDriver();

		try {
			new DBConnection(
					"DELETE from Players where username=\"Afriggieri4\";");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		browser.quit();
	}

	@Given("^I am a user trying to register$")
	public void i_am_a_user_trying_to_register() throws Throwable {
		form = new FillRegistration(browser);
		form.visitRegister();
	}

	@When("^I register providing correct information$")
	public void i_register_providing_correct_information() throws Throwable {
		form.fillForm();
		form.submitForm("register");
	}

	@Then("^I should be told that the registration was successful$")
	public void i_should_be_told_that_the_registration_was_successful()
			throws Throwable {
		assertEquals(form.findByClass("message").get(0).getText(),
				"Registration Successful! - Proceed to Login Page");
	}
	
	@When("^I fill in a form with correct data and I change the \"(.*?)\" field to have incorrect input$")
	public void i_fill_in_a_form_with_correct_data_and_I_change_the_field_to_have_incorrect_input(
			String arg1) throws Throwable {
		form.fillForm();
		form.clearField(arg1);
		form.findByID(arg1).get(0).sendKeys("6\t \t");
	}

	@Then("^I  should  be  told in \"(.*?)\"  that  the  data  in  \"(.*?)\"  is \"(.*?)\"$")
	public void i_should_be_told_in_that_the_data_in_is(String arg1,
			String arg2, String arg3) throws Throwable {
		assertEquals(form.findByID(arg1).get(0).getText(), arg3);
	}
	
	@Given("^I am a user with a free account$")
	public void i_am_a_user_with_a_free_account() throws Throwable{
		
	}
	
	@When("^I try to place a bet of 5 euros$")
	public void i_try_to_place_a_bet_of_5_euros(){
		
	}
	
	@Then("I should be told the bet was successfully placed$")
	public void i_should_be_told_the_bet_was_successfully_placed(){
		
	}
}
