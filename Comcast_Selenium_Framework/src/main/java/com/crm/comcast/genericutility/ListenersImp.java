package com.crm.comcast.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImp implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result)
	{
		//@Test
	    test = report.createTest( result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS,result.getMethod().getMethodName()+" is passed");
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		test.generateLog(Status.SKIP,result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP,result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{


	}

	public void onTestFailedWithTimeout(ITestResult result) {


	}

	public void onStart(ITestContext context)
	{
       //@BeforeSuite
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentreport.html");
		spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("vtiger automation");
        spark.config().setReportName("Execution Report");
        
        report=new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("OS","Windows");
        report.setSystemInfo("Platform","Windows 10");
        report.setSystemInfo("Reporter","Shiva");
	}

	public void onFinish(ITestContext context)
	{ 
	   //@AfterSuite
		report.flush();

	}

	public void onTestFailure(ITestResult result)
	{
		String failedTestName = result.getMethod().getMethodName();
		
		//Take ScreenShot and Store it in File Variable
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseAnnoationClass.sDriver);
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		String systemDateAndTime = new Date().toString().replace(":", "_").replace(" ", "_");
		
		//Copy the ScreenShot in Local Driver
	    File dstFile = new File("./ScreenShot/"+failedTestName+ "_" +systemDateAndTime+".png");
		
		try
		{
			
			FileUtils.copyFile(srcFile,dstFile);
		}
		catch(IOException e)
		{
			System.out.println("Handle Exception");
		}
		
		test.generateLog(Status.FAIL,result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL,result.getThrowable());
		test.addScreenCaptureFromPath(dstFile.getAbsolutePath());
	}

}
