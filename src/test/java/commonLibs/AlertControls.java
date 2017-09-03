package commonLibs;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonLibsContracts.IAlert;

public class AlertControls implements IAlert {

	private WebDriver driver;
	
	public AlertControls(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private Alert getAlert(){
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	
	
	 
	public void acceptAlert() throws Exception {
		
		getAlert().accept();
		
	}

	 
	public void rejectAlert() throws Exception {
		getAlert().dismiss();
		
	}

	 
	public String getMessageFromAlert() throws Exception {
		
		return getAlert().getText();
	}

	 
	public boolean isAlertPresent(long timeOutInSeconds) throws Exception {
		
		
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.alertIsPresent());
		
		return true;
	}

}
