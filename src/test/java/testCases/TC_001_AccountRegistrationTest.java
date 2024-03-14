package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

//run the testCases

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"regression","master"})
	public void verify_account_registration()
	{
		
		logger.info("**** starting TC_001_AccountRegistrationTest  *****");
		logger.debug("application logs started......");
		
		try {
			
			HomePage hp=new HomePage(driver);
			//hp.clickMyAccount();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			hp.clickRegister();
			
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString()+"@gmail.com");// randomly generated the email
			regpage.setTelephone(randomNumber());
			
			String password=randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			
			String confmsg=regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			
		}
		catch(Exception e) {
			
			logger.error("test failed..");
			logger.debug("debug logs....");
			Assert.fail();
		}
		
		
		logger.debug("application logs end.......");
		logger.info("**** finished TC_001_AccountRegistrationTest  *****");
		
	}
	
	
	
	
}








