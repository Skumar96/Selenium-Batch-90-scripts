package abcpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OR {
	
	OR(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}
	
	@FindBy(css="input.inputField.medium") WebElement txtuname;
	@FindBy(xpath="//input[@type='password']") WebElement txtpassword;
	@FindBy(css="button.actionButton") WebElement btnsignin;
	@FindBy(linkText="Logout") WebElement lnklogout;
	@FindBy(linkText="Sign in") WebElement lnksignin;
	
	public void fillLogin(String uname,String password)
	{
		lnksignin.click();
		txtuname.clear();
		txtuname.sendKeys(uname);
		txtpassword.clear();
		txtpassword.sendKeys(password);
		btnsignin.click();
	}
}
