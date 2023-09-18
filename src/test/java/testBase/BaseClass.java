package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters("Browser")
	public void setup(String br) 
	{
		logger=LogManager.getLogger(this.getClass());   // logging
		rb=ResourceBundle.getBundle("config"); // load config.properties file
		
		if(br.equals("Chrome")) 
		{	
		    driver=new ChromeDriver();
		}
		else if(br.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(rb.getString("appURL"));		
	}
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void tearDown() 
	{
		driver.quit();
	}
	
	public String RandomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}
	
	public String RandomEmail()
	{
		String generatedEmail=RandomStringUtils.randomAlphabetic(8);
		return generatedEmail;
	}
	
	public String RandomPassword()
	{
		String str=RandomStringUtils.randomAlphabetic(4);
		String num=RandomStringUtils.randomNumeric(4);
		return (str+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
		Date dt=new Date();
		String timeStamp=df.format(dt);
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try
		{
			FileUtils.copyFile(source, new File(destination));
		}
		catch (Exception e) 
		{
			e.getMessage();
		}
		return destination;
	}
	
	
	
}