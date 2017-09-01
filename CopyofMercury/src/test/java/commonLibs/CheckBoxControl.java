package commonLibs;

import org.openqa.selenium.WebElement;

import commonLibsContracts.IChecckBox;

public class CheckBoxControl implements IChecckBox{


	public void changeCheckBoxStatus(WebElement element, boolean status) throws Exception {
		
		if((element.isSelected() && !status) || (!element.isSelected() && status)){
		
			element.click();
		
		} 
		
	}

}
