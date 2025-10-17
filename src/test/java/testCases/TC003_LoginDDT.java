package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass 
{

		
				/*Data is valid - login success - test pass - logout
				 				- login failed  - test fail
				Data is invalid  - login success - test fail - logout
								 - login failed - test pass  */

	
	

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")// getting data provider from different class
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException
	{
		logger.info("***** starting TC_003_LoginDDT ******");
		
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAct();
		hp.clickLogin();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPwd(pwd);
		lp.clickLogin();
			
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		logger.info("***** My account exists TC_003_LoginDDT ******");
		
		
		 if (exp.equalsIgnoreCase("Valid")) {
	            if (targetPage) {
	                macc.clickLogout();
	                Assert.assertTrue(true);
	            } else {
	                Assert.assertTrue(false, "Valid credentials but login failed");
	            }
	        }

	        if (exp.equalsIgnoreCase("Invalid")) {
	            if (targetPage) {
	                macc.clickLogout();
	                Assert.assertTrue(false, "Invalid credentials but login succeeded");
	            } else {
	                Assert.assertTrue(true);
	            }
	        }

		
		}catch(Exception e)
		{
			  logger.error("Test case failed for email: " + email);
		       Assert.fail("Exception occurred: " + e.getMessage());
		}
		Thread.sleep(3000);
		logger.info("***** Finished TC_003_LoginDDT ******");
		
	}
	
}
