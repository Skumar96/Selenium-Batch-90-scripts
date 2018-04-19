package abcpack;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IFrameDemo {
	WebDriver d;
	@Test
	public void testFrame() throws Exception
	{
		// Load web page
		d.get("https://paytm.com/");
		// Verify page title
		//assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
		d.findElement(By.xpath("//div[text()='Log In/Sign Up']")).click();
		Thread.sleep(2000);
		//Switch driver focus to frame
		d.switchTo().frame(0);
		d.findElement(By.name("username")).sendKeys("appium");
		Thread.sleep(4000);
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
