package com.automationpractice.user_registration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver_factory.Driver;
import utils.*;

/**
 * Sep 22, 2019
 * Sep 28, 2019
 * Sep 29, 2019
 * @author Denis
 *
 */

public class UserRegistration_09_28_2019 extends Driver{
	
	private final int timeOutInSeconds = 15;
	
	@Test
	public void userRegistration() {

		DriverHelper driverHelper = new DriverHelper(driver);
		
		driver.navigate().to(AppProperties.AUTOMATION_PRACTICE_BASE_URL);
		
		driverHelper.click(By.linkText("Sign in"),timeOutInSeconds);
		
		String firstName=Common.getRandomFirstName();
		String lastName=Common.getRandomLastName();
		
		String email=Common.getRandomEmail(firstName,lastName );
		
		driverHelper.sendkeys(By.id("email_create"), email, timeOutInSeconds);
//		Common.sleep(2);
		
		driverHelper.click(By.id("SubmitCreate"), timeOutInSeconds);
		
		driverHelper.waitForElementVisibility
//		(By.xpath("//h1[text()='Create an account']"), timeOutInSeconds);
		(By.id("submitAccount"), timeOutInSeconds);
		
		String h1Header = driverHelper.getText(By.tagName("h1"), timeOutInSeconds);
		System.out.println("h1Header = "+h1Header);
		
		
		Assert.assertEquals(h1Header, "CREATE AN ACCOUNT","Header validation is failed");
		
				
		
		
//		driver.quit();
		
//		System.out.println("Our random name is "+firstName+" "+lastName);
//		System.out.println("Our random e-mail is "+email);

	}

}
