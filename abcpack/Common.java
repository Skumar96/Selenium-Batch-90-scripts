package abcpack;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


public class Common {
	WebDriver d;
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) throws Exception 
	{
		if(browser.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver","E:\\Driver Server\\geckodriver.exe");
		    //d = new FirefoxDriver();
			//new ChromeOptions()
			d=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.firefox());
		}
		else if(browser.equals("GC"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
			//d = new ChromeDriver();
			d=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),new ChromeOptions());
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "E:\\Driver Server\\IEDriverServer.exe");
			//d = new InternetExplorerDriver();
			d=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.internetExplorer());
		}
			
	   
	    d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
	 }
	@AfterMethod
	public void tearDown()
	{
		// Close browser
		d.quit();
	}

}
