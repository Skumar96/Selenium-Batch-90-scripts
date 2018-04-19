package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserSlider {
	WebDriver d;
	@Test
	public void testBrowserSlider() throws Exception
	{
		//Load web page
		d.get("http://www.seleniumhq.org/download/");
		assertEquals("Downloads",d.getTitle());
		for(int i=0;i<10;i++)
		{
			((RemoteWebDriver) d).executeScript("window.scrollBy(0,400)");
			Thread.sleep(1000);
		}
				
	}
	//for(int i=0;isElementPresent(d, By.linkText("Privacy");i++)
	public boolean isElementPresent(WebDriver driver, By b)
	{
		try
		{
			driver.findElement(b);
			return false;
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
			    
	}
	@BeforeMethod
	public void setUp()
	{
		//Launch browser
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
	    //d =new ChromeDriver();
		//Maximize browser
		//d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}


}
