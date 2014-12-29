package Selenium.Bet;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface FillBetInterface {
	public void visitBet();
	public void fillForm(String amount, String risk);
	public void submitForm(String button);
	public void clearField(String field);
	public List<WebElement> findByID(String name);
}
