package com_crm_generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.object_repositories.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver=null;
	public static WebDriver sDriver;

	@BeforeSuite
	public void bs()
	{
		System.out.println("database connection");
	}
	@BeforeTest
	public void bt()
	{
		System.out.println("execute in parallel mode");
	}
	@BeforeClass
	public void bc() throws Throwable
	{
		File_utility flib = new File_utility();
		
		String BROWSER = flib.getPropertyKeyValue("browser");
//		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();	
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();	
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		System.out.println("launching the browser");
		
		sDriver=driver;
	}
	@BeforeMethod
	public void bm() throws Throwable
	{
		File_utility flib = new File_utility();
		String URL = flib.getPropertyKeyValue("url");
		String username = flib.getPropertyKeyValue("un");
		String password = flib.getPropertyKeyValue("pw");
		driver.get(URL);
		Loginpage pom = new Loginpage(driver);
		pom.login(username, password);
		
		System.out.println("login to application");
	}
	@AfterMethod
	public void am()
	{
		System.out.println("logout the application");
	}
	@AfterClass
	public void ac()
	{
		System.out.println("close the browser");
	}
	@AfterTest
	public void at()
	{
		System.out.println("executed successfully");
	}
	@AfterSuite
	public void as()
	{
		System.out.println("database close");
	}
}
