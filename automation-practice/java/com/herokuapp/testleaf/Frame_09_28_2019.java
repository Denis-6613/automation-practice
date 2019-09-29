package com.herokuapp.testleaf;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import driver_factory.Driver;

/**
 * Sep 28, 2019
 * @author Denis
 *
 */

public class Frame_09_28_2019 extends Driver{

	@Test
	public void frame1() {
		driver.get("http://testleaf.herokuapp.com/pages/frame.html");
		driver.switchTo().frame(0);
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("click")));
		
		driver.findElement(By.id("click")).click();
		driver.switchTo().defaultContent();
		
//		driver.switchTo().frame(1);
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[2]")));
		driver.switchTo().frame("frame2");
//		driver.switchTo().frame(driver.findElement(By.id("frame2")));
		
		driver.findElement(By.id("Click1")).click();
		
//		driver.switchTo().parentFrame();
		
		
	}
	
}
