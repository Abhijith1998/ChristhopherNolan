package testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	WebDriver driver;
	WebDriverWait explicitWait;
	Properties prop;
	//browser setup
	@BeforeClass
	public void browserSetup() throws IOException {
		//test data
		String expectedHomePageTitle=(String) prop.get("expectedHomePageTitle");
		//Step1:Open the browser Enter the url
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		Reporter.log("Browser is launched", true);
		driver.manage().window().maximize();
		Reporter.log("Browser is maximized", true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		explicitWait=new WebDriverWait(driver, 15);
		//create FIS File
		FileInputStream fis=new FileInputStream("./testData/testData.properties");
		//create Properties type Object
		prop=new Properties();
		prop.load(fis);
		//read methods from properties file
		String testUrl=(String) prop.get("url");
		driver.get(testUrl);
		Assert.assertEquals(driver.getTitle(), expectedHomePageTitle, "failed to navigate to home page");
		Reporter.log("Home page is displayed", true);
	}
	
	@BeforeMethod
	public void loginToApp() {
		//login feature of DemoWebShop
		//test data
		String testMail=(String) prop.get("mail");
		String testPassword=(String) prop.get("password");
		String expectedLoginPageTitle=(String) prop.get("expectedLoginPageTitle");
		
		//Step 2:Click on Login link
		driver.findElement(By.linkText("Log in")).click();
		Assert.assertEquals(driver.getTitle(), expectedLoginPageTitle, "Failed to login");
		Reporter.log("Login page is displayed", true);
		
		WebElement emailTextField = driver.findElement(By.id("Email"));
		emailTextField.sendKeys(testMail);
		Assert.assertEquals(emailTextField.getAttribute("value"), testMail, "invalid email");
		Reporter.log("email text field accepted the data", true);
		
		WebElement passwordTextField = driver.findElement(By.id("Password"));
		passwordTextField.sendKeys(testPassword);
		Assert.assertEquals(passwordTextField.getAttribute("value"), testPassword, "invalid password");
		Reporter.log("password text field accepted the data", true);
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		String actualHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualHomePageTitle, expectedLoginPageTitle, "Failed to login");
		Reporter.log("Login successfull", true);	
	}
	
	@AfterMethod
	public void logoutFromApp() {
		//click on logout link
		driver.findElement(By.linkText("Log out")).click();
	}
	
	@AfterClass
	public void closingBrowser() {
		driver.quit();
	}
	
}