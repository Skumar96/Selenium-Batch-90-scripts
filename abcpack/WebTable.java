package abcpack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebTable {
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
	}
	@AfterMethod
	public void tearDown()
	{
		// Close browser
		d.quit();
	}
	@Test
	public void dynamicTable()throws Exception
	{
		d.get("http://aponline.gov.in/apportal/contact/sec_select.asp?sid=1");
		assertEquals(":: Government Orders ::",d.getTitle());
		Select s=new Select(d.findElement(By.id("Select1")));
		s.selectByIndex(4);
		
		List<WebElement> tr_collection=d.findElements(By.xpath("//table[@id='Table9']/tbody/tr"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
		List<WebElement> td_collection1=d.findElements(By.xpath("//table[@id='Table9']/tbody/tr/td"));
		System.out.println("NUMBER OF Columns IN THIS TABLE = "+td_collection1.size()/tr_collection.size());
		
		int row_num,col_num;
        row_num=1;
        for(WebElement trElement : tr_collection)
        {
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            //System.out.println("NUMBER OF COLUMNS="+row_num+" "+td_collection.size());
            col_num=1;
            for(WebElement tdElement : td_collection)
            {
               	//System.out.println("Row # "+row_num+", Col # "+col_num  + ", Text=" +tdElement.getText());
                if(tdElement.getText().contains("Sai Prasad"))
                {
                	System.out.println("Name Found");
                	break;
                }
               	col_num++;
            }
            row_num++;
            
        }
        Thread.sleep(4000);
	}
	
	

}
