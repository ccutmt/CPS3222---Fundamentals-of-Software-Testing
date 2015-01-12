package Cucumber.stepdefs;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Database.DBConnection;
import Selenium.Bet.FillBet;
import Selenium.Login.FillLogin;
import Selenium.Registration.FillRegistration;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	WebDriver browser;
	FillRegistration reg_form;
	FillLogin log_form;
	FillBet bet_form;

	DBConnection cucumber_connection = DBConnection.getInstance();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		browser = new ChromeDriver();

		try {
			cucumber_connection
					.ExecuteQuery("DELETE from bets where username IN (\"Afriggieri4\", \"Afriggieri5\", \"Afriggieri6\");");

			cucumber_connection
					.ExecuteQuery("DELETE from attempted_logins where username IN (\"Afriggieri4\", \"Afriggieri5\", \"Afriggieri6\");");

			cucumber_connection
					.ExecuteQuery("DELETE from Players where username IN (\"Afriggieri4\", \"Afriggieri5\", \"Afriggieri6\");");

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		browser.quit();
	}

	@Given("^I am a user trying to register$")
	public void i_am_a_user_trying_to_register() {
		reg_form = new FillRegistration(browser);
		reg_form.visitRegister();
	}

	@When("^I register providing correct information$")
	public void i_register_providing_correct_information() {
		reg_form.fillForm();
		reg_form.submitForm();
	}

	@Then("^I should be told that the registration was successful$")
	public void i_should_be_told_that_the_registration_was_successful() {
		assertEquals(reg_form.findByClass("message").get(0).getText(),
				"Registration Successful! - Proceed to Login Page");
	}

	@When("^I fill in a form with correct data and I change the \"(.*?)\" field to have incorrect input$")
	public void i_fill_in_a_form_with_correct_data_and_I_change_the_field_to_have_incorrect_input(
			String arg1) {
		reg_form.fillForm();
		reg_form.clearField(arg1);
		reg_form.findByID(arg1).get(0).sendKeys("\t");
	}

	@Then("^I  should  be  told in \"(.*?)\"  that  the  data  in  \"(.*?)\"  is \"(.*?)\"$")
	public void i_should_be_told_in_that_the_data_in_is(String arg1,
			String arg2, String arg3) throws Throwable {
		assertEquals(reg_form.findByID(arg1).get(0).getText(), arg3);
	}

	@Given("^I am a user with a free account$")
	public void i_am_a_user_with_a_free_account() {
		CreateFreeAccount();
		log_form = new FillLogin(browser);
		log_form.visitLogin();
		log_form.fillForm("Afriggieri5", "testing123");
		log_form.submitForm(); 
	}

	@When("^I try to place a bet of 5 euros$")
	public void i_try_to_place_a_bet_of_5_euros() {
		bet_form = new FillBet(browser);
		bet_form.fillForm("5", "low");
		bet_form.submitForm();
	}

	@Then("^I should be told the bet was successfully placed$")
	public void i_should_be_told_the_bet_was_successfully_placed() {
		assertEquals("Bet Successful!", bet_form.findByClass("message").get(0)
				.getText());
		browser.findElement(By.className("sub")).click();
	}

	@Then("^I should be told that I have reached the maximum number of bets$")
	public void i_should_be_told_that_i_have_reached_the_maximum_number_of_bets() {
		assertEquals(
				"You are not allowed to make more than 3 bets!\n\nPlease register as a premium user",
				bet_form.findByID("error").get(0).getText());
	}

	@Given("^I am a user with a premium account$")
	public void i_am_a_user_with_a_premium_account() throws Throwable {
		CreatePremiumAccount();
		log_form = new FillLogin(browser);
		log_form.visitLogin();
		log_form.fillForm("Afriggieri6", "testing123");
		log_form.submitForm();
	}

	@When("^I try to place a bet of 5000 euros$")
	public void i_try_to_place_a_bet_of_5000_euros() {
		bet_form = new FillBet(browser);
		bet_form.fillForm("5000", "low");
		bet_form.submitForm();
	}

	@When("^I try to place a bet of 1 euros$")
	public void i_try_to_place_a_bet_of_1_euros() {
		bet_form = new FillBet(browser);
		bet_form.fillForm("1", "low");
		bet_form.submitForm();
	}

	@Then("^I should be told that I have reached the maximum cumulative betting amount$")
	public void i_should_be_told_that_i_have_reached_the_maximum_cumulative_betting_amount() {
		assertEquals("Bet Unsuccessful - Cumulative Betting Amount Reached",
				bet_form.findByClass("message").get(0).getText());
	}

	@Given("^I am a user who has not yet logged on$")
	public void i_am_a_user_who_has_not_yet_logged_on() {
		bet_form = new FillBet(browser);
	}

	@When("^I try to access the betting screen$")
	public void i_try_to_access_the_betting_screen() {
		bet_form.visitBet();
	}

	@Then("^I should be refused access$")
	public void i_should_be_refused_access() {
		assertEquals("Please login before trying to make a bet!", bet_form
				.findByClass("message").get(0).getText());
	}

	@When("^I try to place a \"(.*?)\" bet of (\\d+) euros$")
	public void i_try_to_place_a_bet_of_euros(String arg1, String arg2)
			throws Throwable {
		bet_form = new FillBet(browser);
		bet_form.fillForm(arg2, arg1);
		bet_form.submitForm();
	}

	@Then("^I should be \"([^\"]*)\" to bet$")
	public void i_should_be_to_bet(String arg1) {
		assertEquals(arg1, bet_form.findByClass("message").get(0).getText());
	}

	private void CreateFreeAccount() {
		try {
			cucumber_connection
					.ExecuteQuery("INSERT INTO PLAYERS ( Username, Password, Name, Surname, DOB, Account, CCNum, CCExpDate, CVV, Bets )"
							+ " VALUES ( \"Afriggieri5\", \"testing123\", \"Andreas\", \"Friggieri\", \"1994/09/29\", 0, 371449635398431, \"2018/05/30\", 123, 0 );");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void CreatePremiumAccount() {
		try {
			cucumber_connection
					.ExecuteQuery("INSERT INTO PLAYERS ( Username, Password, Name, Surname, DOB, Account, CCNum, CCExpDate, CVV, Bets )"
							+ " VALUES ( \"Afriggieri6\", \"testing123\", \"Andreas\", \"Friggieri\", \"1994/09/29\", 1, 371449635398431, \"2018/05/30\", 123, 0 );");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
