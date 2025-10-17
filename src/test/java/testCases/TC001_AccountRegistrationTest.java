package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {


	@Test(groups= {"Master"})
	public void verify_account_registration() throws InterruptedException {
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAct();
		logger.info("clicked on my account");
		hp.clickReg();
		
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		regPage.setFirstname(randomeString());
		regPage.setLastname(randomeString().toUpperCase());
		regPage.setTelphn(randomNumber());
		regPage.setEmail(randomeString()+"@gmail.com");
		
		String password = randomAlphaNumeric();
		regPage.setPwd(password);
		regPage.cnfmPwd(password);
		regPage.setPrivacyPolcy();
		logger.info("set privacy policy test");
		regPage.clkContinue();
		logger.info("click button continue");
	
	
	
		String conMsg = regPage.getConfirmationMsg();
		logger.info("validating expected msg");
		System.out.println(conMsg);
	//	Assert.assertEquals(conMsg,"Your Account Has Been Created!!");
		if(conMsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else 
		{
			logger.error("Test failed.....!!!");       
			logger.debug("debug logs");
			logger.info("test logs");
			Assert.assertTrue(false);
		}
	}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		tearDown();
		logger.info("Finished account Registration Test ......");

	}



	
}
