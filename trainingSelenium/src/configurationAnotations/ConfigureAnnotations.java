package configurationAnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConfigureAnnotations {
	
	//In real time we used to Establish connections with JDBC and write what u required only once
	//execute only once for one testNG class
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("From before suite");
	}
	
	//
	//execute only once for one testNG class
	@BeforeTest
	public void beforeTest() {
		System.out.println("From before test");
	}
	
	//All browser setup actions will be written inside @BeforeClass
	@BeforeClass
	public void beforeClass() {
		System.out.println("From before class");
	}
	
	//All the common features like login actions will be written inside this annotation
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("From before method");
	}
	
	//logout features actions will be written inside this @AfterMethod
	@AfterMethod
	public void afterMethod() {
		System.out.println("From after method");
	}
	
	@Test
	public void create() {
		System.out.println("Creating a Base class");
	}
	
	//All browser closing actions will be written inside @BeforeClass
	@AfterClass
	public void afterClass() {
		System.out.println("From after class");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("From after test");
	}
	
	//In real time we used to close connections with JDBC
	//execute only once for one testNG class
	@AfterSuite
	public void afterSuite() {
		System.out.println("From after suite");
	}
	
	
	
	
	
	
}
