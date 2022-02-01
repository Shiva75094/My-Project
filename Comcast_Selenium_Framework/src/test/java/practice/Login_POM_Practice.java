package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.objectrepositorylib.LoginPage;

public class Login_POM_Practice 
{
	public static void main(String[] args)
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888");
		LoginPage lp=new LoginPage(driver);
		

	}

}
