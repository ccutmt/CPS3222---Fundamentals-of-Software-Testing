package Selenium.Login;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface FillLoginInterface {
	public void visitLogin();
	public void fillForm(String username, String password);
	public void submitForm();
	public void clearField(String field);
	public List<WebElement> findByID(String name);
}
