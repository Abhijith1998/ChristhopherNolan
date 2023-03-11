package dataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnteringDataIntoActitimeUsingPropertyFile {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// creation of InputStream Object
		FileInputStream fis = new FileInputStream("./testData/actiTimeTestData.properties");

		// creating a properties file Object
		Properties prop = new Properties();

		// Read Methods of Properties
		prop.load(fis);
		
		String testUrl=(String) prop.get("url");
		String username=(String) prop.get("username");
		String password=(String) prop.get("password");

		driver.get(testUrl);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
	}
}
