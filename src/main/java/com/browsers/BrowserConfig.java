package com.browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;


/*This class will provide the browser
 * We have two methods
 * From the 'startAPP' you can choose the browser
 * close the browser with 'closeBrowser' method */

public class BrowserConfig {

	
	public static WebDriver startAPP(WebDriver driver, String browserName, String url) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/ninja/drivers/chromedriver");
			driver = new ChromeDriver();
			
		}else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver");
			driver = new FirefoxDriver();
			
		}else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver");
			driver = new EdgeDriver();
			
		}else if (browserName.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", "Drivers/operadriver");
			driver = new OperaDriver();
			
		}else if (browserName.equalsIgnoreCase("safari")) {
			System.setProperty("webdriver.safari.driver", "Drivers/safaridriver");
			driver = new SafariDriver();
			
		}else {
			System.out.println(browserName+" "+"is not supported by this framework yet!!");
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		return driver;
		
	}
	
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
		
	}
	
}
