package com.automationpractice.login;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import driver_factory.NonStaticDriver;
import utils.Reporter;
public class LoginTestWithReporting extends NonStaticDriver{
    
	private final int timeOutInSeconds=15;
	
    @Test
    public void loginWithValidUserIdAndPassword() {
        Reporter.createClass("LoginTestWithReporting");
        Reporter.createTest("login test case");
        
        driverHelper.openUrl("http://www.automationpractice.com");
        driverHelper.click(By.className("login"), 2);
//        driverHelper.openUrl("http://testleaf.herokuapp.com/");
//        driverHelper.click(By.linkText("Checkbox"), timeOutInSeconds);
        Reporter.verify("abc", "def");
    }
    
}