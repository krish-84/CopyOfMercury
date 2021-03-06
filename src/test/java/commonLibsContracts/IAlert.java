package commonLibsContracts;

public interface IAlert {
	
	public void acceptAlert() throws Exception;
	
	public void rejectAlert() throws Exception;
	
	public String getMessageFromAlert() throws Exception;
	
	public boolean isAlertPresent(long timeOutInSeconds) throws Exception;

}
