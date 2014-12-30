package Selenium.Bet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FillBet implements FillBetInterface {
	WebDriver browser;
	
	public FillBet(WebDriver b){
		this.browser = b;
	}
	
	@Override
	public void visitBet() {
		browser.get("http://localhost:8080/SoftwareTesting/BetPage.jsp");
	}

	@Override
	public void fillForm(String amount, String risk) {
			WebElement radiobutton = browser.findElement(By.id(risk));
			radiobutton.click();
		
		WebElement field;
		field = browser.findElement(By.id("bet_amt"));
		field.sendKeys(amount);
		
	}

	@Override
	public void submitForm(String button) {
		WebElement Betbutton = browser.findElement(By.id("bet"));
		Betbutton.click();
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
