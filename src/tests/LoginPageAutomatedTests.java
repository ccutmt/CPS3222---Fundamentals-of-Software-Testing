package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPageAutomatedTests {

	WebDriver browser;

	@Before
	public void setUp() throws Exception {
		browser = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		browser.quit();
	}

	@Test
	public void UserNameField(){
		browser.get("http://localhost:8080/SoftwareTesting/Login.jsp");
		
		WebElement searchbox = browser.findElement(By.id("username"));
		searchbox.sendKeys("TestAccount");
		
		searchbox = browser.findElement(By.id("password"));
		searchbox.sendKeys("testing123");
		
		WebElement loginbutton = browser.findElement(By.id("login"));
		loginbutton.click();
		
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
	}

}
