package Selenium.Login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FillLogin implements FillLoginInterface {

	WebDriver browser;

	public FillLogin(WebDriver b){
		this.browser = b;
	}
	
	@Override
	public void visitLogin() {
		browser.get("http://localhost:8080/SoftwareTesting/Login.jsp");
	}

	@Override
	public void fillForm(String username, String password) {
		WebElement field;
		field = browser.findElement(By.id("username"));
		field.sendKeys(username);

		field = browser.findElement(By.id("password"));
		field.sendKeys(password);
	}

	@Override
	public void submitForm(String button) {
		WebElement Loginbutton = browser.findElement(By.id("login"));
		Loginbutton.click();

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
}
