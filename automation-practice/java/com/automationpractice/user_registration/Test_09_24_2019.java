package com.automationpractice.user_registration;

import org.openqa.selenium.By;
import static utils.Common.sleep;

import driver_factory.Driver;
import utils.AppProperties;

public class Test_09_24_2019 extends Driver{

	public static void main(String[] args) {
		driver.navigate().to(AppProperties.AUTOMATION_PRACTICE_BASE_URL);
		driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Terms')])[1]")).click();
		
//		sleep(1);
		driver.quit();

	}

}
