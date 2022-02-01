package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage 
{
	public OrganizationInformationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement succesfullMsg;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industriesInfo;
	
	

	public WebElement getIndustriesInfo()
	{
		return industriesInfo;
	}

	public WebElement getSuccesfullMsg()
	{
		return succesfullMsg;
	}
	
	
}
