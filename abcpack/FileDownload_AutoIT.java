package abcpack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class FileDownload_AutoIT {
	WebDriver d;
	@BeforeMethod
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		//d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
		d.manage().deleteAllCookies();
	}
	@AfterMethod
	public void stop()
	{
		//d.quit();
	}
	@Test
	public void testDownload() throws Exception
	{
		
		d.get("http://seleniumhq.org/download/");
		d.findElement(By.linkText("3.11.0")).click();
		//Thread.sleep(4000);
		
		new ProcessBuilder("E:\\AutoIT Scripts\\FDownload.exe").start(); 
		Thread.sleep(8000);

		
	}

}
