package abcpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class MultiFrame {
	WebDriver d;
	@Test
	public void testFrame() throws Exception
	{
		// Load web page
		d.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
		// Switch driver focus to 1st frame
		d.switchTo().frame(0);
		d.findElement(By.linkText("com.thoughtworks.selenium")).click();
		Thread.sleep(1000);
		// Switch driver focus outside frame
		d.switchTo().defaultContent();
		// Switch driver focus to 2nd frame
	    d.switchTo().frame(1);
	    d.findElement(By.linkText("Selenium")).click();
	    Thread.sleep(1000);
	    // Switch driver focus outside frame
	 	d.switchTo().defaultContent();
	    // Switch driver focus to 3rd frame
	    d.switchTo().frame(2);
	    d.findElement(By.linkText("DefaultSelenium")).click();
	    Thread.sleep(4000);
	    
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
