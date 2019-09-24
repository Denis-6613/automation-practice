package driver_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.AppProperties;

public class Driver {
	
	protected static WebDriver driver;
	
	static {
		driver=getDriver(AppProperties.BROWSER_TYPE);
	}
	
	protected Driver () {}
	
	protected static WebDriver getDriver(String browserType) {
		WebDriver driver=null;
		switch (browserType) {
		case "chrome":
			driver=getChromeDriver();
			break;
		case "firefox":
			driver=getFirefoxDriver();
			break;
		default: System.out.println("Browser type"+ browserType+" invalid");
			break;
		}
		return driver;
	}
	
	public static ChromeDriver getChromeDriver () {
		WebDriverManager.chromedriver().setup();
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		return new ChromeDriver();
	}
	
	public static FirefoxDriver getFirefoxDriver () {
		WebDriverManager.firefoxdriver().setup();
//		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\geckodriver.exe");
		return new FirefoxDriver();
	}
	
}
