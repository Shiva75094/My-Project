package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	@FindBy(name="user_name")    //Rule 2:Identify all the element using @FindBy & @FindBys,@FindAll(Declaration)
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@id='submitButton']")})
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver)  //Rule 3:Execute all the elements and initialize the element PageFactory.initElement(initialization)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule :Declare all the elements as private and provide getters method,business method for(Utilization)
	public WebElement getUserNameEdt() 
	{
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() 
	{
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() 
	{
		return loginBtn;
	}
	
	public void loginToApp(String userName,String password)
	{
		//Step 1:Login
		userNameEdt.sendKeys(userName);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
	}

}
