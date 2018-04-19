package abcpack;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		// Load web page
		d.get("https://demo.cyclos.org/");
		// Verify page title
		assertTrue(d.getTitle().contains("Cyclos4 Communities"));
		// Click on Sign in
		d.findElement(By.linkText("Sign in")).click();
		Thread.sleep(2000);
		// Enter user name
		d.findElement(By.cssSelector("input.inputField.medium")).clear();
		d.findElement(By.cssSelector("input.inputField.medium")).sendKeys("demozdfsd");
		String uname=d.findElement(By.cssSelector("input.inputField.medium")).getAttribute("value");
		// Enter password
		d.findElement(By.xpath("//input[@type='password']")).clear();
		d.findElement(By.xpath("//input[@type='password']")).sendKeys("sdfsdfdf");
		String password=d.findElement(By.xpath("//input[@type='password']")).getAttribute("value");
		// Click on Sign in button
		d.findElement(By.cssSelector("button.actionButton")).click();
		Thread.sleep(2000);
		// Blank user name & Blank password
		if(uname.equals("") && password.equals(""))
		{
			//assertEquals("The action couldn't be processed, as there were validation errors:\nLogin name is required\nPassword is required",d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText());
			assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText().contains("Login name is required\nPassword is required"));
		}
		// Blank user name & Valid/invalid password
		else if(uname.equals("") && !(password.equals("")))
		{
			assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText().contains("Login name is required"));
		}
		// Blank password & Valid/invalid user name
		else if(!(uname.equals("")) && password.equals(""))
		{
			assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText().contains("Password is required"));
		}
		// Valid user name & valid password
		else if(isElementPresent(d,By.linkText("Logout")))
		{
			// Click on Logout
			d.findElement(By.linkText("Logout")).click();
		}
		// Invalid user name & invalid password
		else
		{
			assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText().contains("The given name / password are incorrect"));
		}
		
		Thread.sleep(2000);
	}
	
	private boolean isElementPresent(WebDriver driver,By by) 
	{
	    driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
		try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
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
