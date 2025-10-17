package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

//	WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAcnt;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnkRegstr;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	public void clickMyAct() 
	{
		lnkMyAcnt.click();
	}
	
	public void clickReg() 
	{
		lnkRegstr.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}

	
}
