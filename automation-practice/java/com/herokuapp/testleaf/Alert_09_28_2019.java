package com.herokuapp.testleaf;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver_factory.Driver;
import utils.Common;

public class Alert_09_28_2019 extends Driver{
	
	@Test (priority = 1)
	public void alert3() {
		
		driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
		
		WebDriverWait webDriverWait=new WebDriverWait(driver, 15);
		WebElement headerElement=driver.findElement(By.tagName("h1"));
		
		webDriverWait.until(ExpectedConditions.visibilityOf(headerElement));
		String header = headerElement.getText();
		
		Assert.assertEquals(header, "Handle Alerts","Header validation is failed");
		
		WebElement alertBoxButton=driver.findElement(By.xpath("//button[.='Alert Box']"));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Alert Box']")));
		alertBoxButton.click();
		
		Assert.assertEquals(driver.switchTo().alert().getText(), "I am an alert box!","Alert box text validation is failed");
//		Common.sleep(2);
		driver.switchTo().alert().accept();
		
//		Common.sleep(2);
//		driver.quit();
		
		
		
		
	}
	
	@Test
	public void alert2() {
		
		driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
		
		WebDriverWait webDriverWait=new WebDriverWait(driver, 15);
		WebElement headerElement=driver.findElement(By.tagName("h1"));
		
		webDriverWait.until(ExpectedConditions.visibilityOf(headerElement));
		String header = headerElement.getText();
		
		Assert.assertEquals(header, "Handle Alerts","Header validation is failed");
		
		WebElement alertBoxButton=driver.findElement(By.xpath("//button[.='Confirm Box']"));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Alert Box']")));
		alertBoxButton.click();
		
		Assert.assertEquals(driver.switchTo().alert().getText(), "Press a button!","Alert box text validation is failed");
//		Common.sleep(1);
		driver.switchTo().alert().accept();
		
		String text = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(text, "You pressed OK!");
		
		driver.findElement(By.xpath("//button[.='Confirm Box']")).click();
		driver.switchTo().alert().dismiss();
		text = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(text, "You pressed Cancel!");
		
		
//		Common.sleep(2);
//		driver.quit();
		
	}
	
	@Test
	public void alert1() {
		
		driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        
        WebElement headerElement = driver.findElement(By.tagName("h1"));
        webDriverWait.until(ExpectedConditions.visibilityOf(headerElement));
        String header = headerElement.getText();
        Assert.assertEquals(header, "Handle Alerts", "Header validation is failed");
        
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Prompt Box']")));
        driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
        
        Assert.assertEquals(driver.switchTo().alert().getText(), "Please enter your training institute name");
        
        String inputText = "Tech Centure Academy";
        
        driver.switchTo().alert().sendKeys(inputText);
        driver.switchTo().alert().accept();
        
        
        String text = driver.findElement(By.id("result1")).getText();
        Assert.assertEquals(text, "You should not have enjoyed learning at " + inputText + " as compared to TestLeaf! Right?");
//        Common.sleep(3);
//        driver.quit();

		
	}
	
	

}
