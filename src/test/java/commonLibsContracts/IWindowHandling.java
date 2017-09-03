package commonLibsContracts;

import java.util.Set;

public interface IWindowHandling {

	public void switchToChildWindow() throws Exception;
	
	public void switchToParentWindow() throws Exception;
	
	public String getWindowHandle() throws Exception;
	
	public Set<String> getWindowHandles() throws Exception;
}
