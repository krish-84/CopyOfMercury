package commonLibs;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import commonLibsContracts.IWindowHandling;

public class WindowControl implements IWindowHandling {
	
	private WebDriver driver;
	
	public WindowControl(WebDriver driver) {
		this.driver = driver;
	}

	 
	public void switchToChildWindow() throws Exception {
		
		String childWindow = driver.getWindowHandles().toArray()[1].toString();
		
		driver.switchTo().window(childWindow);
		
	}
	
	public void switchToChildWindow(int childWindowIndex) throws Exception {
		
		String childWindow = driver.getWindowHandles().toArray()[childWindowIndex].toString();
		
		driver.switchTo().window(childWindow);
		
	}

	 
	public void switchToParentWindow() throws Exception {
		String parentWindow = driver.getWindowHandles().toArray()[0].toString();
		
		
		driver.switchTo().window(parentWindow);
	}
	
	public void switchToParentWindow(String parentWindow) throws Exception {
		
		driver.switchTo().window(parentWindow);
	}

	 
	public String getWindowHandle() throws Exception {
		
		return driver.getWindowHandle();
	}

	 
	public Set<String> getWindowHandles() throws Exception {
		
		return driver.getWindowHandles();
	}

}
