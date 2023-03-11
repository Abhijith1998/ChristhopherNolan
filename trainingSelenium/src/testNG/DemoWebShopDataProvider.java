package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoWebShopDataProvider {
	@DataProvider
	public String[][] testData() {
		String[][] sarr= {
							{"male","AbhijithA","S","abhi1998@gmail.com","abhi@1998","abhi@1998"},
							{"female","Anjula","A","anju1998@gmail.com","anju@1998","anju@1998"},
							{"male","kiraniii","K","kira1998@gmail.com","kiran@1998","kiran@1998"},
							{"female","bhoom","shetty","bhoom1998@gmail.com","bhoom@1998","bhoom@1998"},
							{"female","tejaswi","qw","poitr1998@gmail.com","tej@1998","tej@1998"},				
			             };
		return sarr;
	}
	@Test(dataProvider = "testData")
	public void register(String[] data) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		

		driver.get("https://demowebshop.tricentis.com/");

		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("gender-"+data[0]+"")).click();

		driver.findElement(By.id("FirstName")).sendKeys(data[1]);

		driver.findElement(By.id("LastName")).sendKeys(data[2]);

		driver.findElement(By.id("Email")).sendKeys(data[3]);

		driver.findElement(By.id("Password")).sendKeys(data[4]);

		driver.findElement(By.id("ConfirmPassword")).sendKeys(data[5]);

		driver.findElement(By.id("register-button")).click();
		
		driver.quit();
	}
}
