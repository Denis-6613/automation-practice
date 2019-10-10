package com.herokuapp.testleaf;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driver_factory.NonStaticDriver;
import utils.AppProperties;
import utils.Common;

/**
 * Oct 6, 2019
 * @author Denis
 *
 */


public class Table_10_06_2019 extends NonStaticDriver{
	
	private final int timeOutInSeconds = 15;
	
	@BeforeClass
	void beforeClass() {
		driverHelper.openUrl(AppProperties.TEST_LEAF_BASE_URL+"/pages/table.html");
	}
	
	/**
	 * Get the count of number of columns
	 */
//	@Test
	public void tableTest1() {
	//Option1
//		List<WebElement> columns = driverHelper.getElements(By.tagName("th"), timeOutInSeconds);
//		System.out.println("columns = "+columns.size());
//		Assert.assertEquals(columns.size(), 3);//if numbers to compare - go with Equals
		
//		Assert.assertTrue(columns.size()==2);// if boolean to compare - go with True
//		Assert.assertFalse(columns.size()==3); // if false is expected
		
	//Option2
		WebElement tableElement = driverHelper.getElement(By.tagName("table"), timeOutInSeconds);
		int numOfColumns=tableElement.findElements(By.tagName("th")).size();
		System.out.println("numOfColumns = "+numOfColumns);
		Assert.assertEquals(numOfColumns, 3);
	}
	
	/**
	 * Get the count of number of rows
	 */
//	@Test
	void tableTest2() {
	
		WebElement tableElement = driverHelper.getElement(By.tagName("table"), timeOutInSeconds);
		int numOfRows=tableElement.findElements(By.tagName("tr")).size();
		System.out.println("numOfRows = "+numOfRows);
		Assert.assertEquals(numOfRows, 4);
	}
	
	/**
	 * Get the progress value of 'Learn to interact with Elements'
	 */
//	@Test
	public void tableTest3() {
		
		String progress = getCellValue("Learn to interact with Elements", "Progress");
		System.out.println(progress);
		Assert.assertEquals(progress, "80%");
		
	}
	
	@Test
    void tableTest4 () {
        WebElement webElement = getCell("Learn to interact with Elements", "Vital Task");
        webElement.click();
        Common.sleep(1);
        Assert.assertTrue(webElement.findElement(By.tagName("input")).isSelected());
    }

	
	private String getCellValue(String rowName, String columnName) {
		String cellValue="";
		int columnIndex=0;
		List<WebElement> columnElements = driverHelper.getElements(By.xpath("//table/tbody/tr/th"), timeOutInSeconds);
		for (int index=0; index<columnElements.size();index++) {
			String actualColumnName=columnElements.get(index).getText();
			if (actualColumnName.contains(columnName)) {
				columnIndex=index+1;
				break;
			}
		}
		
		List<WebElement> rowElements = driverHelper.getElements(By.xpath("//table/tbody/tr"), timeOutInSeconds);
		for (int index=1; index<rowElements.size();index++) {
			String actualRowName=rowElements.get(index).findElement(By.tagName("td")).getText();
			if (actualRowName.contains(rowName)) {
				cellValue=rowElements.get(index).findElement(By.xpath(".//td["+columnIndex+"]")).getText();
			}
		}
		return cellValue;
	}
	
		private WebElement getCell ( String rowName, String columnName ) {
	        WebElement webElement = null;
	        int columnIndex = 0;
	        List<WebElement> columnElements = driverHelper.getElements(By.xpath("//table/tbody/tr/th"), timeOutInSeconds);
	        for ( int index = 0; index < columnElements.size(); index++ ) {
	            String actualColumnName = columnElements.get(index).getText();
	            if ( actualColumnName.contains(columnName) ) {
	                columnIndex = index + 1;
	                break;
	            }
	        }
	        
	        List<WebElement> rowElements = driverHelper.getElements(By.xpath("//table/tbody/tr"), timeOutInSeconds);
	        for ( int index = 1; index < rowElements.size(); index++ ) {
//	          parent element row -- > rowElements.get(index)
//	          child element column of element row --> .findElement(By.tagName("td"))
	            String actualRowName = rowElements.get(index).findElement(By.tagName("td")).getText();
	            if ( actualRowName.contains(rowName) ) {
	                webElement = rowElements.get(index).findElement(By.xpath(".//td[" + columnIndex + "]"));
	            }
	        }
	        return webElement;
	    }
		
}
