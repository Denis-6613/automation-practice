package com.automationpractice.demos;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import driver_factory.Driver;
import utils.Common;

public class WebDriverSwitchWindow extends Driver{
	
	private final int timeOutInSeconds = 15;
	
	@Test
	public void switchWindowAndPerformActionInNewWindow() {
		driverHelper.openUrl("http://testleaf.herokuapp.com/pages/Window.html");
		
		String handle1=driver.getWindowHandle();
//		driverHelper.click(By.id("home"), timeOutInSeconds);
		driverHelper.clickById("home", timeOutInSeconds);
		
		Set<String> handles = driver.getWindowHandles();
		
//		for (String h:handles) {
//			if (h.equals(handle1)){
//				System.out.println("Original window");
//			}else {
//				driver.switchTo().window(h);
//			}
//		}
		
		driverHelper.switchToNewWindow();
		
//		driver.switchTo().window(nameOrHandle);
		driverHelper.clickByXpath("//h5[text()='Table']", timeOutInSeconds);
		
		
		
	}
	
	@AfterTest
	public void quit() {
		Common.sleep(2);
		driver.quit();
	}
	
	
	

}

