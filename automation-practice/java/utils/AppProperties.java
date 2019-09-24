package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Sep 22, 2019
 * @author Denis
 *
 */

public class AppProperties {
	
	private static Properties properties=getProperties();
	
	public static final String BASE_URL=properties.getProperty("base_url");
	
	public static final String BROWSER_TYPE=properties.getProperty("browser_type");
	

	private static Properties getProperties() {
		Properties properties=new Properties();
		
		try {
			String filePath=System.getProperty("user.dir")+"/src/test/resources/properties/config.properties";
			InputStream inputStream = new FileInputStream(filePath);
			properties.load(inputStream);
//			System.out.println("URL is "+properties.getProperty("base_url"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		}
		return properties;
	}
	

	
}

