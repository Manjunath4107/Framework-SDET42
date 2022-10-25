package com_crm_generic_utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_utility {

	/*
	 * wait for page to load before identifying any synchronization in DOM
	 *  
	 */

	public void waitforPagetoLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	/*
	 * used to place mouse cursor on specified element
	 * param driver
	 * param element
	 * author manjunath 
	 */
	public void mouseOveronElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

	}
	/*
	 * after every action it will wait for next action to perform
	 */
	public void setscriptTimeout(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	/*
	 * used to wait for element to be clickable in GUI and check for specific element for every 500 milliseconds
	 */
	public void waitforElementWithCustomTimeout(WebDriver driver,WebElement element,int pollingTiime)
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/*
	 * used to switch to any window based on window title
	 * param driver
	 * param PartialWindowTitle
	 * author manjunath
	 */
	public void switchtoWindow(WebDriver driver,String partialWindowtTitle)
	{
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> it = allid.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(partialWindowtTitle))
			{
				break;
			}
		}
	}
	/**
	 * used to Switch to Alert Window & click on OK button
	 * @param driver
	 */
	public void swithToAlertWindowAndAccpect(WebDriver driver ,String expectedMsg) {
		
		Alert alt = driver.switchTo().alert();
		if(alt.getText().trim().equalsIgnoreCase(expectedMsg.trim()))
		{
			System.out.println("Alert Message is verified");
		}
		else 
		{
			System.out.println("Alert Message is not verified");
		}
		alt.accept();
	}
	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * @param driver
	 */
		public void swithToAlertWindowAndCancel(WebDriver driver, String expectedMsg) 
		{
			Alert alt = driver.switchTo().alert();
			if(alt.getText().equals(expectedMsg)) 
			{
			 System.out.println("Alert Message is verified");
			}
			else 
			{
			 System.out.println("Alert Message is not verified");
			}
				alt.dismiss();
	}
		/**
		 * used to Switch to Frame Window based on index
		 * @param driver
		 * @param index
		 */
		public void switchToFrame(WebDriver driver , int index) 
		{
			driver.switchTo().frame(index);
		}

		/**
		 * used to Switch to Frame Window based on id or name attribute
		 * @param driver
		 * @param id_name_attribute
		 */
		public void switchToFrame(WebDriver driver , String id_name_attribute)
		{
			driver.switchTo().frame(id_name_attribute);
		}
		/**
		 * used to select the value from the dropDwon  based on index
		 * @param driver
		 * @param index
		 */
		public void select(WebElement element , int index) 
		{
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}
		/**
		 * used to select the value from the dropDwon  based on value / option avlaible in GUI
		 * @param element
		 * @param value
		 */
		public void select(WebElement element , String text)
		{
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}
		/**
		 * 	 used to right click  on specified element

		 * @param driver
		 * @param elemnet
		 */
		
		public void rightClickOnElement(WebDriver driver , WebElement elemnet)
		{
			Actions act = new Actions(driver);
			act.contextClick(elemnet).perform();
		}
		/**
		 * 
		 * @param driver
		 * @param javaScript
		 */
		public void executeJavaScript(WebDriver driver , String javaScript)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeAsyncScript(javaScript, null);
		}
		   public void waitAndClick(WebElement element) throws InterruptedException
		   {
			   int count = 0;
		       while(count<20) 
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
		     * pass enter Key appertain in to Browser
		     * @param driver
		     */
		   public void passEnterKey(WebDriver driver)
		   {
			   Actions act = new Actions(driver);
			   act.sendKeys(Keys.ENTER).perform();
		   } 


}
