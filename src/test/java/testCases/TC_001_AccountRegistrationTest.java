package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	

	@Test(groups={"Master","Regression"})
	public void test_AccountRegister() 
	{
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		try {
			// homepage pom class
			HomePage hp=new HomePage(driver);
			hp.clickAccount();
			hp.clickRegister();
			
			// register pom class
			RegisterPage rp=new RegisterPage(driver);
			
			logger.info("Registration Started");
			rp.setFirstname(RandomString());
			rp.setLastname(RandomString());
		    rp.setEmail(RandomEmail()+"@gmail.com");
			
			// for randomly generated but same password
			String password=(RandomPassword());	
			rp.setPassword(password);
			rp.setConfirmPassword(password);
			rp.clickRegister();
			logger.info("Registration Completed");
			
			// validation
			
			logger.info("Validation Started");
			
			String accountConfirm=rp.getAccountConfirmationMsg();
			Assert.assertEquals(accountConfirm, "MY DASHBOARD");
			
			
		}
		catch(Exception e) 
		{
			logger.error("Test Failed");
			Assert.fail();
		}
		
		    logger.info("*** TC_001_AccountRegistrationTest Finished ***");
		
	}
	
	

}
