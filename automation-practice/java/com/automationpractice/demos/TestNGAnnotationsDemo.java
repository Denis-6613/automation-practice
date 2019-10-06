package com.automationpractice.demos;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

public class TestNGAnnotationsDemo {

@Test
public void testOne() {
System.err.println("I am a test 1");
}
@Test
public void testTwo() {
System.out.println("I am a test 2");
}
@BeforeTest
public void beforeTest() {
System.err.println("I run always before xml test");
}



@BeforeMethod	//before ANY test method
public void before() {
System.out.println("I run always before any test executes");
}




@AfterMethod	//after ANY test method
public void after() {
System.out.println("I run always after any test executes");
}
@BeforeClass
public void beforeClass() {
	System.err.println("I run before a class");
}

@AfterClass
public void afterClass() {
	System.err.println("I run after a class");
}

@BeforeSuite
public void beforeSuite() {
	System.err.println("I run before a suite");
}

@AfterSuite
public void afterSuite() {
	System.err.println("I run after a suite");
}


}
