package com.herokuapp.testleaf;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import driver_factory.NonStaticDriver;
import utils.AppProperties;
import utils.Common;

/**
 * Oct 06, 2019
 * @author Denis
 *
 */

public class Window_10_06_2019 extends NonStaticDriver{
	
	private final int timeOutInSeconds = 15;
	
	@Test
	public void windowTest1() {
		driverHelper.openUrl(AppProperties.TEST_LEAF_BASE_URL+"/pages/Window.html");
		
		driverHelper.clickById("home", timeOutInSeconds);
		
		Set<String> windows = driver.getWindowHandles();
		
		for (String window : windows) {
			driver.switchTo().window(window);
			String headerActual=driverHelper.getText(By.tagName("h1"), timeOutInSeconds);
			String headerExpected="Locators and Selenium Interactions";//home
			
			if (headerActual.equals(headerExpected)) {// if home
				String title=driver.getTitle();
				Assert.assertEquals(title, "TestLeaf - Selenium Playground"); //title check
				driver.close();
			}
			
			driver.switchTo().window(windows.iterator().next());
			headerActual=driverHelper.getText(By.tagName("h1"), timeOutInSeconds);
			Assert.assertEquals(headerActual, "Work with Windows"); //check we are in main
		} 
//		Common.sleep(2);
	}
	@Test
	public void windowTest2() {
		driverHelper.openUrl(AppProperties.TEST_LEAF_BASE_URL+"/pages/Window.html");
		
		driverHelper.click(By.xpath("//button[@onclick='openWindows()']"), timeOutInSeconds);
		
		Set<String> windows = driver.getWindowHandles();
			
		System.out.println("Windows number = "+windows.size());
//		Common.sleep(2);
	}
	
	@Test
	public void windowTest3() {
		driverHelper.openUrl(AppProperties.TEST_LEAF_BASE_URL+"/pages/Window.html");
		
		String mainWindow = driverHelper.getMainWindowhandle();
		
//		driverHelper.click(By.xpath("//button[@onclick='openWindows();']"), timeOutInSeconds);
		driverHelper.click(By.id("color"),1, timeOutInSeconds);
		
		Set<String> windows = driver.getWindowHandles();
		
		for (String window:windows) {
			if (window.equals(mainWindow)) {
				System.out.println("Original window, don't close");
			}else {
				driver.switchTo().window(window);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		Common.sleep(2);
	}
	
	@Test
	public void windowTest4() {
		driverHelper.openUrl(AppProperties.TEST_LEAF_BASE_URL+"/pages/Window.html");
		
		String mainWindow = driverHelper.getMainWindowhandle();
		
		driverHelper.click(By.id("color"),2, timeOutInSeconds);
		Common.sleep(5);
		
		Set<String> windows = driver.getWindowHandles();
		
		for (String window:windows) {
			if (window.equals(mainWindow)) {
				System.out.println("Original window, don't close");
			}else {
				driver.switchTo().window(window);
				driverHelper.takeScreenshot();
				driver.close();
			}
		}
		driverHelper.switchToMainWindow();
		Common.sleep(1);
	}
	
	
	

}
