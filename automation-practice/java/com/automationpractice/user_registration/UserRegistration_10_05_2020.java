package com.automationpractice.user_registration;



import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import driver_factory.NonStaticDriver;
import utils.*;

/**
 * Oct 05, 2019, NonStaticDriver now
 * @author Denis
 *
 */

public class UserRegistration_10_05_2020 extends NonStaticDriver{
	
	private final int timeOutInSeconds = 15;
	
	@Test
	public void userRegistration() {

		driverHelper.openUrl(AppProperties.AUTOMATION_PRACTICE_BASE_URL);
		driverHelper.click(By.linkText("Sign in"),timeOutInSeconds);
		
		String firstName=Common.getRandomFirstName();
		String lastName=Common.getRandomLastName();
		
		String email=Common.getRandomEmail(firstName,lastName );
		
		driverHelper.sendkeys(By.id("email_create"), email, timeOutInSeconds);
//		Common.sleep(2);
		
		driverHelper.click(By.id("SubmitCreate"), timeOutInSeconds);
		
		driverHelper.waitForElementVisibility
		(By.xpath("//h1[text()='Create an account']"), timeOutInSeconds);
//		(By.id("submitAccount"), timeOutInSeconds);
		
		String h1Header = driverHelper.getText(By.tagName("h1"), timeOutInSeconds);
//		System.out.println("h1Header = "+h1Header);
		
		Assert.assertEquals(h1Header, "CREATE AN ACCOUNT","Header validation is failed");
		System.out.println("Our random name is "+firstName+" "+lastName);
		System.out.println("Our random e-mail is "+email);
		
		
		

	}

}
