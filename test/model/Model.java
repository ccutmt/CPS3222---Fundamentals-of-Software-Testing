package model;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import net.sourceforge.czt.modeljunit.Action;
import net.sourceforge.czt.modeljunit.AllRoundTester;
import net.sourceforge.czt.modeljunit.FsmModel;
import net.sourceforge.czt.modeljunit.Tester;
import net.sourceforge.czt.modeljunit.VerboseListener;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Database.DBConnection;
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
		do {
			//do until a unique username is generated
			if (browser.getCurrentUrl().compareTo("http://localhost:8080/SoftwareTesting/Pages/ErrorAlreadyExists.html")==0){
				browser.findElement(By.id("back")).click();
			}
			
			this.username = generateUsername();
			this.password = "testing123";
			if (prob > 0.25) {
				this.acount_type = "free";
				reg_form.fillForm(this.username, this.password,
						this.acount_type);
			} else {
				this.acount_type = "premium";
				reg_form.fillForm(this.username, this.password,
						this.acount_type);
			}
			long timeBefore = System.currentTimeMillis();
			;
			reg_form.submitForm();
			
			long timeAfter = System.currentTimeMillis();
			responseTimes.add(timeAfter - timeBefore);
		} while (browser
				.getCurrentUrl()
				.compareTo(
						"http://localhost:8080/SoftwareTesting/Pages/RegistrationSuccess.html") != 0);
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
		;
		browser.findElement(By.id("login")).click();
		assertEquals("http://localhost:8080/SoftwareTesting/Login.jsp",
				browser.getCurrentUrl());
		long timeAfter = System.currentTimeMillis();
		;
		responseTimes.add(timeAfter - timeBefore);
	}

	public boolean proceedToLoginFailedGuard() {
		double prob = Math.random();
		if (prob <= 0.25 && getState().equals(States.LoginPage)
				&& this.attempted_logins < 3) {
			return true;
		} else
			return false;
	}

	@Action
	public void proceedToLoginFailed() {
		FillLogin log_form = new FillLogin(browser);
		log_form.fillForm(this.username, this.password + " ");
		this.attempted_logins++;
		long timeBefore = System.currentTimeMillis();
		;
		log_form.submitForm();
		assertEquals(
				"http://localhost:8080/SoftwareTesting/Pages/LoginFailed.html",
				browser.getCurrentUrl());
		long timeAfter = System.currentTimeMillis();
		;
		responseTimes.add(timeAfter - timeBefore);
	}

	// public boolean proceedToLoginTimeoutGuard() {
	// return getState().equals(States.LoginPage);
	// }
	//
	// @Action
	// public void proceedToLoginTimeout() {
	//
	// }

	public boolean proceedToBetGuard() {
		// double prob = Math.random();
		if (/* prob > 0.25 && */getState().equals(States.LoginPage)) {
			return true;
		} else if (getState().equals(States.Bet_Amount_Error)
				|| getState().equals(States.Bet_Cumulative_Error)
				|| getState().equals(States.Bet_Exceeded3Bets_Error)
				|| getState().equals(States.Bet_Risk_Error)
				|| getState().equals(States.Bet_Successful)) {
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
		;
		log_form.submitForm();
		assertEquals("http://localhost:8080/SoftwareTesting/BetPage.jsp",
				browser.getCurrentUrl());
		long timeAfter = System.currentTimeMillis();
		;
		responseTimes.add(timeAfter - timeBefore);
	}

	// public boolean proceedToMoreThan3BetsErrorGuard() {
	// return (getState().equals(States.BettingPage));
	// }
	//
	// @Action
	// public void proceedToMoreThan3BetsError() {
	//
	// }

	public boolean proceedToBetSuccessGuard() {
		// double prob = Math.random();
		double probInvalidBetAmount = Math.random();
		if ((/* prob > 0.5 && */getState().equals(States.BettingPage))
				&& ((this.acount_type.compareTo("premium") == 0) || (probInvalidBetAmount > (1 / 6)))) {
			return true;
		} else
			return false;
	}

	@Action
	public void proceedToBetSuccess() {
		FillBet bet_form = new FillBet(browser);
		Random random = new Random();
		if (this.acount_type.compareTo("free") == 0) {
			int randomAmount = random.nextInt(5) + 1;
			bet_form.fillForm(randomAmount + "", "low");
		} else {
			int randomAmount = random.nextInt(2000) + 100;
			bet_form.fillForm(randomAmount + "", "medium");
		}
		long timeBefore = System.currentTimeMillis();
		;
		bet_form.submitForm();
		assertEquals(
				"http://localhost:8080/SoftwareTesting/Pages/BetSuccess.html",
				browser.getCurrentUrl());
		long timeAfter = System.currentTimeMillis();
		;
		responseTimes.add(timeAfter - timeBefore);
		this.atLeastOneBet = true;
	}

	// public boolean proceedToCumulativeErrorGuard() {
	// return getState().equals(States.BettingPage);
	// }
	//
	// @Action
	// public void proceedToCumulativeError() {
	//
	// }
	//
	// public boolean proceedToRiskErrorGuard() {
	// return getState().equals(States.BettingPage);
	// }
	//
	// @Action
	// public void proceedToRiskError() {
	//
	// }
	//
	// public boolean proceedToBetAmountErrorGuard() {
	// return getState().equals(States.BettingPage);
	// }
	//
	// @Action
	// public void proceedToBetAmountError() {
	//
	// }

	public boolean logoutGuard() {
		double ran = Math.random();
		return (ran <= 0.5 && this.atLeastOneBet && getState().equals(
				States.BettingPage));
	}

	@Action
	public void logout() {
		long timeBefore = System.currentTimeMillis();
		;
		browser.findElement(By.id("logout")).click();
		assertEquals("http://localhost:8080/SoftwareTesting/HomePage.jsp",
				browser.getCurrentUrl());
		long timeAfter = System.currentTimeMillis();
		;
		responseTimes.add(timeAfter - timeBefore);
	}

	public String generateUsername() {
		Random rand = new Random();
		int randomNum = rand.nextInt((50000)) + 1;
		return "TestUser" + randomNum;
	}

	@Override
	public void run() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		browser = new ChromeDriver();
		Tester t = new AllRoundTester(this);
		t.addListener(new VerboseListener());
		t.generate(50);
		t.buildGraph();
		browser.close();
	}
}
