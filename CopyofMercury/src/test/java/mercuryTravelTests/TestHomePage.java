package mercuryTravelTests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestHomePage extends BaseScenarios{
	
	
	
	@Test(enabled=false)
	public void verifyTitleOfHomePage(){
		try {
			Assert.assertEquals(cmnDriver.getTitle(), 
					configProperty.getProperty("homePageTitle"));
			
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	
	@Test(priority=100)
	public void verifyUserLoginWithCorrectCredetials(){
		try {
			String sUserEmailId = configProperty.getProperty("userEmailId");
			String sUserPassword = configProperty.getProperty("userPassword");
			
			homepage.userLogin(sUserEmailId, sUserPassword);
			
			String welcomeTextFromSite = homepage.getWelcomeMessage();
					
			System.out.println(welcomeTextFromSite);
			
			String expectedText = "Welcome, "+configProperty.getProperty("username");
			
			Assert.assertEquals(welcomeTextFromSite, expectedText);
			
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
		
	}
	
	
	
}
