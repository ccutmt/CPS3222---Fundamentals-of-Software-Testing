package Selenium.Registration;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface FillRegistrationInterface {
	public void visitPage();
	
	public void closeBrowser();
	public void fillForm();
	public void fillForm(String user, String password, String type);
	public void submitForm(String button);
	public void clearField(String field);
	public List<WebElement> findById(String name);
	public List<WebElement> findByClass(String classname);
}
