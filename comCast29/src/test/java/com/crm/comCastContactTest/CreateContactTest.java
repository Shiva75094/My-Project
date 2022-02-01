package com.crm.comCastContactTest;

import org.testng.annotations.Test;

public class CreateContactTest
{
	@Test(groups="smokeTest")
	public void createContactTest()
	{
		System.out.println("This is create contact");
	}
	
	
	@Test(groups="regressionTest")
	public void modifyContactTest()
	{
		System.out.println("This is modify contact");
	}

}
