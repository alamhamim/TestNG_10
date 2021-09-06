package com.dataProvider;

import java.io.IOException;
import java.util.Properties;

import com.util.Helper;

public class BrowserDataProvider {
	
	
/*First reading the property file in the constractor
 * Then we have two methods and each method 
 * returning the browser name and the url from the properies file*/
	
	Properties properties;
	
	public BrowserDataProvider() throws IOException {
		 properties = Helper.readProperties("src/main/resources/TestData/browserData.properties");
		 
	}
	
	public String getBrowser() {
		return properties.getProperty("browserName");
		
		
	}
	
	public String getUrl() {
		return properties.getProperty("url");
		
		
	}

}
