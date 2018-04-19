package abcpack;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

/*import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;*/
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginResults {
	WebDriver d;
	XSSFWorkbook wb;
	XSSFSheet s;
	XSSFCell cell;
	XSSFRow r;
	@Test
	public void testLogin() throws Exception
	{
		// Load web page
		d.get("https://demo.cyclos.org/");
		// Verify page title
		assertTrue(d.getTitle().contains("Cyclos4 Communities"));
		// Read data from excel
		FileInputStream fis=new FileInputStream("E:\\Selenium_Scripts_Mar18\\TestData\\Login.xlsx");
		wb=new XSSFWorkbook(fis);
		s=wb.getSheetAt(0);
		for(int i=1;i<s.getLastRowNum()+1;i++)
		{
			// Click on Sign in
			d.findElement(By.linkText("Sign in")).click();
			Thread.sleep(2000);
			// Enter user name
			d.findElement(By.cssSelector("input.inputField.medium")).clear();
			d.findElement(By.cssSelector("input.inputField.medium")).sendKeys(s.getRow(i).getCell(0).getStringCellValue());
			String uname=d.findElement(By.cssSelector("input.inputField.medium")).getAttribute("value");
			// Enter password
			d.findElement(By.xpath("//input[@type='password']")).clear();
			d.findElement(By.xpath("//input[@type='password']")).sendKeys(s.getRow(i).getCell(1).getStringCellValue());
			String password=d.findElement(By.xpath("//input[@type='password']")).getAttribute("value");
			// Click on Sign in button
			d.findElement(By.cssSelector("button.actionButton")).click();
			Thread.sleep(2000);
			// Blank user name & Blank password
			if(uname.equals("") && password.equals(""))
			{
				//assertEquals("The action couldn't be processed, as there were validation errors:\nLogin name is required\nPassword is required",d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText());
				assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText().contains("Login name is required\nPassword is required"));
				setCellData("E:\\Selenium_Scripts_Mar18\\TestData\\Login.xlsx","Fail",i,2);
			}
			// Blank user name & Valid/invalid password
			else if(uname.equals("") && !(password.equals("")))
			{
				assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText().contains("Login name is required"));
				setCellData("E:\\Selenium_Scripts_Mar18\\TestData\\Login.xlsx","Fail",i,2);
			}
			// Blank password & Valid/invalid user name
			else if(!(uname.equals("")) && password.equals(""))
			{
				assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText().contains("Password is required"));
				setCellData("E:\\Selenium_Scripts_Mar18\\TestData\\Login.xlsx","Fail",i,2);
			}
			// Valid user name & valid password
			else if(isElementPresent(d,By.linkText("Logout")))
			{
				// Click on Logout
				d.findElement(By.linkText("Logout")).click();
				setCellData("E:\\Selenium_Scripts_Mar18\\TestData\\Login.xlsx","Pass",i,2);
			}
			// Invalid user name & invalid password
			else
			{
				assertTrue(d.findElement(By.cssSelector("div.notificationText.notificationText-singleLine")).getText().contains("The given name / password are incorrect"));
				setCellData("E:\\Selenium_Scripts_Mar18\\TestData\\Login.xlsx","Fail",i,2);
			}
			Thread.sleep(2000);
		}
				
		wb.close();		
		Thread.sleep(2000);
	}
	
	public void setCellData(String path,String result,int rownum,int colnum) throws Exception
	{
		r=s.getRow(rownum);
		cell=r.getCell(colnum);
		if(cell==null)
		{
			cell=r.createCell(colnum);
			cell.setCellValue(result);
		}
		else
		{
			cell.setCellValue(result);
		}
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
		fos.close();
	}
	public String getCellData(int rownum,int colnum)
	{
		return s.getRow(rownum).getCell(colnum).getStringCellValue();
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
