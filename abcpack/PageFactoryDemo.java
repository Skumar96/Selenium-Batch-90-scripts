package abcpack;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageFactoryDemo {
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		// Load web page
		d.get("https://demo.cyclos.org/");
		// Verify page title
		assertTrue(d.getTitle().contains("Cyclos4 Communities"));
		
		OR page=new OR(d);
		page.fillLogin("demo","1234");
		
		/*//Click on Sign in link
		page.lnksignin.click();
		Thread.sleep(2000);
		// Enter user name
		page.txtuname.sendKeys("demo");
		// Enter password
		page.txtpassword.sendKeys("1234");
		// Click on Sign In
		page.btnsignin.click();*/
		Thread.sleep(2000);
		page.lnklogout.click();
		Thread.sleep(4000);
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
