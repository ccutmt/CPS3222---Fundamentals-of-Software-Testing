package Selenium;


import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Database.DBConnection;

public class RegisterPageAutomatedTests {

	WebDriver browser;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		browser = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		browser.quit();
	}

	@Test
	public void UserNameField(){
		try{
			new DBConnection("DELETE from Players where username=\"Afriggieri3\";");
		}catch(SQLException se){
			se.printStackTrace();
		}
		
		browser.get("http://localhost:8080/SoftwareTesting/Register.jsp");
		
		WebElement searchbox = browser.findElement(By.id("username"));
		searchbox.sendKeys("Afriggieri3");
		
		searchbox = browser.findElement(By.id("password"));
		searchbox.sendKeys("testing123");
		
		searchbox = browser.findElement(By.id("name"));
		searchbox.sendKeys("Andreas");
		
		searchbox = browser.findElement(By.id("surname"));
		searchbox.sendKeys("Friggieri");
		
		searchbox = browser.findElement(By.id("dob"));
		searchbox.sendKeys("12/12/1994");
		
		WebElement radiobutton = browser.findElement(By.id("account_type1"));
		radiobutton.click();
		
		searchbox = browser.findElement(By.id("cc_num"));
		searchbox.sendKeys("371449635398431");
		
		searchbox = browser.findElement(By.id("cc_exp"));
		searchbox.sendKeys("2\t2018");
		
		searchbox = browser.findElement(By.id("cvv"));
		searchbox.sendKeys("123");
		
		WebElement registerbutton = browser.findElement(By.id("register"));
		registerbutton.click();
		
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
	}

}
