package utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class DriverHelper {
	
	private String mainWindowhandle;
	private WebDriver driver;
	
	public DriverHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void openUrl(String url) {
		driver.get(url);
		mainWindowhandle=driver.getWindowHandle();
	}
	
	public void waitForElementVisibility(By by, int timeOutInSeconds) {
		
		new WebDriverWait(driver, timeOutInSeconds).
		until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}
	
	public void waitForElementsVisibility(By by, int timeOutInSeconds) {
		
		new WebDriverWait(driver, timeOutInSeconds).
		until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		
	}
	
	public WebElement getElement (By by, int timeOutInSeconds) {
		waitForElementVisibility(by, timeOutInSeconds);
		return driver.findElement(by);
	}
	
	public List<WebElement> getElements (By by, int timeOutInSeconds) {
		waitForElementVisibility(by, timeOutInSeconds);
		return driver.findElements(by);
	}
	
	public void click(By by, int timeOutInSeconds ) {
		getElement(by, timeOutInSeconds).click();
	}

	public void click(By by, int index, int timeOutInSeconds ) {
		getElements(by, timeOutInSeconds).get(index-1).click();
	}
	
	public void clickById(String id, int timeOutInSeconds ) {
		getElement(By.id(id), timeOutInSeconds).click();
	}
	
	public void clickByXpath(String xpath, int timeOutInSeconds ) {
		getElement(By.xpath(xpath), timeOutInSeconds).click();
	}
	
	public void sendkeys(By by, String text, int timeOutInSeconds ) {
		getElement(by, timeOutInSeconds).sendKeys(text);
	}
	
	public String getText (By by, int timeOutInSeconds ) {
		return getElement(by, timeOutInSeconds).getText();
	}
	
	public void takeScreenshot() {
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		//getScreenshotAs method to create image file
		File file=takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile =new File(System.getProperty("user.dir")+"/target/Screenshots"+
		"/Screenshot_"+System.currentTimeMillis()+".png");
		try {
			//move image file to new destination
			//copy file at destination
			FileUtils.copyFile(file, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void switchToNewWindow() {
		
		Set<String> handles = driver.getWindowHandles();
		
		for (String h:handles) {
			if (h.equals(mainWindowhandle)) {
				System.out.println("Original window, driver will not switch");
			}else {
				driver.switchTo().window(h);
			}
		}
	}
	
	public String getMainWindowhandle() {
		return mainWindowhandle;
		
	}
	
	public void switchToMainWindow() {
		driver.switchTo().window(mainWindowhandle);
	}

}
