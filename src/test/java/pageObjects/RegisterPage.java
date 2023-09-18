package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

	public RegisterPage(WebDriver driver) 
	{
		super(driver);
	}
	
	// Elements
	
	@FindBy(id="firstname")
	WebElement txtFirstname;
	
	@FindBy(id="lastname")
	WebElement txtLastname;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="confirmation")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//span[contains(text(),'Register')]")
	WebElement btnRegister;
	
	@FindBy(xpath="//h1[normalize-space()='My Dashboard']")   // label element
	WebElement accountConfirmation;
	
	
	// Action methods
	
	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void clickRegister() 
	{
		btnRegister.click();
	}
	
	public String getAccountConfirmationMsg() 
	{
		try 
		{
			return (accountConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}
