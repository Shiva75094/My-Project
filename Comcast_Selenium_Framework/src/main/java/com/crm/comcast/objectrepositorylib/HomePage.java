package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.comcast.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	WebDriver driver;  //Global driver variable
	
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;

	@FindBy(linkText="Products")
	private WebElement ProductLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstatorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	public WebElement getOrganizationLink() 
	{
		return OrganizationLink;
	}

	public WebElement getContactLink() 
	{
		return contactLink;
	}

	public WebElement getProductLink() 
	{
		return ProductLink;
	}

	public WebElement getAdminstatorImg()
	{
		return adminstatorImg;
	}

	public WebElement getSignoutLink()
	{
		return signoutLink;
	}
	
	public void logout()
	{
		mouseOver(driver,adminstatorImg);
		signoutLink.click();
	}
	
}
