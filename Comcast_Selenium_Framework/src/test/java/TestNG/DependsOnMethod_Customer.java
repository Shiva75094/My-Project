package TestNG;

import org.testng.annotations.Test;

public class DependsOnMethod_Customer 
{
	@Test
	public void createCustomerTest()
	{
		System.out.println("Execute HDFC createCustomerTest");
		int[] arr= {1,2,3};
		System.out.println(arr[2]);
		
	}

	@Test(dependsOnMethods="createCustomerTest")
	public void modifyCustomerTest()
	{
		System.out.println("Execute modify HDFC to Airtel CustomerTest");
		
	}
	

	@Test(dependsOnMethods="modifyCustomerTest")
	public void deleteCustomerTest()
	{
		System.out.println("Execute delete Airtel CustomerTest");
		
	}

}
