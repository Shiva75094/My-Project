package com.crm.comcast.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.LoginPage;

public class BaseAnnoationClass 
{
	// Object Creation for Utility Lib
	public JavaUtility jLib=new JavaUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sDriver=null;

	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS()
	{
		System.out.println("===================Connect to Data Base=====================");
	}

	
 //	@Parameters("browser")  Whene we run multiple test cases in different browser we need @parameters annoatation
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC(/*String BROWSER*/) throws IOException
	                              //chrome - suite xml file - testng
	                              //chrome - suite xml file - testng
	{
		System.out.println("===================Launch the Browser===================");
		//Read common data from properties file
	      String BROWSER = fLib.getPropertyKeyValue("browser");  //chrome
		String URL = fLib.getPropertyKeyValue("url");

		//Step 1:Launch the Browser
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();  //Launched chrome browser
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();   //Launched firefox browser
		}
		else if(BROWSER.equals("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}

		//Step 2:Login to App
		wLib.maximizeWindow(driver);
		wLib.waitUntilPageLoad(driver);
		driver.get(URL);
		sDriver=driver;
	}

	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws Throwable 
	{
		System.out.println("====================Login Application==============");
		//Read common data from properties file
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		//Step 3:Login 
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	}

	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM()
	{
		System.out.println("======================Logout Application====================");
		//Step 3:Logout
		HomePage hp=new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC()
	{
		System.out.println("===================Close the Browser===================");
		//Step 4:Close the Browser
		driver.quit();
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("===================Close Data Base connection=====================");

	}

}
