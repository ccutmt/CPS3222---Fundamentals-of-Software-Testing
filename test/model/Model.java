package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Random;

import net.sourceforge.czt.modeljunit.Action;
import net.sourceforge.czt.modeljunit.AllRoundTester;
import net.sourceforge.czt.modeljunit.RandomTester;
import net.sourceforge.czt.modeljunit.LookaheadTester;
import net.sourceforge.czt.modeljunit.GreedyTester;
import net.sourceforge.czt.modeljunit.FsmModel;
import net.sourceforge.czt.modeljunit.Tester;
import net.sourceforge.czt.modeljunit.VerboseListener;
import net.sourceforge.czt.modeljunit.coverage.ActionCoverage;
import net.sourceforge.czt.modeljunit.coverage.StateCoverage;
import net.sourceforge.czt.modeljunit.coverage.TransitionCoverage;
import net.sourceforge.czt.modeljunit.coverage.TransitionPairCoverage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Selenium.Bet.FillBet;
import Selenium.Login.FillLogin;
import Selenium.Registration.FillRegistration;

public class Model implements FsmModel, Runnable {

	ChromeDriver browser;
	String url;
	String username;
	String password;
	String acount_type;
	int amountOfBets;
	int attempted_logins;
	boolean atLeastOneBet;

	ArrayList<Long> responseTimes = new ArrayList<>();

	public Model(ArrayList<Long> response) {
		this.responseTimes = response;
	}

	@Override
	public Object getState() {
		url = browser.getCurrentUrl();
		if (url.compareTo("http://localhost:8080/SoftwareTesting/HomePage.jsp") == 0
				|| url.compareTo("http://localhost:8080/SoftwareTesting/") == 0) {
			return States.HomePage;
		} else if (url
				.compareTo("http://localhost:8080/SoftwareTesting/Register.jsp") == 0) {
			return States.RegistrationPage;
		} else if (url
				.compareTo("http://localhost:8080/SoftwareTesting/Pages/RegistrationSuccess.html") == 0) {
			return States.Registration_Successful;
		} else if (url
				.compareTo("http://localhost:8080/SoftwareTesting/Login.jsp") == 0) {
			return States.LoginPage;
		} else if (url
				.compareTo("http://localhost:8080/SoftwareTesting/Pages/LoginFailed.html") == 0) {
			return States.Login_Failed_Error;
		} else if (url
				.compareTo("http://localhost:8080/SoftwareTesting/Pages/LoginTimeout.html") == 0) {
			return States.Login_Timeout_Error;
		} else if (url
				.compareTo("http://localhost:8080/SoftwareTesting/BetPage.jsp") == 0) {
			return States.BettingPage;
		} else if (url
				.compareTo("http://localhost:8080/SoftwareTesting/Pages/MoreThan3Bets.html") == 0) {
			return States.Bet_Exceeded3Bets_Error;
		} else if (url
				.compareTo("http://localhost:8080/SoftwareTesting/Pages/BetSuccess.html") == 0) {
			return States.Bet_Successful;
		} else if (url
				.compareTo("http://localhost:8080/SoftwareTesting/Pages/MaxCumulativeBets.html") == 0) {
			return States.Bet_Cumulative_Error;
		} else if (url
				.compareTo("http://localhost:8080/SoftwareTesting/Pages/InvalidRisk.html") == 0) {
			return States.Bet_Risk_Error;
		} else if (url
				.compareTo("http://localhost:8080/SoftwareTesting/Pages/InvalidBetAmount.html") == 0) {
			return States.Bet_Amount_Error;
		} else
			return null;
	}

	@Override
	public void reset(boolean arg0) {
		this.url = "";
		this.username = "";
		this.password = "";
		this.acount_type = "";
		this.amountOfBets = 0;
		this.attempted_logins = 0;
		this.atLeastOneBet = false;
		long timeBefore = System.currentTimeMillis();
		;
		browser.get("http://localhost:8080/SoftwareTesting/");
		long timeAfter = System.currentTimeMillis();
		;
		responseTimes.add(timeAfter - timeBefore);
	}

	public boolean proceedToRegisterGuard() {
		return getState().equals(States.HomePage);
	}

	@Action
	public void proceedToRegister() {
		long timeBefore = System.currentTimeMillis();
		;
		browser.findElement(By.id("register")).click();
		assertEquals("http://localhost:8080/SoftwareTesting/Register.jsp",
				browser.getCurrentUrl());
		long timeAfter = System.currentTimeMillis();
		;
		responseTimes.add(timeAfter - timeBefore);
	}

	public boolean proceedToRegisterSuccessfulGuard() {
		return getState().equals(States.RegistrationPage);
	}

	@Action
	public void proceedToRegisterSuccessful() {
		FillRegistration reg_form = new FillRegistration(browser);
		double prob = Math.random();
		// do {
		// do until a unique username is generated
		if (browser
				.getCurrentUrl()
				.compareTo(
						"http://localhost:8080/SoftwareTesting/Pages/ErrorAlreadyExists.html") == 0) {
			browser.findElement(By.id("back")).click();
		}

		this.username = generateUsername();
		this.password = "testing123";
		if (prob > 0.25) {
			this.acount_type = "free";
			reg_form.fillForm(this.username, this.password, this.acount_type);
		} else {
			this.acount_type = "premium";
			reg_form.fillForm(this.username, this.password, this.acount_type);
		}
		long timeBefore = System.currentTimeMillis();
		;
		reg_form.submitForm();

		long timeAfter = System.currentTimeMillis();
		responseTimes.add(timeAfter - timeBefore);
		// } while (browser
		// .getCurrentUrl()
		// .compareTo(
		// "http://localhost:8080/SoftwareTesting/Pages/RegistrationSuccess.html")
		// != 0);
		assertEquals(
				"http://localhost:8080/SoftwareTesting/Pages/RegistrationSuccess.html",
				browser.getCurrentUrl());

	}

	public boolean proceedToLoginGuard() {
		return (getState().equals(States.Registration_Successful)
				|| getState().equals(States.Login_Failed_Error) || getState()
				.equals(States.Login_Timeout_Error));
	}

	@Action
	public void proceedToLogin() {
		long timeBefore = System.currentTimeMillis();
		browser.findElement(By.id("login")).click();
		assertEquals("http://localhost:8080/SoftwareTesting/Login.jsp",
				browser.getCurrentUrl());
		long timeAfter = System.currentTimeMillis();
		responseTimes.add(timeAfter - timeBefore);
	}

	public boolean proceedToLoginFailedGuard() {
		double prob = Math.random();
		// 25% chance to be invalid if less than 3 attempted logins, else
		// timeout state
		if (prob <= 0.25 && getState().equals(States.LoginPage)
				&& this.attempted_logins <= 3) {
			return true;
		} else
			return false;
	}

	@Action
	public void proceedToLoginFailed() {
		FillLogin log_form = new FillLogin(browser);
		// adding a space to the password to create an invalid login
		log_form.fillForm(this.username, this.password + " ");
		this.attempted_logins++;
		long timeBefore = System.currentTimeMillis();
		log_form.submitForm();
		assertEquals(
				"http://localhost:8080/SoftwareTesting/Pages/LoginFailed.html",
				browser.getCurrentUrl());
		long timeAfter = System.currentTimeMillis();
		responseTimes.add(timeAfter - timeBefore);
	}

	public boolean proceedToLoginTimeoutGuard() {
		if (getState().equals(States.LoginPage) && this.attempted_logins > 3) {
			return true;
		} else
			return false;

	}

	@Action
	public void proceedToLoginTimeout() {
		assertEquals(
				"http://localhost:8080/SoftwareTesting/Pages/LoginTimeout.html",
				browser.getCurrentUrl());
		// this.attempted_logins = 0;
	}

	public boolean proceedToBetGuard() {
		double probFailLogin = Math.random();
		if (getState().equals(States.LoginPage) && probFailLogin > 0.25) {
			return true;
		} else if (getState().equals(States.Bet_Amount_Error)
				|| getState().equals(States.Bet_Cumulative_Error)
				|| getState().equals(States.Bet_Exceeded3Bets_Error)
				|| getState().equals(States.Bet_Risk_Error)
				|| getState().equals(States.Bet_Successful)) {
			// visit betting state
			browser.findElement(By.id("bet")).click();
			return true;
		} else
			return false;
	}

	@Action
	public void proceedToBet() {
		FillLogin log_form = new FillLogin(browser);
		log_form.fillForm(this.username, this.password);
		long timeBefore = System.currentTimeMillis();
		log_form.submitForm();
		assertEquals("http://localhost:8080/SoftwareTesting/BetPage.jsp",
				browser.getCurrentUrl());
		long timeAfter = System.currentTimeMillis();
		responseTimes.add(timeAfter - timeBefore);
	}

	public boolean proceedToBetSuccessGuard() {
		double probNotLogout = Math.random();
		double probInvalidBetAmount = Math.random();
		if (probNotLogout > 0.5
				&& ((getState().equals(States.BettingPage)) && ((this.acount_type
						.compareTo("premium") == 0) || (probInvalidBetAmount > (1 / 6))))) {
			// free user can also bet 6 euro, which is invalid
			return true;
		} else
			return false;
	}

	@Action
	public void proceedToBetSuccess() {
		FillBet bet_form = new FillBet(browser);
		Random random = new Random();
		if (this.acount_type.compareTo("free") == 0) {
			// 1 to 5 since 6euro is invalid and catered for in the Guard
			int randomAmount = random.nextInt(5) + 1;
			bet_form.fillForm(randomAmount + "", "low");
			// this.cumulative_bets += randomAmount;
		} else {
			// 100 to 2000 euro
			int randomAmount = random.nextInt(2000) + 100;
			bet_form.fillForm(randomAmount + "", "medium");
			// this.cumulative_bets += randomAmount;
		}
		long timeBefore = System.currentTimeMillis();
		bet_form.submitForm();
		assertEquals(
				"http://localhost:8080/SoftwareTesting/Pages/BetSuccess.html",
				browser.getCurrentUrl());
		long timeAfter = System.currentTimeMillis();
		responseTimes.add(timeAfter - timeBefore);
		this.atLeastOneBet = true;
	}

	public boolean proceedToBetAmountErrorGuard() {
		double probInvalidBetAmount = Math.random();
		if (getState().equals(States.BettingPage)
				&& probInvalidBetAmount <= 1 / 6
				&& this.acount_type.compareTo("free") == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Action
	public void proceedToBetAmountError() {
		FillBet bet_form = new FillBet(browser);
		bet_form.fillForm(6 + "", "low");

		long timeBefore = System.currentTimeMillis();
		bet_form.submitForm();
		assertEquals(
				"http://localhost:8080/SoftwareTesting/Pages/InvalidBetAmount.html",
				browser.getCurrentUrl());
		long timeAfter = System.currentTimeMillis();
		responseTimes.add(timeAfter - timeBefore);
		this.atLeastOneBet = true;
	}

	public boolean logoutGuard() {
		double ran = Math.random();
		// user has to place at least 1 bet to logout
		if (ran <= 0.5 && this.atLeastOneBet
				&& getState().equals(States.BettingPage)) {
			return true;
		} else
			return false;
	}

	@Action
	public void logout() {
		long timeBefore = System.currentTimeMillis();
		browser.findElement(By.id("logout")).click();
		assertEquals("http://localhost:8080/SoftwareTesting/HomePage.jsp",
				browser.getCurrentUrl());
		long timeAfter = System.currentTimeMillis();
		responseTimes.add(timeAfter - timeBefore);
	}

	public String generateUsername() {
		Random rand = new Random();
		int randomNum = rand.nextInt((9999999)) + 1;
		return "TestUser" + randomNum;
	}

	@Override
	public void run() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		browser = new ChromeDriver();
		Tester t = new AllRoundTester(this);
		// LookaheadTester t = new LookaheadTester(this);
		// t.setDepth(1);
		t.addCoverageMetric(new TransitionCoverage());
		t.addCoverageMetric(new StateCoverage());
		t.addCoverageMetric(new ActionCoverage());
		t.addCoverageMetric(new TransitionPairCoverage());
		t.addListener(new VerboseListener());
		t.generate(10);
		t.buildGraph();
		browser.close();
		t.printCoverage();
	}

	/*
	 * @Override public void run() {
	 * System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	 * browser = new ChromeDriver(); Tester t = new AllRoundTester(this);
	 * t.addListener(new VerboseListener()); t.generate(25); t.buildGraph();
	 * browser.close(); }
	 */
}
