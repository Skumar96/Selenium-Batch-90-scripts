package abcpack;

import static org.testng.Assert.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Login_MySQL {
	WebDriver d;
	@Test
	public void testLogin()throws Exception
	{
		d.get("https://demo.cyclos.org/#home");
		assertTrue(d.getTitle().contains("Cyclos4 Communities"));
		//d.findElement(By.xpath("//span[text()='Sign in']")).click();
		Thread.sleep(2000);
				
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MySQL","root","password12");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from Login;");
			while (rs.next())
			{											
				d.findElement(By.xpath("//span[text()='Sign in']")).click();
				//Enter user name
				String username = rs.getString("UserName");
				String pwd = rs.getString("Password");
				d.findElement(By.cssSelector("input.inputField.medium")).clear();
				d.findElement(By.cssSelector("input.inputField.medium")).sendKeys(username);
				String uname=d.findElement(By.cssSelector("input.inputField.medium")).getAttribute("value");
				//Enter password
				d.findElement(By.xpath("//input[@type='password']")).clear();
				d.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
				String password=d.findElement(By.xpath("//input[@type='password']")).getAttribute("value");
				//Click Sign In
				d.findElement(By.xpath("//div[text()='Sign in']")).click();
				Thread.sleep(2000);
				//Balnk user name & Blank password
				if(uname.equals("") && password.equals(""))
				{
					assertEquals("The action couldn't be processed, as there were validation errors:\nLogin name is required\nPassword is required",d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText());
					String sql1="UPDATE Login SET STATUS='Fail' WHERE UserName='"+username+"' and Password='"+pwd+"';";
					PreparedStatement st1=con.prepareStatement(sql1);
					st1.executeUpdate();
				}
				//Blank user name & valid/invalid password
				else if(uname.equals("") && !(password.equals("")))
				{
					assertEquals("The action couldn't be processed, as there were validation errors:\nLogin name is required",d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText());
					String sql1="UPDATE Login SET STATUS='Fail' WHERE UserName='"+username+"';";
					PreparedStatement st1=con.prepareStatement(sql1);
					st1.executeUpdate();
				}
				// Blank password & valid/Invalid user name
				else if(!(uname.equals("")) && password.equals(""))
				{
					assertEquals("The action couldn't be processed, as there were validation errors:\nPassword is required",d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText());
					String sql1="UPDATE Login SET STATUS='Fail' WHERE Password='"+pwd+"';";
					PreparedStatement st1=con.prepareStatement(sql1);
					st1.executeUpdate();
				}
				//Valid user name & valid password
				else if(isElementPresent(d,By.xpath("//span[text()='Logout']")))
				{
					d.findElement(By.xpath("//span[text()='Logout']")).click();
					Thread.sleep(2000);
					d.findElement(By.xpath("//span[text()='Sign in']")).click();
					String sql1="UPDATE Login SET STATUS='Pass' WHERE UserName='"+username+"'and Password='"+pwd+"';";
					PreparedStatement st1=con.prepareStatement(sql1);
					st1.executeUpdate();
				}
				//Invalid user name & invalid password
				else
				{
					assertEquals("The given name / password are incorrect. Please, try again.",d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText());
					String sql1="UPDATE Login SET STATUS='Fail' WHERE UserName='"+username+"'and Password='"+pwd+"';";
					PreparedStatement st1=con.prepareStatement(sql1);
					st1.executeUpdate();
				}
				Thread.sleep(2000);
				
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		Thread.sleep(3000);
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

}
