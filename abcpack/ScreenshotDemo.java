package abcpack;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenshotDemo {
	WebDriver d;
	@Test
	public void testScreenshot() throws Exception
	{
		//Load web page
		d.get("https://www.google.co.in");
		assertEquals("Google",d.getTitle());
		d.findElement(By.linkText("Gmail")).click();
		Thread.sleep(2000);
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date();
		
		File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("E:\\Selenium_Scripts_Mar18\\Results\\"+dateFormat.format(dt)+".png"));
		//FileUtils.copyFile(screenshotFile, new File("E:\\Selenium_Scripts_Mar18\\Results\\Page1.png"));
		Thread.sleep(2000);
	}
	@Before
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		//d=new ChromeDriver();
		System.setProperty("webdriver.gecko.driver","E:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		//Maximize
		//d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		//d.manage().timeouts().pageLoadTimeout(2,TimeUnit.MINUTES);
	}
	@After
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
