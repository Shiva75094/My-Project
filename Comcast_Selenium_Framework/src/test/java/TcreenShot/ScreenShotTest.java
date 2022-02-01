package TcreenShot;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutility.BaseAnnoationClass;
import com.crm.comcast.objectrepositorylib.ContactInformationPage;
import com.crm.comcast.objectrepositorylib.ContactsPage;
import com.crm.comcast.objectrepositorylib.CreateNewContactsPage;
import com.crm.comcast.objectrepositorylib.CreateNewOrganizationPage;
import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.OrganizationInformationPage;
import com.crm.comcast.objectrepositorylib.OrganizationsPage;

public class ScreenShotTest extends BaseAnnoationClass
{
	@Test
	public void contactTest()
	{
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		Assert.assertEquals("A","B");
	}
	
	@Test
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
		
		//Step 11:Verify the OrgName details
		String actOrgMsg = ci.getOrgMsgInfo().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actOrgMsg.trim(), orgName,orgName +"==>org name is not verified==FAIL");
		System.out.println(orgName +"==>org name is verified==PASS");
		soft.assertAll();

	}

}
