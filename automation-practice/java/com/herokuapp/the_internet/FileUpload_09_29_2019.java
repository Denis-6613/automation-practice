package com.herokuapp.the_internet;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver_factory.Driver;
import utils.AppProperties;
import utils.DriverHelper;

/**
 * Sep 29, 2019
 * @author Denis
 *
 */

public class FileUpload_09_29_2019 extends Driver{
	
	private final int timeOutInSeconds=15;
	
	@Test
	public void fileUpload () {
		driver.get(AppProperties.THE_INTERNET_BASE_URL);
		
		DriverHelper driverHelper = new DriverHelper(driver);
		
		driverHelper.click(By.linkText("File Upload"), timeOutInSeconds);
		
		String filePath=System.getProperty("user.dir")+"/src/test/resources/Files/image.jpg";
		driverHelper.takeScreenshot();
		driverHelper.sendkeys(By.id("file-upload"), filePath, timeOutInSeconds);
		
		String fileName=Paths.get(filePath).getFileName().toString();
		System.out.println("fileName = "+fileName);
		String uploadedFile=driverHelper.getElement(By.id("file-upload"), timeOutInSeconds).getAttribute("value");
		uploadedFile=uploadedFile.substring(uploadedFile.lastIndexOf("\\")+1);
		System.out.println("uploadedFile = "+uploadedFile);
		Assert.assertEquals(fileName, uploadedFile,"Uploaded file validation is failed");
		driverHelper.takeScreenshot();
		driverHelper.click(By.id("file-submit"),timeOutInSeconds);
		
		String actualHeader = driverHelper.getText(By.tagName("h3"), timeOutInSeconds);
		String actualUploadedFile = driverHelper.getText(By.id("uploaded-files"), timeOutInSeconds);
		
		Assert.assertEquals(actualHeader,"File Uploaded!","Header validation is failed");
		Assert.assertEquals(actualUploadedFile, fileName,"Uploaded file name validation is failed");
		
		driverHelper.takeScreenshot();
		
		driver.quit();
		
	}
	
	

}
