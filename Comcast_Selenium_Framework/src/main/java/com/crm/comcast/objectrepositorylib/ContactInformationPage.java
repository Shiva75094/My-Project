package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage 
{
	public ContactInformationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement contactHeaderSucMsg;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgMsgInfo;

	public WebElement getContactHeaderSucMsg()
	{
		return contactHeaderSucMsg;
	}

	public WebElement getOrgMsgInfo() 
	{
		return orgMsgInfo;
	}
	
	

	
}
