package abcpack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class FileUpload_AutoIT {
public WebDriver d;

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
@Test
public void testFileupload() throws Exception 
{
	d.get("https://www.sendspace.com/");
	d.findElement(By.id("upload_file")).click();
	Thread.sleep(4000);
	new ProcessBuilder("E:\\AutoIT Scripts\\FileUpload.exe").start(); 
	/*Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@title='Upload file']")).click();*/
	Thread.sleep(5000);
}

@AfterMethod
public void tearDown() throws Exception
{
   d.quit();
}
}
