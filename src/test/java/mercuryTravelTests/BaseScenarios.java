package mercuryTravelTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import commonLibs.CommonDriver;
import mercuryTravel.MercuryTravelHomePage;
import utils.Utility;

public class BaseScenarios {
	
	public CommonDriver cmnDriver;
	private String url;
	public MercuryTravelHomePage homepage;
	private WebDriver driver;
	
	public Properties configProperty;
	
	
	public BaseScenarios() {
		
		try {
			configProperty = Utility.readProperties("C:\\Users\\ramakiye\\eclipse-workspace\\CopyofMercury\\src\\test\\java\\utils\\config.properties");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@BeforeClass
	public void setup(){
		
		try {
			
			url = configProperty.getProperty("baseUrl");
			
			String browserType = configProperty.getProperty("browserType");
			
			cmnDriver = new CommonDriver(browserType);
			
			long pageLoadTimeout = Long.valueOf(configProperty.getProperty("pageLoadTimeout"));
			long elementDetectionTimeout = Long.valueOf(configProperty.getProperty("elementDetectionTimeout"));
			
			cmnDriver.setPageLoadTimeout(pageLoadTimeout );
			cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);
			
			cmnDriver.invokeBrowser(url);
			
			driver = cmnDriver.getDriver();
			homepage = new MercuryTravelHomePage(driver);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	@AfterClass
	public void tearDown(){
		
		try {

			cmnDriver.closeAllBrowser();
		
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

}
