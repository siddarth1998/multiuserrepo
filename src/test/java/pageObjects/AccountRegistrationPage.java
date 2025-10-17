package pageObjects;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFrstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	

	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelphn;
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtCnfmPwd;
	
//	@FindBy(xpath="//input[@name='agree']")
//	WebElement chckdPolicy;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
	WebElement chckdPolicy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='agree']")));
	
//	WebElement btnContinue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Continue']")));
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	

	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement msgConfirmation;
	
	public void setFirstname(String fname) {
		txtFrstname.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelphn(String tel) {
		txtTelphn.sendKeys(tel);
	}
	
	public void setPwd(String Pwd) {
		txtPwd.sendKeys(Pwd);
	}
	
	public void cnfmPwd(String cPwd) {
		txtCnfmPwd.sendKeys(cPwd);
	}
	
	public void setPrivacyPolcy( ) {
		
	//	chckdPolicy.submit();
	//	chckdPolicy.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(chckdPolicy).click().perform();
		}
	
	public void clkContinue() {
		//sol1
	//	btnContinue.click();
		
		//sol 2
		Actions actions = new Actions(driver);
		actions.moveToElement(btnContinue).click().perform();
		
		//sol3
	//	btnContinue.submit();
		
		//sol4
		//btnContinue.sendKeys(Keys.RETURN);
		
		//sol5
	//	JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click;", btnContinue);
		
		//sol6
	//	wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
		
	}
	
	
	
	public String getConfirmationMsg() {
		try {
		
			return(msgConfirmation.getText());
			
		}
		catch(Exception e){
			return(e.getMessage());
		}
	}
	
}
