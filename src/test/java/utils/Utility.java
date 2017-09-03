package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Utility {
	
	public static Properties readProperties(String filename) throws Exception{
		
		InputStream fileReader = new FileInputStream(filename);
		
		Properties property = new Properties();
		
		property.load(fileReader);
		
		return property;
		
		
	}

}
