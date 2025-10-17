package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{
	@Test(groups={"Sanity","Master"})
	
	public void verify_login()
	{
		logger.info("Started the TC002_LoginTest class");
		
		//Homepage
		HomePage hp = new HomePage(driver);
		hp.clickMyAct();
		hp.clickLogin();
		
		//login
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPwd(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage, true);
		tearDown();
		logger.info("Finished the TC002_LoginTest class" );
		
	}
}
