package Database;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegisterPageAutomatedTests {

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
		browser.get("http://localhost:8080/SoftwareTesting/Register.jsp");
		
		WebElement searchbox = browser.findElement(By.id("username"));
		searchbox.sendKeys("ccut0018");
		searchbox.submit();
		
		WebElement registerbutton = browser.findElement(By.id("register"));
		registerbutton.click();
		
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
	}
	
	/*@Test
	public void searchForBook(){
		browser.get("http://www.play.com");
		
		WebElement searchbox = browser.findElement(By.id("searchstring"));
		searchbox.sendKeys("Charlie and the Choclate Factory");
		searchbox.submit();
		
		WebElement searchbutton = browser.findElement(By.id("searchSubmit"));
		searchbutton.click();
		
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
	}*/

}
