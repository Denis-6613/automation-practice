package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class DriverHelper {
	
	private WebDriver driver;
	
	public DriverHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void waitForElementVisibility(By by, int timeOutInSeconds) {
		
		new WebDriverWait(driver, timeOutInSeconds).
		until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}
	
	public WebElement getElement (By by, int timeOutInSeconds) {
		waitForElementVisibility(by, timeOutInSeconds);
		return driver.findElement(by);
	}
	
	public void click(By by, int timeOutInSeconds ) {
		getElement(by, timeOutInSeconds).click();
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

}
