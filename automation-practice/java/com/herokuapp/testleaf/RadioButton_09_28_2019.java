package com.herokuapp.testleaf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver_factory.Driver;

/**
 * Sep 28, 2019
 * @author Denis
 *
 */
public class RadioButton_09_28_2019 extends Driver {
	
	@Test //TestNG methods may not be static
	public void test1() {
		driver.get("http://testleaf.herokuapp.com/pages/radio.html");
		
		WebDriverWait webDriverWait = new WebDriverWait(driver,15);
		/*
		 * Explicit wait 
		 */
		WebElement yesElement= driver.findElement(By.id("yes"));
//		WebElement noElement= driver.findElement(By.id("no"));
		
		webDriverWait.until(ExpectedConditions.visibilityOf(yesElement));
		yesElement.click();
		
		boolean isYesSelected=yesElement.isSelected();
		Assert.assertTrue(isYesSelected, "Yes radio button is not selected");
		
//		if (isYesSelected) {
//			Assert.fail("Yes radio button is not selected");
//		}
		
		
		driver.quit();
	}

}
