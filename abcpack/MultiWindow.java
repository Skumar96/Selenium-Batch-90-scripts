package abcpack;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiWindow {
	WebDriver d;
	@Test
	public void testMultiWindow() throws Exception
	{
		// Load web page
		d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		// Verify page title
		assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
		// Click on Flights
		d.findElement(By.linkText("Flights")).click();
		Thread.sleep(8000);
		ArrayList<String> al=new ArrayList<String>(d.getWindowHandles());
		// Switch driver focus IRCTC to Flights
		d.switchTo().window(al.get(1));
		assertTrue(d.findElement(By.className("flights")).isDisplayed());
		Thread.sleep(4000);
		// Switch driver focus to IRCTC
		d.switchTo().window(al.get(0));
		assertTrue(d.findElement(By.id("usernameId")).isDisplayed());
		Thread.sleep(4000);
		
		/*Set<String> h=d.getWindowHandles();
		System.out.println("********* Handles are *********");
		for(String s:h)
		{
			System.out.println(s);
		}*/
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
