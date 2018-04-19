package abcpack;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenshotStepwise {
	WebDriver d;
	@Test
	public void testScreenshot() throws Exception
	{
		// Load web page
		d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		// Verify page title
		assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
		Thread.sleep(1000);
		getScreenshot();
		// Click on Login
		d.findElement(By.id("loginbutton")).click();
		Thread.sleep(2000);
		getScreenshot();
		// Switch driver focus to alert
		Alert al=d.switchTo().alert();
		// Verify alert text
		assertEquals("Enter User ID", al.getText());
		//ok
		al.accept();
		Thread.sleep(1000);
		getScreenshot();
		// Enter user name
		d.findElement(By.id("usernameId")).sendKeys("selenium");
		Thread.sleep(1000);
		getScreenshot();
		// Click on Login
		d.findElement(By.id("loginbutton")).click();
		Thread.sleep(2000);
		getScreenshot();
		// ok
		al.accept();
		// Enter password
		d.findElement(By.name("j_password")).sendKeys("Selenium");
		Thread.sleep(1000);
		getScreenshot();
		Thread.sleep(4000);
		
	}
	public void getScreenshot() throws Exception
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date();
		File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("E:\\Selenium_Scripts_Mar18\\Results\\"+dateFormat.format(dt)+".png"));
	}
	public void selectOption(WebElement locator,String optionname)
	{
		Select dd=new Select(locator);
		dd.selectByVisibleText(optionname);
	}
	@Before
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
	@After
	public void tearDown()
	{
		// Close browser
		d.quit();
	}

}
