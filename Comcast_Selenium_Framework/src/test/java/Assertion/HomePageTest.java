package Assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnoationClass;

public class HomePageTest extends BaseAnnoationClass
{
	@Test
	public void verifyHomePageTest()
	{
		String expectedPage="Home";
		String actTitle=driver.getTitle();
		boolean status = actTitle.contains(expectedPage);
		Assert.assertTrue(status,"Home Page is not Verified=FAIL");
		System.out.println("Home Page is Verified=PASS");
	}
	

	@Test(dependsOnMethods="verifyHomePageTest")
	public void verifyHomePageLogoTest()
	{
		 boolean imgStatus = driver.findElement(By.xpath("//img[@alt='vtiger-crm-logo.gif']")).isDisplayed();
		Assert.assertTrue(imgStatus,"Home Page Logo is not Verified=FAIL");
		System.out.println("Home Page Logo is Verified=PASS");
	}

}
