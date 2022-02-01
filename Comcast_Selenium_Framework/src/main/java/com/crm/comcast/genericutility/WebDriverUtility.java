package com.crm.comcast.genericutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;

/**
 * This class contains generic method for all webdriver actions
 * @author Shiv
 *
 */
public class WebDriverUtility 
{
	/**
	 * This method used to maximize windows
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This is the implicit wait for page to load
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 *  This is the explicit wait for element to load
	 * @param driver
	 * @param element
	 */
	public void waitForElementToVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 *  This is the explicit wait for element to load and clickable in GUI,
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method wait for the element to be clicked,its custom wait create to avoid element inter aceptable exception
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<2000)
		{
			try
			{
				element.click();
				break;
			}
			catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * This method enables user to handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void selectoption(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method enables user to handle dropdown using value
	 * @param element
	 * @param value
	 */
	public void selectOption(String value,WebElement element )
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method enables user to handle dropdown using visibleText
	 * @param element
	 * @param text
	 */
	public void selectOption(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform right click operation
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform double click operation
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform drag and drop operation
	 * @param driver
	 * @param source
	 * @param destination
	 */
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement destination)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(source, destination).perform();
	}
	/**
	 * pass enter key appertain in to Browser
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method helps to switch from one window to another
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String winid = it.next();
			String title = driver.switchTo().window(winid).getTitle();
			if(title.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	/**
	 * This method used to alert popup OK
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method used to alert popup to Cancel 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method used for scrolling action in a webpage
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
	}
	/**
	 * This method is used to take the screenshot of the defect testscripts
	 * @param driver
	 * @param screenshotName
	 * @throws IOException
	 */
	public void takeScreenshot(WebDriver driver,String screenshotName) throws IOException
	{
	    TakesScreenshot ts=(TakesScreenshot) driver;
	    File scr = ts.getScreenshotAs(OutputType.FILE);
	    File dest=new File("./screenshot/sc.png");
	    Files.copy(scr, dest);
	}
	/**
	 * This method used to switch to child windows by using index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method used to switch to frame using webelement
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method used to switch to frame using id or name
	 * @param driver
	 * @param idOrName
	 */
	public void switchFrame(WebDriver driver,String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	
}
