package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class AlertDemo extends Common
{
	@Test
	public void testAlert() throws Exception
	{
		// Load web page
		d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		// Verify page title
		assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
		// Click on Login
		d.findElement(By.id("loginbutton")).click();
		// Switch driver focus to alert
		Alert al=d.switchTo().alert();
		// Verify alert text
		assertEquals("Enter User ID", al.getText());
		//ok
		al.accept();
		// Enter user name
		d.findElement(By.id("usernameId")).sendKeys("selenium");
		// Click on Login
		d.findElement(By.id("loginbutton")).click();
		// ok
		al.accept();
		// Enter password
		d.findElement(By.name("j_password")).sendKeys("Selenium");
		Thread.sleep(4000);
		
	}
	
}
