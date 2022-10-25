package com_crm_generic_utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerimplementationClass implements ITestListener 
{
	public void onTestFailure(ITestResult result)
	{
		String testname = result.getMethod().getMethodName();
		System.out.println(testname+"=====execute and i am listening===");
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sDriver);
		File srcfile = edriver.getScreenshotAs(OutputType.FILE);
		try
		{
			File desfile = new File("./tyss_selenium_rmg42/screenshot/"+testname+".png");
			FileUtils.copyFile(srcfile, desfile);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
	}
	public void onTestSkipped(ITestResult resullt)
	{
		
	}
}
