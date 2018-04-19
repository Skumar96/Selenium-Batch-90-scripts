package abcpack;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiDD {

	public static void main(String[] args) throws Exception {
		// Lunch browser
		System.setProperty("webdriver.gecko.driver","E:\\Driver Server\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		// Load web page
		d.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		// Switch driver focus to iframe
		d.switchTo().frame("iframeResult");
		// Multi DD
		Select dd=new Select(d.findElement(By.name("cars")));
		for(int i=0;i<4;i++)
		{
			dd.selectByIndex(i);
			Thread.sleep(1000);
		}
		dd.deselectAll();
		/*ArrayList<String> al1=new ArrayList<String>();
		al1.add("Volvo");
		al1.add("Saab");
		al1.add("Opel");
		al1.add("Audi");
		ArrayList<WebElement> al2=new ArrayList<WebElement>(dd.getOptions());
		ArrayList<String> al3=new ArrayList<String>();
		for(WebElement s:al2)
		{
			al3.add(s.getText());
		}
			
		if(al1.equals(al3))
		{
			System.out.println("Passs........");
		}*/
		
		Thread.sleep(4000);
		// Close browser
		d.quit();
		
	}

}
