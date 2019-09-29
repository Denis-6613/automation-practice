package com.automationpractice.demos;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static utils.Common.sleep;

import java.util.Set;

import driver_factory.Driver;


public class WebDriverSwitchDemo extends Driver{
	
	@Test
	public void demoIFrame() {
		
		driver.get("http://testleaf.herokuapp.com/pages/frame.html");
//		driver.findElement(By.id("click")).click();//this button inside another html tag - driver cannot find it without switch
		
		driver.switchTo().frame(0);
			
		driver.findElement(By.id("click")).click();
//		sleep(1);
//		driver.quit();
	}

	@Test
	public void demoAlert() {
		
		driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
//		driver.findElement(By.id("click")).click();//this button inside another html tag - driver cannot find it without switch
		
//		driver.switchTo().alert().accept(); // OK
//		driver.switchTo().alert().dismiss();// Cancel
//		sleep(2);
		driver.findElement(By.xpath("//button[preceding-sibling::label[text()='Click the button to display a alert box.']]")).click();
//		sleep(2);
		driver.switchTo().alert().accept(); // OK
		
//		driver.findElement(By.id("click")).click();
//		sleep(1);
//		driver.quit();
	}
	@Test
	public void switchToWindow() {
		
		driver.get("http://testleaf.herokuapp.com/pages/Window.html");
		String handle1;
//		String handle2;
		 
		handle1=driver.getWindowHandle();
//		System.out.println("handle 1 = "+handle1);
		
//		System.err.println("ERR handle 1 = "+handle1);
//		sleep(2);
//		driver.quit();
		driver.findElement(By.id("home")).click();
		
		Set<String> handles=driver.getWindowHandles();
		handles.forEach(handle->{
			if(handle.equals(handle1)) {
				System.out.println("this is first window, so no switching...");
			}else {
				driver.switchTo().window(handle);
			}
		});
		
//		handle2=driver.getWindowHandle();
//		System.out.println("handle 2 = "+handle2);
//		sleep(2);
		
//		driver.switchTo().window(nameOrHandle);

		driver.findElement(By.xpath("//a[child::h5[text()='Image']]")).click();
//		sleep(2);
		
	}
}
