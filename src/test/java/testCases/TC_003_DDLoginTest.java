package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.ExcelUtility;

public class TC_003_DDLoginTest extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void DDloginTest(String email,String pwd,String exp)
	{
		logger.info("*** TC_003_DDLoginTest ***");
		try
		{
		HomePage hp=new HomePage(driver); 
		hp.clickAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(email);
		lp.enterPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean target=map.isMyAccountExists();
		
		if(exp.equals("Valid"))
		{
			if (target==true) 
			{
				map.clickOnAccount();
				map.clickOnLogout();
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.assertTrue(false);
			}
			
		}
			
			if(exp.equals("Invalid"))
			{
				if(target==true)
				{
					map.clickOnAccount();
					map.clickOnLogout();
					Assert.assertTrue(false);
				}
				else 
				{
					Assert.assertTrue(true);
				}
			
			}
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** Finished TC_003_DDLoginTest *** ");
		
}
	
	
	/*@DataProvider(name="dp1")
	public String[][] getData() throws IOException {
		
		String path="D:\\New folder\\Hybrid_Framework\\testData\\techPanda.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String loginData[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) 
		{
			for(int j=0;j<totalcols;j++)
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
	}*/
	
	
}
