package Selenium.Registration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FillRegistration implements FillRegistrationInterface {
	WebDriver browser;

	public FillRegistration(WebDriver b){
		this.browser = b;
	}
	
	@Override
	public void visitRegister() {
		browser.get("http://localhost:8080/SoftwareTesting/Register.jsp");
	}

	@Override
	public void closeBrowser() {
		browser.close();

	}

	@Override
	public void fillForm() {
		WebElement field;
		field = browser.findElement(By.id("username"));
		field.sendKeys("Afriggieri4");

		field = browser.findElement(By.id("password"));
		field.sendKeys("testing123");

		field = browser.findElement(By.id("name"));
		field.sendKeys("Andreas");

		field = browser.findElement(By.id("surname"));
		field.sendKeys("Friggieri");

		field = browser.findElement(By.id("dob"));
		field.sendKeys("1994/12/12");

		field = browser.findElement(By.id("cc_num"));
		field.sendKeys("371449635398431");

		field = browser.findElement(By.id("cc_exp"));
		field.sendKeys("2018/12");

		field = browser.findElement(By.id("cvv")); 
		field.sendKeys("123");

	}

	@Override
	public void fillForm(String username, String password, String type) {
		WebElement field;
		field = browser.findElement(By.id("username"));
		field.sendKeys(username);

		field = browser.findElement(By.id("password"));
		field.sendKeys(password);

		field = browser.findElement(By.id("name"));
		field.sendKeys("Andreas");

		field = browser.findElement(By.id("surname"));
		field.sendKeys("Friggieri");

		field = browser.findElement(By.id("dob"));
		field.sendKeys("1994/12/12");

		if (type == "premium" || type == "Premium") {
			WebElement radiobutton = browser
					.findElement(By.id("account_type1"));
			radiobutton.click();
		}

		field = browser.findElement(By.id("cc_num"));
		field.sendKeys("371449635398431");

		field = browser.findElement(By.id("cc_exp"));
		field.sendKeys("2018/12");

		field = browser.findElement(By.id("cvv"));
		field.sendKeys("123");

	}

	@Override
	public void submitForm() {
		WebElement registerbutton = browser.findElement(By.id("register"));
		registerbutton.click();

	}

	@Override
	public void clearField(String field) {
		browser.findElement(By.id(field)).clear();
	}

	@Override
	public List<WebElement> findByID(String name) {
		List<WebElement> list = browser.findElements(By.id(name));
		return list;
	}

	@Override
	public List<WebElement> findByClass(String classname) {
		return browser.findElements(By.className(classname));
	}

}
