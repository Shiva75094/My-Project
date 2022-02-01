package TestNG;

import org.testng.annotations.Test;

public class Priority_CustomerTest 
{
	@Test(priority=1)
	public void createCustomerTest()
	{
		System.out.println("Execute HDFC createCustomerTest");
		
	}

	@Test(priority=2)
	public void modifyCustomerTest()
	{
		System.out.println("Execute modify HDFC to Airtel CustomerTest");
		
	}
	

	@Test(priority=3)
	public void deleteCustomerTest()
	{
		System.out.println("Execute delete Airtel CustomerTest");
		
	}

}
