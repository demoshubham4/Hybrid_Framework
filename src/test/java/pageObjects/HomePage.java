package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver)
	{
		super(driver); // invoked parent class constructor
	}

	// elements
	
	@FindBy(xpath="//*[contains(text(),'Account') and @class='label']")
	WebElement lnkAccount;
	
	@FindBy(xpath="//*[contains(text(),'Register')]")
	WebElement lnkRegister;
	
	@FindBy(xpath="//*[contains(text(),'Log In')]")
	WebElement lnkLogin;
	
	
	
	
	// action methods
	
	public void clickAccount()
	{
		lnkAccount.click();
	}
	
	public void clickRegister() 
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	
}
