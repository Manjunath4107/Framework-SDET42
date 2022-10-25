package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTest 
{
	@Test(dataProvider = "dataprovider_test")
	public void createContact(String name,String email,String mobile)
	{
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobile);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		driver.quit();
		
		System.out.println(" contact saved " + name + " " + email + " " + mobile);
	}
	@DataProvider
	public Object[][] dataprovider_test()
	{
		Object[][] objarr = new Object[3][3];
		
		objarr[0][0]="shoba";
		objarr[0][1]="shoba@gmail.com";
		objarr[0][2]="1234567890";
		
		
		objarr[1][0]="shoba1";
		objarr[1][1]="shoba1@gmail.com";
		objarr[1][2]="1234567891";
		
		objarr[2][0]="shoba2";
		objarr[2][1]="shoba2@gmail.com";
		objarr[2][2]="1234567892";
	
		return objarr;
		
	}
	
}
