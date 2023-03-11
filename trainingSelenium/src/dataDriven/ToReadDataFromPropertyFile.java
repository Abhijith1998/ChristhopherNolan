package dataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait explicitWait = new WebDriverWait(driver, 15);
		
		//creation of InputStream Object
		FileInputStream fis=new FileInputStream("./testData/testData.properties");
		
		//creating a properties file Object
		Properties prop=new Properties();
		
		//Read Methods of Properties
		prop.load(fis);
		
		String testUrl = (String) prop.get("url");
		String testUsername=(String) prop.get("username");
		String testPassword=(String) prop.get("password");
		driver.get(testUrl);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("user")).sendKeys(testUsername);
		driver.findElement(By.id("login")).click();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit")));
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(testPassword);
		driver.findElement(By.id("login-submit")).click();
	}
}
