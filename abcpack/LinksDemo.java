package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksDemo extends Common
{
	@Test
	public void testLinks() throws Exception
	{
		// Load web page
		d.get("https://www.seleniumhq.org/");
		// Verify page title
		assertEquals("Selenium - Web Browser Automation",d.getTitle());
		List<WebElement> l=d.findElements(By.xpath("//li[starts-with(@id,'menu')]"));
		System.out.println("No of links:"+l.size());
		String links[]=new String[l.size()];
		int i=0;
		for(WebElement e:l)
		{
			//System.out.println(e.getText());
			links[i]=e.getText();
			i++;
		}
		for(String s:links)
		{
			d.findElement(By.linkText(s)).click();
			if(d.getTitle().contains("404") || d.getTitle().contains("500"))
			{
				System.out.println("Link:"+s+"---> is not working");
			}
			else
			{
				System.out.println("Link:"+s+"---> is working fine");
			}
		}
		Thread.sleep(2000);
	}
	

}
