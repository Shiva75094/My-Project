package com.vtiger.comcast.contact.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Contact_Test 
{
	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("./data/commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");

		WebDriver driver;
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	    driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	    WebElement sel = driver.findElement(By.name("salutationtype"));
	    Select s1=new Select(sel);
	    s1.selectByIndex(1);
	    driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("piyush");
	    driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("singh");
		WebElement grop = driver.findElement(By.xpath("//select[@name='assigned_group_id']"));
		Select s2=new Select(grop);
		s2.selectByIndex(1);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actrul = driver.findElement(By.className("dvHeaderText")).getText();
		String name = driver.findElement(By.id("dtlview_First Name")).getText();
		if(actrul.contains(name))
		{
			System.out.println("Contact information updated today");
		}
		else
		{
			System.out.println("Contact information not updated today");
		}

		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

}
