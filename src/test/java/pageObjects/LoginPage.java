package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	// elements
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@id='send2']")
	WebElement btnLogin;
	
	// Action methods
	
	public void enterEmail(String email) 
	{
		txtEmail.sendKeys(email);
	}
	
	public void enterPassword(String password) 
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
}
