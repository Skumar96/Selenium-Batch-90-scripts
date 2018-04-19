package abcpack;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class FBLogin {
  private WebDriver d;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver","E:\\Driver Server\\geckodriver.exe");
    d = new FirefoxDriver();
	System.setProperty("webdriver.chrome.driver", "E:\\Driver Server\\chromedriver.exe");
	//d = new ChromeDriver();
	System.setProperty("webdriver.ie.driver", "E:\\Driver Server\\IEDriverServer.exe");
	//d = new InternetExplorerDriver();
    baseUrl = "https://www.facebook.com/";
    d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled2() throws Exception {
    d.get(baseUrl + "/");
    assertEquals("Facebook – log in or sign up", d.getTitle());
    d.findElement(By.id("email")).clear();
    d.findElement(By.id("email")).sendKeys("selenium");
    d.findElement(By.id("pass")).clear();
    d.findElement(By.id("pass")).sendKeys("selenium");
    d.findElement(By.xpath("//label[@id='loginbutton']/input")).click();
    Thread.sleep(4000);
  }

  @After
  public void tearDown() throws Exception {
    d.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      d.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      d.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = d.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

