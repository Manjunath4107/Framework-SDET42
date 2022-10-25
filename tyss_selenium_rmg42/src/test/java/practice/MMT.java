package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MMT {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		FileInputStream fis=new FileInputStream("./common_data.properties");
		Properties pro = new Properties();
		pro.load(fis);

		String URL = pro.getProperty("url1");
		driver.get(URL);
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		//from
		String from = "Bengaluru, India";
		WebElement start = driver.findElement(By.xpath("//label[@for='fromCity']"));
		start.sendKeys("'"+from+"'");
		driver.findElement(By.xpath("//p[text()='"+from+"']")).click();
		
		//to
		String to= "Bidar, India";
		WebElement end = driver.findElement(By.xpath("//label[@for='toCity']"));
		end.sendKeys("'"+to+"'");
		driver.findElement(By.xpath("//p[text()='"+to+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

		String month = "September 2022";
		String date = "30";
		
		//dynamic xpath
		WebElement dep = driver.findElement(By.xpath("//div[text()='"+month+"']" + "/ancestor::div[@class='DayPicker-month']/descendant::p[text()='"+date+"']"));
		dep.click();
	}

}
