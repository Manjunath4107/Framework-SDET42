package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com_crm_generic_utilities.Excel_utility;
import com_crm_generic_utilities.File_utility;
import com_crm_generic_utilities.Java_utility;
import com_crm_generic_utilities.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Createproduct {

	public static void main(String[] args) throws Throwable {
		
		Webdriver_utility wlib = new Webdriver_utility();
		Java_utility jlib = new Java_utility();
		File_utility flib = new File_utility();
		Excel_utility elib = new Excel_utility();
		
//		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String BROWSER = flib.getPropertyKeyValue("browser");
		WebDriver driver;
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
		
		wlib.waitforPagetoLoad(driver);
		
		String URL = flib.getPropertyKeyValue("url");
		
		String username = flib.getPropertyKeyValue("un");
		String password = flib.getPropertyKeyValue("pw");
		
//		FileInputStream fis=new FileInputStream("./common_data.properties");
//		Properties pro = new Properties();
//		pro.load(fis);
		
//		String URL = pro.getProperty("url");
//		String username = pro.getProperty("un");
//		String password = pro.getProperty("pw");
		
		driver.get(URL);
		
		int rannum = jlib.getRandomNum();
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
//		Random ran = new Random();
//		int rannum = ran.nextInt(1000);
		
		String data = elib.getDataFromExcel("product", 0, 0)+rannum;
		
//		FileInputStream fis1=new FileInputStream("Book1.xlsx");
//		Workbook book=WorkbookFactory.create(fis1);
//		Sheet she = book.getSheet("product");
//		Row row = she.getRow(0);
//		Cell cel = row.getCell(0);
//		String value = cel.getStringCellValue()+rannum;
		
		driver.findElement(By.xpath("//a[.='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(data);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String prodname = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
		if(prodname.contains(data))
		{
			System.out.println("verified");
		}
		else
		{
			System.out.println("not verified");
		}
		
		WebElement ele = driver.findElement(By.xpath("(//img[@src='themes/softed/images/user.PNG'])"));
		wlib.mouseOveronElement(driver, ele);
		
//		Actions act=new Actions(driver);
//		act.moveToElement(driver.findElement(By.xpath("(//img[@src='themes/softed/images/user.PNG'])"))).perform();
		
		driver.findElement(By.xpath("(//a[.='Sign Out'])")).click();
		driver.quit();


	}

}
