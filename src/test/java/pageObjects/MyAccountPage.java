package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	// elements
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement MyAccountPresence;
	
	@FindBy(xpath="//span[text()='Account' and @class='label']")
	WebElement lnkAccount;
	
	@FindBy(xpath="//a[text()='Log Out']")
	WebElement lnkLogout;
	
	// Action Methods
	
	public boolean isMyAccountExists()
	{
		try
		{
			return(MyAccountPresence.isDisplayed());
		}
		catch(Exception e) 
		{
			return(false);
		}
	}
	
	public void clickOnAccount()
	{
		lnkAccount.click();
	}
	
	public void clickOnLogout()
	{
		lnkLogout.click();
	}
}
