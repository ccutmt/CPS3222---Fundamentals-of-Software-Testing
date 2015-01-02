package Selenium.Registration;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface FillRegistrationInterface {
	public void visitRegister();
	
	public void closeBrowser();
	public void fillForm();
	public void fillForm(String user, String password, String type);
	public void submitForm();
	public void clearField(String field);
	public List<WebElement> findByID(String name);
	public List<WebElement> findByClass(String classname);
}
