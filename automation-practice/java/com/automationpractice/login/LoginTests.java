package com.automationpractice.login;
/**
 * Sep 30, 2019 - Homework (TC1 (password message verification part), TC2 and TC3) 
 * after class work on Sep 26, 2019
 * @author Denis
 */
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;

import driver_factory.Driver;
import utils.AppProperties;
import utils.DriverHelper;

public class LoginTests extends Driver{
	
	private final int timeOutInSeconds = 15;
	
	@Test (priority = 1)
	public void Login_with_invalid_userid() {
		
//			Go to http://www.automationpractice.com
			driver.get("http://www.automationpractice.com");
			
//			Click Sign in button from top right corner of the page
			driver.findElement(By.className("login")).click();
			
//			Enter invalid email address 'myunknowxaad@mailinator.com' in email address text field of right side
			driver.findElement(By.id("email")).sendKeys("myunknowxaad@mailinator.com");
			
//			Click Sign in button
			driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
			
//			Verify error message displayed 'There is 1 error'
			String errorMessage = driver.findElement(By.xpath("//p[text()='There is 1 error']")).getText();
			
			Assert.assertEquals(errorMessage, "There is 1 error", "Error message (1 error) verification is failed");
			
//			Verify error message displayed 'Password is required.'
			
			DriverHelper driverHelper = new DriverHelper(driver);
			
			String messageAct2=driverHelper.getText(By.xpath("//li[text()='Password is required.']"), timeOutInSeconds);
			String messageExp2="Password is required.";
			Assert.assertEquals(messageAct2, messageExp2, "Error message (Pwd rqrd) verification is failed");
			
//			driver.quit();
	}
	
	@Test(priority = 2)
	public void Login_with_valid_userid_but_invalid_password() {
		
		// Login with valid userid but invalid password
		DriverHelper driverHelper = new DriverHelper(driver);
		 
//		Go to http://www.automationpractice.com
		driver.navigate().to(AppProperties.AUTOMATION_PRACTICE_BASE_URL);

//		Click Sign in button from top right corner of the page
		driverHelper.click(By.className("login"), timeOutInSeconds);
		 
//		Enter valid email address 'abc213@mailinator.com' in email address text field of right side
		driverHelper.sendkeys(By.id("email"), "abc213@mailinator.com", timeOutInSeconds);
		
//		Enter invalid password 'myinvalidpwd' in password text field
		driverHelper.sendkeys(By.id("passwd"), "myinvalidpwd", timeOutInSeconds);
		
//		Click 'Sign in' button
		driverHelper.click(By.xpath("//button[@id='SubmitLogin']"), timeOutInSeconds);
		
//		Verify error message displayed 'There is 1 error'
		
		Assert.assertEquals(driverHelper.getText(By.xpath("//p[text()='There is 1 error']"), timeOutInSeconds), 
				"There is 1 error", "Error message (1 error) verification is failed");
		
//		Verify error message displayed 'Authentication failed.'
		Assert.assertEquals(driverHelper.getText(By.xpath("//li[text()='Authentication failed.']"), timeOutInSeconds),
				"Authentication failed.", "Error message (Auth failed) verification is failed");
		
//		driver.quit();
		
	}

	@Test(priority = 3)
	public void Login_with_valid_userid_and_password() {
//		Login with valid userid and password
		
		DriverHelper driverHelper = new DriverHelper(driver);
		 
//		Go to http://www.automationpractice.com
		driver.navigate().to(AppProperties.AUTOMATION_PRACTICE_BASE_URL);

//		Click Sign in button from top right corner of the page
		driverHelper.click(By.className("login"), timeOutInSeconds);
		 
//		Enter valid email address 'abc213@mailinator.com' in email address text field of right side
		driverHelper.sendkeys(By.id("email"), "abc213@mailinator.com", timeOutInSeconds);

//		Enter valid password 'abc1234' in password text field
		driverHelper.sendkeys(By.id("passwd"), "abc1234", timeOutInSeconds);
		
//		Click 'Sign in' button
		driverHelper.click(By.xpath("//button[@id='SubmitLogin']"), timeOutInSeconds);
		
//		Verify 'MY ACCOUNT' text displayed	
		driverHelper.waitForElementVisibility(By.xpath("//h1[text()='My account']"), timeOutInSeconds);
		
		Assert.assertEquals(driverHelper.getText(By.tagName("h1"), timeOutInSeconds), 
				"MY ACCOUNT","Header (My Acc) validation is failed");
		
//		Verify 'Welcome to your account. Here you can manage all of your personal information and orders.' text displayed
		Assert.assertEquals(driverHelper.getText(By.xpath("//p[@class='info-account']"), timeOutInSeconds), 
				"Welcome to your account. Here you can manage all of your personal information and orders.","Text (Welcome) validation is failed");
		
//		Verify 'My personal information' text displayed
		Assert.assertEquals(driverHelper.getText(By.xpath("//span[preceding-sibling::i[@class='icon-user']]"), timeOutInSeconds), 
				"MY PERSONAL INFORMATION","Text (My pers info) validation is failed"); //failed? All CAPITAL - actual, regular in TC.
		
//		Click 'Sign out' button from top right corner
		driverHelper.click(By.xpath("//a[@title='Log me out']"), timeOutInSeconds);
		
		driver.quit();
		
	}
	
	

}

