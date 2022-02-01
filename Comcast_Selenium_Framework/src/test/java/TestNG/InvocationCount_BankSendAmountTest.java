package TestNG;

import org.testng.annotations.Test;

public class InvocationCount_BankSendAmountTest
{
	@Test(invocationCount=4)
	public void sendAmountTest()
	{
		System.out.println("Execute Send Amount 50K");
	}

}
