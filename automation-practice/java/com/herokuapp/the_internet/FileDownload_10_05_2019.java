package com.herokuapp.the_internet;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver_factory.NonStaticDriver;
import utils.AppProperties;
import utils.Common;

public class FileDownload_10_05_2019 extends NonStaticDriver{
	
	private final int timeOutInSeconds=15;
	
	@Test
	public void fileDownloadTest1() {
		driverHelper.openUrl(AppProperties.THE_INTERNET_BASE_URL+"/download");
		
		String fileName="paxfulPic.png";
		Common.sleep(1);
		driverHelper.click(By.linkText(fileName), timeOutInSeconds);
		
		File file = new File(System.getProperty("user.home")+"/Downloads/"+fileName);
		
		System.out.println(file);
		
		boolean isFileExist=file.exists();
		int numberOfAttempts=0;
		while (!isFileExist&&numberOfAttempts<=5) {
			Common.sleep(1);
			isFileExist=file.exists();
			numberOfAttempts++;
		}
		
		Assert.assertTrue(file.exists(), "File \""+fileName+"\" is not found in Downloads directory");
		System.out.println(numberOfAttempts);
//		Common.sleep(2);
	}

}
