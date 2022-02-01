package com.crm.comcast.contacttest;

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
import com.crm.comcast.objectrepositorylib.ContactInformationPage;
import com.crm.comcast.objectrepositorylib.ContactsPage;
import com.crm.comcast.objectrepositorylib.CreateNewContactsPage;
import com.crm.comcast.objectrepositorylib.CreateNewOrganizationPage;
import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.LoginPage;
import com.crm.comcast.objectrepositorylib.OrganizationInformationPage;
import com.crm.comcast.objectrepositorylib.OrganizationsPage;

public class ContactTest extends BaseAnnoationClass
{

	@Test(groups="smokeTest")
	public void CreateContactTest() throws IOException
	{
		//Read test data from Excel File
		String lastName = eLib.getDataFromExcel("contact",1,2) + "_"+jLib.getRainDomNumber();

		//Step 3:Navigate to contacts
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();

		//Step 4:Navigate to create new contact Page
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactImg().click();


		//Step 5:Create contacts
		CreateNewContactsPage cnp=new CreateNewContactsPage(driver);
		cnp.createContact(lastName);

		//Step 6:Verify the contacts details
		ContactInformationPage ci=new ContactInformationPage(driver);
		String actLstName=ci.getContactHeaderSucMsg().getText();
		Assert.assertTrue(actLstName.contains(lastName),lastName +"==>Contact last name is not verified==FAIL");
		System.out.println(lastName +"==>Contact last name is verified==PASS");
		/*if(actLstName.contains(lastName))
		{
			System.out.println(lastName +"==>Contact last name is verified==PASS");
		}
		else
		{
			System.err.println(lastName +"==>Contact last name is not verified==FAIL");

		}*/

	}

	@Test(groups="regressionTest")
	public void CreateContactWithOrgTest() throws IOException
	{

		String lastName = eLib.getDataFromExcel("contact",1,2) + "_"+jLib.getRainDomNumber();
		String orgName = eLib.getDataFromExcel("contact",4,3) + "_"+jLib.getRainDomNumber();

		//Step 3:Navigate to contacts
		HomePage hp=new HomePage(driver);
		hp.getOrganizationLink().click();

		//Step 4:Navigate create new Org Page
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrgImg().click();

		//Step 5:Create Organization
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.createOrg(orgName);

		//Step 6:Wait for header element
		OrganizationInformationPage oi=new OrganizationInformationPage(driver);
		wLib.waitForElementToVisibility(driver, oi.getSuccesfullMsg());

		//Step 7:Navigate to contact page
		hp.getContactLink().click();

		//Step 8:Navigate to create new contact Page
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactImg().click();


		//Step 9:Create a new contact with Org Name page
		CreateNewContactsPage cnp=new CreateNewContactsPage(driver);
		cnp.createContact(lastName, orgName);

		//Step 10:Verify the contacts details
		ContactInformationPage ci=new ContactInformationPage(driver);
		wLib.waitForElementToVisibility(driver,ci.getContactHeaderSucMsg());
		String actLstName=ci.getContactHeaderSucMsg().getText();
		Assert.assertTrue(actLstName.contains(lastName),lastName +"==>Contact last name is not verified==FAIL");
		System.out.println(lastName +"==>Contact last name is verified==PASS");
		/*if(actLstName.contains(lastName))
		{
			System.out.println(lastName +"==>Contact last name is verified==PASS");
		}
		else
		{
			System.err.println(lastName +"==>Contact last name is not verified==FAIL");

		}*/

		//Step 11:Verify the OrgName details
		String actOrgMsg = ci.getOrgMsgInfo().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actOrgMsg.trim(), orgName,orgName +"==>org name is not verified==FAIL");
		System.out.println(orgName +"==>org name is verified==PASS");
		soft.assertAll();

		/*if(actOrgMsg.trim().equals(orgName))
		{
			System.out.println(orgName +"==>org name is verified==PASS");
		}
		else
		{
			System.err.println(orgName +"==>org name is not verified==FAIL");

		}*/

	}

}
