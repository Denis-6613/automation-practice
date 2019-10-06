package com.automationpractice.demos;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver_factory.Driver;
import utils.AppProperties;
import utils.Common;
import utils.DriverHelper;

public class TestNGParameterDemo extends Driver{
	
	private final int timeOutInSeconds = 15;
	
	@Parameters({"userid","password"})
	@Test
	public void Login_with_userid_and_password(String u, String p) {
		
		driverHelper.openUrl("http://www.automationpractice.com");

		driverHelper.click(By.className("login"), timeOutInSeconds);
		 
//		valid email address 'abc213@mailinator.com'
		driverHelper.sendkeys(By.id("email"), u, timeOutInSeconds);

//		valid password 'abc1234'
		driverHelper.sendkeys(By.id("passwd"), p, timeOutInSeconds);
		
		driverHelper.click(By.xpath("//button[@id='SubmitLogin']"), timeOutInSeconds);
		
		Common.sleep(2);
		driver.quit();
		
	}
	

}
