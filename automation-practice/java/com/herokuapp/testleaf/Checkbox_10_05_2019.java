package com.herokuapp.testleaf;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.*;

import driver_factory.Driver;
import driver_factory.NonStaticDriver;
import utils.Common;

public class Checkbox_10_05_2019 extends NonStaticDriver{
	
	private final int timeOutInSeconds=15;
	
	@BeforeClass
	public void openTestLeafCheckboxPage() {
		driverHelper.openUrl("http://testleaf.herokuapp.com/pages/checkbox.html");
	}
	
	String xpath = "//label[contains(text(),\"{0}\")]/following-sibling::input";
	
//	@Test
	public void checkbox1() {
		Common.sleep(1);
		String text = "Select the languages that you know?";
        String xpath = MessageFormat.format(this.xpath, text);

		driverHelper.click(By.xpath(xpath), 1, timeOutInSeconds);
		driverHelper.click(By.xpath(xpath), 2, timeOutInSeconds);
		driverHelper.click(By.xpath(xpath), 3, timeOutInSeconds);
		driverHelper.click(By.xpath(xpath), 4, timeOutInSeconds);
		driverHelper.click(By.xpath(xpath), 5, timeOutInSeconds);
		
		Common.sleep(1);
		
		for(int index=0;index<driverHelper.getElements(By.xpath(xpath),timeOutInSeconds).size();index++) {
			driverHelper.click(By.xpath(xpath), (index+1), timeOutInSeconds);
		}
		Common.sleep(1);
		
	}

//	@Test
	public void checkbox2() {
		String text="Confirm Selenium is checked";
		xpath=MessageFormat.format(xpath, text);
//		System.out.println(xpath);
		
		boolean isSelected=driverHelper.getElement(By.xpath(xpath), timeOutInSeconds).isSelected();
		driverHelper.takeScreenshot();
//		System.out.println("selected? - "+isSelected);
		Assert.assertEquals(isSelected, true);
	}
	
	@Test
	public void checkbox3() {
		String text="DeSelect only checked";
		xpath=MessageFormat.format(this.xpath, text);
		
		
//		String xpath="(//label[contains(text(),'DeSelect only checked')]/following-sibling::input)";
		List<WebElement> list=driverHelper.getElements(By.xpath(xpath), timeOutInSeconds);
		Common.sleep(1);
		for (WebElement webElement : list) {
			if(webElement.isSelected()) webElement.click();
		}
//		boolean isSelected=driverHelper.getElement(By.xpath(xpath), timeOutInSeconds).isSelected();
//		System.out.println("selected? - "+isSelected);
//		Assert.assertEquals(isSelected, true);
		Common.sleep(2);
	}
	
//	@Test
	public void checkbox4() {
		String text="Select all below checkboxes";
		xpath=MessageFormat.format(xpath, text);
				
		String xpath="(//label[contains(text(),'DeSelect only checked')]/following-sibling::input)";
		List<WebElement> list=driverHelper.getElements(By.xpath(xpath), timeOutInSeconds);
		Common.sleep(1);
		for (WebElement webElement : list) {
			if(webElement.isSelected()) webElement.click();
		}
//		boolean isSelected=driverHelper.getElement(By.xpath(xpath), timeOutInSeconds).isSelected();
//		System.out.println("selected? - "+isSelected);
//		Assert.assertEquals(isSelected, true);
		Common.sleep(2);
	}

	
	@AfterClass
	public void waitBeforeQuit() {
//		Common.sleep(2);
	}

}