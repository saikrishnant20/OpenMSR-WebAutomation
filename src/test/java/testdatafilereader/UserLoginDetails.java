package testdatafilereader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserLoginDetails {

public static final String URLPATH="./src/test/resources/TestData/properties/UserLoginDetails.properties";
	
	public static String getValue(String key) throws IOException
	{
		File file=new File(URLPATH);
		FileInputStream fls=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fls);
		return prop.getProperty(key);
		
	}
}
