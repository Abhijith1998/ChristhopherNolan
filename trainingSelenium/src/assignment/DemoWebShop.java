package assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShop {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Create FIS type Object
		FileInputStream fis = new FileInputStream("./testData/DemoWebShop.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet1 = workbook.getSheet("Sheet1");
		String firstName = sheet1.getRow(1).getCell(0).toString();
		String lastName = sheet1.getRow(1).getCell(1).toString();
		String mail = sheet1.getRow(1).getCell(2).toString();
		String gender = sheet1.getRow(1).getCell(3).toString().toLowerCase();
		String password = sheet1.getRow(1).getCell(4).toString();

		driver.get("https://demowebshop.tricentis.com/");

		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("gender-"+gender+"")).click();

		driver.findElement(By.id("FirstName")).sendKeys(firstName);

		driver.findElement(By.id("LastName")).sendKeys(lastName);

		driver.findElement(By.id("Email")).sendKeys(mail);

		driver.findElement(By.id("Password")).sendKeys(password);

		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

		driver.findElement(By.id("register-button")).click();

		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(mail);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("RememberMe")).click();
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	}
}
