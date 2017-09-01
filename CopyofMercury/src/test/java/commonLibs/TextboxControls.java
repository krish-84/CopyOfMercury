package commonLibs;

import org.openqa.selenium.WebElement;

import commonLibsContracts.ITextbox;

public class TextboxControls implements ITextbox{

	 
	public void setText(WebElement element, String textToSet) throws Exception {
		
		
		element.sendKeys(textToSet);
		
	}

	 
	public void clearText(WebElement element) throws Exception {
		element.clear();
		
	}

}
