package abcpack;

import java.util.List;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DDDemo {
	WebDriver d;
	@Before
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
		d=new ChromeDriver();
	}
	@Test
	public void testDD() throws Exception
	{
		// Load web page
		d.get("https://www.facebook.com/");
		// Select Apr option
		Select dd=new Select(d.findElement(By.id("month")));
		dd.selectByIndex(4);
		System.out.println("Selected option is:"+dd.getFirstSelectedOption().getText());
		List<WebElement> op1=dd.getOptions();
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
