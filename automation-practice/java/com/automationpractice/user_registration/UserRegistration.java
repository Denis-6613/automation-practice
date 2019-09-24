package com.automationpractice.user_registration;



import org.openqa.selenium.WebDriver;

import driver_factory.Driver;
import utils.AppProperties;

/**
 * Sep 22, 2019
 * @author Denis
 *
 */

public class UserRegistration extends Driver{

	public static void main(String[] args) {
//		WebDriver driver = getDriver(AppProperties.BROWSER_TYPE);
		driver.navigate().to(AppProperties.BASE_URL);
		
		

	}

}
