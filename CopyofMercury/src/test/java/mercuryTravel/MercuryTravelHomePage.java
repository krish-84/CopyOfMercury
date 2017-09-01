package mercuryTravel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.ActionControl;
import commonLibs.TextboxControls;
import commonLibs.WebElementControls;

public class MercuryTravelHomePage {
	
	@FindBy(linkText="International Holidays")
	private WebElement internationHolidayLink;
	
	@FindBy(linkText="Indian Holidays")
	private WebElement indianHolidayLink;
	
	@FindBy(linkText="Flights")
	private WebElement filghtsLink;

	@FindBy(linkText="Customer Login")
	private WebElement customerLoginLink;
	
	@FindBy(linkText="User Login")
	private WebElement userLogin;
	
	
	@FindBy(linkText="Register")
	private WebElement RegisterLink;
	
	
	@FindBy(id="sign_user_email")
	private WebElement userEmailId;
	
	@FindBy(id="sign_user_password")
	private WebElement userPassword;
	
	@FindBy(xpath="//div[@id='modalLogin']//form[@class='form-signin']//button")
	private WebElement loginButton;
	
	@FindBy(xpath="(//a[@class='dropdown-toggle'])[4]")
	private WebElement welcomeText;
	
	private TextboxControls textbox;
	private WebElementControls element;
	private ActionControl action;
	
	
	public MercuryTravelHomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		textbox = new TextboxControls();
		element = new WebElementControls();
		action = new ActionControl(driver);
		
		
	}
	
	public void userLogin(String sUserEmailId, String sUserPassword) throws Exception{
		
		moveToCustomerLogin();
		
		element.click(userLogin);
		
		Thread.sleep(2000);
		
		textbox.setText(userEmailId, sUserEmailId);
		
		Thread.sleep(2000);
		
		textbox.setText(userPassword, sUserPassword);
		
		element.click(loginButton);
	}
	
	public String getWelcomeMessage() throws Exception{
		
		return element.getText(welcomeText);
	}
	
	private void moveToCustomerLogin() throws Exception{
		
		action.moveToElement(customerLoginLink);
		
	}
	
}
