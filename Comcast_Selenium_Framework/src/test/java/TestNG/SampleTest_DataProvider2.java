package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest_DataProvider2 
{
	@Test(dataProvider="dataProvider_bookTicketTest")
	public void bookTicket(String src,String dst,int ticket)
	{
		System.out.println("Execute source => "+src+", Destination => "+dst);
	}
	
	@DataProvider
	public Object[][] dataProvider_bookTicketTest()
	{
		Object[][] objArr=new Object[5][3];
		objArr[0][0]="Banglore";
		objArr[0][1]="Goa";
		objArr[0][2]=10;
		
		objArr[1][0]="Banglore";
		objArr[1][1]="Mysore";
		objArr[1][2]=10;
		
		objArr[2][0]="Banglore";
		objArr[2][1]="Managlore";
		objArr[2][2]=20;
		
		objArr[3][0]="Banglore";
		objArr[3][1]="Hyd";
		objArr[3][2]=50;
		
		objArr[4][0]="Banglore";
		objArr[4][1]="MP";
		objArr[4][2]=10;
		
		return objArr;
	}


}
