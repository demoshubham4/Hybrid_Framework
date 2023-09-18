package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups= {"Sanity","Master"})
	public void test_login()
	{
		try {
		logger.info("*** Starting TC_002_LoginTest ***");
		
		HomePage hp=new HomePage(driver);
		hp.clickAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Login Started");
		lp.enterEmail(rb.getString("email")); // email and password from config.properties file
		lp.enterPassword(rb.getString("password"));
		lp.clickLogin();
		logger.info("Login Done");
		
		// validation
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean target=map.isMyAccountExists();
		Assert.assertEquals(target, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*** Finished TC_002_LoginTest ***");
	}
}
