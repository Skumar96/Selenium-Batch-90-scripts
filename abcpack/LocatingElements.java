package abcpack;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatingElements {
  private WebDriver d;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver","E:\\Driver Server\\geckodriver.exe");
    d = new FirefoxDriver();
    baseUrl = "https://www.google.co.in/";
    d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    d.get(baseUrl);
    assertEquals("Google", d.getTitle());
    d.findElement(By.id("lst-ib")).clear();
    //ID
    //d.findElement(By.id("lst-ib")).sendKeys("selenium");
    // Name
    //d.findElement(By.name("q")).sendKeys("Appium");
    // Class Name
    //d.findElement(By.className("gsfi")).sendKeys("Cumcumber");
    // Link Text
    //d.findElement(By.linkText("Gmail")).click();
    // Partial Link Text
    //d.findElement(By.partialLinkText("in")).click();
    // Xpath
    //d.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
    // Tag Name
    //System.out.println("No of links:"+d.findElements(By.tagName("a")).size());
    //CSS
    d.findElement(By.cssSelector("a.gb_P")).click();
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


