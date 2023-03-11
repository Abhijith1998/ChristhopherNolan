package assignment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import genericLibraries.Utility;

public class DemoWebShopAddToCart {

	@Test
	public void orderProduct() throws EncryptedDocumentException, IOException {
		//test data
		String homeTitle="Demo Web Shop";
		String loginPageTitle="Demo Web Shop. Login";
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		String testUrl = Utility.readDataInStringFromat("DemoWebshopTestcases", "Abhijith", 8, 5);
		driver.get(testUrl);
		driver.findElement(By.linkText("Log in")).click();
		String mail = Utility.readDataInStringFromat("DemoWebshopTestcases", "Abhijith", 10, 5);
		driver.findElement(By.id("Email")).sendKeys(mail);
		String password = Utility.readDataInStringFromat("DemoWebshopTestcases", "Abhijith", 11, 5);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.findElement(By.partialLinkText("DIGITAL DOWNLOADS")).click();

		driver.findElement(By.xpath("//div[@class='product-grid']/div[1]/div/div[2]/div[3]/div/input")).click();
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();

//		WebElement addressDropDown = driver.findElement(By.id("billing_address_id"));
//		Select select=new Select(addressDropDown);
//		select.selectByVisibleText("New Address");
		
		driver.findElement(By.xpath("//option[text()='New Address']")).click();
		String country = Utility.readDataInStringFromat("DemoWebshopTestcases", "Abhijith", 18, 5);
		driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys(country);
		String city = Utility.readDataInStringFromat("DemoWebshopTestcases", "Abhijith", 19, 5);
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys(city);
		String address = Utility.readDataInStringFromat("DemoWebshopTestcases", "Abhijith", 20, 5);
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys(address);
		int zipcode = Utility.readDataInNumberFromat("DemoWebshopTestcases", "Abhijith", 21, 5);
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys(""+zipcode+"");
		int phoneno = Utility.readDataInNumberFromat("DemoWebshopTestcases", "Abhijith", 22, 5);
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys(""+phoneno+"");
		driver.findElement(By.xpath("//input[@title='Continue']")).click();

		driver.findElement(By.id("paymentmethod_0")).click();
		driver.findElement(By.xpath("//input[@onclick=\"PaymentMethod.save()\"]")).click();
		driver.findElement(By.xpath("//input[@onclick=\"PaymentInfo.save()\"]")).click();
		Actions actions = new Actions(driver);
		actions.moveByOffset(1300, 68).click().perform();
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		String orderMessage = driver.findElement(By.xpath("//div[@class='title']")).getText();
		System.out.println(orderMessage);
	}
}
