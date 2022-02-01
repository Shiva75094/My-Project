package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest_DataProvider1 
{
	@Test(dataProvider="dataProvider_bookTicketTest")
	public void bookTicket(String src,String dst)
	{
		System.out.println("Book ticket from "+src+" to "+dst);
	}
	
	@DataProvider
	public Object[][] dataProvider_bookTicketTest()
	{
		Object[][] objArr=new Object[5][2];
		objArr[0][0]="Banglore";
		objArr[0][1]="Goa";
		
		objArr[1][0]="Banglore";
		objArr[1][1]="Mysore";
		
		objArr[2][0]="Banglore";
		objArr[2][1]="Managlore";
		
		objArr[3][0]="Banglore";
		objArr[3][1]="Hyd";
		
		objArr[4][0]="Banglore";
		objArr[4][1]="MP";
		
		return objArr;
	}

}
