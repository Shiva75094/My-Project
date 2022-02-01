package com.crm.comcast.organizationtest;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutility.BaseAnnoationClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;
import com.crm.comcast.objectrepositorylib.CreateNewOrganizationPage;
import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.LoginPage;
import com.crm.comcast.objectrepositorylib.OrganizationInformationPage;
import com.crm.comcast.objectrepositorylib.OrganizationsPage;

public class OrganizationTest extends BaseAnnoationClass
{
	@Test(groups="smokeTest")
	public void CreateOrgTest() throws IOException
	{
		//Read test data from Excel File
		String orgName = eLib.getDataFromExcel("org",1,2) + "_"+jLib.getRainDomNumber();

		//Navigate to Organization
		HomePage hp=new HomePage(driver);
		hp.getOrganizationLink().click();

		//Navigate to create Organization Page
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrgImg().click();

		//Create Organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		//Verify the Organization details
		OrganizationInformationPage oinfop=new OrganizationInformationPage(driver);
		wLib.waitForElementToVisibility(driver,oinfop.getSuccesfullMsg());
		String actSucMsg = oinfop.getSuccesfullMsg().getText();
		Assert.assertTrue(actSucMsg.contains(orgName),"Org is not created successfully==>Fail");
		System.out.println("Org is created successfully==>PASS");

		/*if(actSucMsg.contains(orgName))
		{
			System.out.println("Org is created successfully==>PASS");
		}
		else
		{
			System.err.println("Org is not created successfully==>Fail");

		}*/

	}

	@Test(groups="regressionTest")
	public void CreateOrgWithIndustriesTypeTest() throws IOException
	{	
		//Read data from Excel File
		String orgName = eLib.getDataFromExcel("org", 1, 2) + "_"+jLib.getRainDomNumber();
		String industries = eLib.getDataFromExcel("org",4,3);

		//Navigate to Organization
		HomePage hp=new HomePage(driver);
		hp.getOrganizationLink().click();

		//Navigate to create Organization Page
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrgImg().click();

		//Create Organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName, industries);

		//Verify the Organization details
		OrganizationInformationPage oinfop=new OrganizationInformationPage(driver);
		wLib.waitForElementToVisibility(driver,oinfop.getSuccesfullMsg());
		String actSucMsg = oinfop.getSuccesfullMsg().getText();
		Assert.assertTrue(actSucMsg.contains(orgName),orgName +"Org is not created successfully==>Fail");
		System.out.println(orgName +"Org is created successfully==>PASS");

		/*if(actSucMsg.contains(orgName))
		{
			System.out.println(orgName +"Org is created successfully==>PASS");
		}
		else
		{
			System.err.println(orgName +"Org is not created successfully==>Fail");

		}*/

		String actIndustriesInfo = oinfop.getIndustriesInfo().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actIndustriesInfo, industries,industries + "Org is not created successfully==>Fail");
		System.out.println(industries +" "+"Org is created successfully==>PASS");
		soft.assertAll();

		/*if(actIndustriesInfo.equals(industries))
		{
			System.out.println(industries +" "+"Org is created successfully==>PASS");
		}
		else
		{
			System.err.println(industries + "Org is not created successfully==>Fail");

		}*/

	}

}
