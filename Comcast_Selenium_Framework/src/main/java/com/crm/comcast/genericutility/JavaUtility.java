package com.crm.comcast.genericutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;
/**
 * This class contains java specific generic libraries
 * @author Shiv
 *
 */
public class JavaUtility 
{
	/**
	 * This method will generate a random number and return it to the caller
	 * @return
	 */
	public int getRainDomNumber()
	{
		Random ranDom=new Random();
		int ranDomNum = ranDom.nextInt(10000);
		return ranDomNum;
		
	}
	/**
	 * This methodwill return the current date
	 * @return
	 */
	public String getSystemDate()
	{
		Date date=new Date();
		String currentDate = date.toString();
		return currentDate;
		
	}
	/**
	 * This method will return date in specific formate
	 */
	public String getFinalDateFormate()
	{
		Date date=new Date();
		String systemDateAndTime = date.toString();
		System.out.println(systemDateAndTime);
		String[] arr = systemDateAndTime.split(" ");
		String YYYY = arr[5];
		String DD = arr[2];
		int MM = date.getMonth()+1;
		String finalFormat = YYYY+"-"+MM+"-"+DD;
		return finalFormat;
	}
	
	/**
	 * This method is used to pass Virtual Key to OS
	 * @throws AWTException
	 */
	public void pressVurtualEnterKey() throws AWTException
	{
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}

}
