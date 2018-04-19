package abcpack;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataImport_POI {
	WebDriver d;
	@Test
	public void testDataImport() throws Exception
	{
		// Load web page
		d.get("https://www.google.co.in");
		// Verify page title
		assertEquals("Google",d.getTitle());
		// Read data from excel
		FileInputStream fis=new FileInputStream("E:\\Selenium_Scripts_Mar18\\TestData\\Google.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet s=wb.getSheetAt(0);
		for(int i=0;i<s.getLastRowNum()+1;i++)
		{
			d.findElement(By.id("lst-ib")).clear();
			d.findElement(By.id("lst-ib")).sendKeys(s.getRow(i).getCell(0).getStringCellValue());
			Thread.sleep(1000);
		}
		wb.close();
		Thread.sleep(3000);
	}
	@BeforeMethod
	public void setUp() throws Exception 
	{
		System.setProperty("webdriver.gecko.driver","E:\\Driver Server\\geckodriver.exe");
	    //d = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		d = new ChromeDriver();
		System.setProperty("webdriver.ie.driver", "E:\\Driver Server\\IEDriverServer.exe");
		//d = new InternetExplorerDriver();
	   
	    d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	    d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
	    d.manage().deleteAllCookies();
	    //d.manage().window().maximize();
	 }
	@AfterMethod
	public void tearDown()
	{
		// Close browser
		d.quit();
	}

}
