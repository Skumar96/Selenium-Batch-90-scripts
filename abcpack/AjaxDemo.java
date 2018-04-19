package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class AjaxDemo {
	WebDriver d;
	@Test
	public void testAjax() throws Exception
	{
		// Load web page
		d.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
		// Verify page title
		assertEquals("Bank IFSC Codes, MICR Codes: Find IFSC, MICR Codes for Major Banks in India",d.getTitle());
		// Select bank
		selectOption(d.findElement(By.id("selBank")),"Axis Bank");
		selectOption(d.findElement(By.id("selState")),"Andhra Pradesh");
		selectOption(d.findElement(By.id("selCity")),"Hyderabad");
		selectOption(d.findElement(By.id("selBranch")),"Madhapur");
		
		Thread.sleep(4000);
	}
	public void selectOption(WebElement locator,String optionname)
	{
		Select dd=new Select(locator);
		dd.selectByVisibleText(optionname);
	}
	@BeforeMethod
	public void setUp() throws Exception 
	{
		System.setProperty("webdriver.gecko.driver","E:\\Driver Server\\geckodriver.exe");
	    d = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		//d = new ChromeDriver();
		System.setProperty("webdriver.ie.driver", "E:\\Driver Server\\IEDriverServer.exe");
		//d = new InternetExplorerDriver();
	   
	    d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	    d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
	 }
	@AfterMethod
	public void tearDown()
	{
		// Close browser
		d.quit();
	}

}
