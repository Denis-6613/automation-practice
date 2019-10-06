package driver_factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.AppProperties;
import utils.Common;
import utils.DriverHelper;

public class NonStaticDriver {
	
	protected WebDriver driver;
	protected DriverHelper driverHelper;
	
	@BeforeTest
	public void init() {
		if ( driver == null ) driver = getDriver(AppProperties.BROWSER_TYPE);
//		driver=getDriver(AppProperties.BROWSER_TYPE);
		Common.deleteFiles("/target/Screenshots");
//		/automation-practice/target/Screenshots
	}
	
	protected NonStaticDriver () {}
	
	protected WebDriver getDriver(String browserType) {
		WebDriver driver=null;
		switch (browserType) {
		case "chrome":
			driver=getChromeDriver();
//			driver.manage().window().maximize();
			break;
		case "firefox":
			driver=getFirefoxDriver();
			driver.manage().window().maximize();
			break;
		default: System.out.println("Browser type"+ browserType+" invalid");
			break;
		}
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);/* implicit wait. Wait for all elements loaded to html up to X seconds. 
		When all elements found (loaded) - executes. Loaded faster - good, executes then.	*/
		driverHelper= new DriverHelper(driver);
		return driver;
	}
	
	public  ChromeDriver getChromeDriver () {
		WebDriverManager.chromedriver().setup();
		ChromeOptions crChromeOptions = new ChromeOptions();
        crChromeOptions.addArguments("--start-maximized");
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		return new ChromeDriver(crChromeOptions);
	}
	
	public  FirefoxDriver getFirefoxDriver () {
		WebDriverManager.firefoxdriver().setup();
//		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\geckodriver.exe");
		return new FirefoxDriver();
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
	
}
