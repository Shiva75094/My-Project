package com.crm.comCastOrgTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateOrgTest 
{
	@Test(groups="smokeTest")
	public void createOrgTest()
	{
		
		System.out.println("This is create Org==>"+ System.getProperty("BROWSER"));

			
	}

	@Test(groups="regressionTest")
	public void modifyOrgTest()
	{
		System.out.println("This is modify Org");
	}

}
