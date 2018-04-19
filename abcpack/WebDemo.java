package abcpack;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDemo {
	WebDriver d;
	@Before
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.gecko.driver","E:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	@Test
	public void testWeb() throws Exception
	{
		// Load web page
		d.get("https://www.facebook.com/");
		// Verify page title
		assertEquals("Facebook – log in or sign up",d.getTitle());
		//System.out.println(d.getTitle());
		// Enter user name
		assertTrue(d.findElement(By.id("email")).isDisplayed());
		d.findElement(By.id("email")).clear();
		d.findElement(By.id("email")).sendKeys("Selenium");
		// Enter password
		d.findElement(By.id("pass")).sendKeys("Selenium");
		// Click on Login
		d.findElement(By.id("loginbutton")).click();
		// Pause 4sec
		Thread.sleep(4000);
	}
	@After
	public void tearDown()
	{
		// Close browser
		d.quit();
	}

}
