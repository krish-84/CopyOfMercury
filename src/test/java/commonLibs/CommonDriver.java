package commonLibs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import commonLibsContracts.IcommonDriver;


public class CommonDriver implements IcommonDriver {
	
	
	private WebDriver driver;
	private long pageLoadTimeout;
	private long elementDetectionTimeout;
	
	public CommonDriver(String browserType) throws Exception {
		
		
		
		pageLoadTimeout = 60l;
		
		
		elementDetectionTimeout = 10l;
		
		
		browserType = browserType.trim();
		
		switch (browserType.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ramakiye\\.m2\\repository\\chromedriver.exe");
			
			driver = new ChromeDriver();
			break;
		case "firefox":
			
			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ramakiye\\.m2\\repository\\geckodriver.exe");
			break;
		case "ie":
		
			driver = new InternetExplorerDriver();
		break;
		default:
			throw new Exception("Invalid Browser Type : "+ browserType);
			
		}
		
	}
	
	
	 
	public void invokeBrowser(String url) throws Exception {
		
		url = url.trim();
		
		if(url.isEmpty()){
			url = "about:blank";
		}
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		
		driver.get(url);
		
	}

	 
	public void closeBrowser() throws Exception {
		if(driver != null){
			driver.close();
		}
		
	}
	
	public WebDriver getDriver() throws Exception{
		return driver;
	}
	
	 
	public void closeAllBrowser() throws Exception {
		if(driver != null){
			driver.quit();
		}
		
	}

	 
	public void setPageLoadTimeout(long pageLoadTimeout) throws Exception {
		this.pageLoadTimeout = pageLoadTimeout;
		
	}

	 
	public void setElementDetectionTimeout(long elementDetectionTimeout) throws Exception {
		
		this.elementDetectionTimeout = elementDetectionTimeout;
		
	}

	 
	public String getTitle() throws Exception {
		
		return driver.getTitle();
	}

	 
	public String getPageSource() throws Exception {
		
		return driver.getPageSource();
	}

	 
	public String getCurrentUrl() throws Exception {
		
		return driver.getCurrentUrl();
	}

	 
	public void navigateTo(String url) throws Exception {
		driver.navigate().to(url);
		
	}

	 
	public void navigateRefresh() throws Exception {
		
		driver.navigate().refresh();
	}

	 
	public void navigateForward() throws Exception {
		driver.navigate().forward();
		
	}

	 
	public void navigateBack() throws Exception {
		driver.navigate().back();
		
	}

}
