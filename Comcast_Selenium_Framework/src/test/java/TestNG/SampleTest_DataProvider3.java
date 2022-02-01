package TestNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.ExcelUtility;

public class SampleTest_DataProvider3
{
	@Test(dataProvider="dp_addTocartAndBill")
	public void addToCartTest(String pName,String qty)
	{
		System.out.println("Execute "+pName+" add to cart and bill ");
	}
	
	@DataProvider
	public Object[][] dp_addTocartAndBill() throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		int rowCount = eLib.getRowCount("addToCart");
		Object[][] objArr=new Object[rowCount][2];
		for(int i=0;i<rowCount;i++)
		{
			objArr[i][0]=eLib.getDataFromExcel("addToCart",i,0);
			objArr[i][1]=eLib.getDataFromExcel("addToCart",i,1);
		}
		return objArr;
	}

}
