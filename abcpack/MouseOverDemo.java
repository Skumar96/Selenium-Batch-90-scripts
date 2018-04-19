package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseOverDemo {
	WebDriver d;
	@Test
	public void testMoueOver() throws Exception
	{
		// Load web page
		d.get("https://www.aptransport.in/tgcfstonline/");
		// Verify page title
		assertEquals("Welcome To TRANSPORT DEPARTMENT GOVERNMENT OF TELANGANA - INDIA",d.getTitle());
		
		Actions a=new Actions(d);
		a.moveToElement(d.findElement(By.linkText("DEALER"))).pause(2000).click(d.findElement(By.linkText("Dealer New Registration"))).build().perform();
		/*a.moveToElement(d.findElement(By.linkText("DEALER"))).perform();
		Thread.sleep(2000);
		// Click on Dealer New Registration
		d.findElement(By.linkText("Dealer New Registration")).click();*/
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
