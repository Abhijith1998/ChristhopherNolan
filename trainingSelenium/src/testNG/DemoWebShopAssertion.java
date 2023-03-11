package testNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoWebShopAssertion {
	@DataProvider
	public String[][] testData() {
		String[][] data = { { "male", "AbhijithA", "S", "abhi1998ab@gmail.com", "abhi@1998", "abhi@1998" },
				{ "female", "Anjula", "A", "anju1998ba@gmail.com", "anju@1998", "anju@1998" },
				{ "male", "kiraniii", "K", "kira1998cc@gmail.com", "kiran@1998", "kiran@1998" },
				{ "female", "bhoom", "shetty", "bhoom1998de@gmail.com", "bhoom@1998", "bhoom@1998" },
				{ "female", "tejaswi", "qw", "poitr1998dr@gmail.com", "tej@1998", "tej@1998" }, };
		return data;
	}

	@Test(dataProvider = "testData")
	public void register(String[] data) {
		// test data
		String homePageTitle = "Demo Web Shop";
		String registerPageTitle = "Demo Web Shop. Register";
		String registerResultPage = "Demo Web Shop. Register";

		// step 1:open the browser enter the url
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		Reporter.log("Browser launched successfully", true);
		driver.manage().window().maximize();
		Reporter.log("Browser maximized successfully", true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demowebshop.tricentis.com/");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(driver.getTitle(), homePageTitle, "Failed to navigate to home page");
		Reporter.log("Home page is displayed", true);

		// step2:click on Register link
		driver.findElement(By.linkText("Register")).click();
		softAssert.assertEquals(driver.getTitle(), registerPageTitle, "Failed to navigate to register page");
		Reporter.log("Register page is displayed", true);

		// step 3:Enter the data to the fields
		WebElement radioButton = driver.findElement(By.id("gender-" + data[0] + ""));
		radioButton.click();
		softAssert.assertEquals(radioButton.isSelected(), true, "" + data[0] + "radio button is not selected");
		Reporter.log("" + data[0] + " radio button is selected", true);

		WebElement firstNameTextField = driver.findElement(By.id("FirstName"));
		firstNameTextField.sendKeys(data[1]);
		softAssert.assertEquals(firstNameTextField.getAttribute("value"), data[1], "First name is not entered");
		Reporter.log("First name is entered successfully", true);

		WebElement lastNameTextField = driver.findElement(By.id("LastName"));
		lastNameTextField.sendKeys(data[2]);
		softAssert.assertEquals(lastNameTextField.getAttribute("value"), data[2], "Last name is not entered");
		Reporter.log("Last name is entered successfully", true);

		WebElement mail = driver.findElement(By.id("Email"));
		mail.sendKeys(data[3]);
		softAssert.assertEquals(mail.getAttribute("value"), data[3], "email is not entered");
		Reporter.log("email is entered successfully", true);

		WebElement passwordTextField = driver.findElement(By.id("Password"));
		passwordTextField.sendKeys(data[4]);
		softAssert.assertEquals(passwordTextField.getAttribute("value"), data[4], "Password is not entered");
		Reporter.log("password is entered successfully", true);

		WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
		confirmPassword.sendKeys(data[5]);
		softAssert.assertEquals(confirmPassword.getAttribute("value"), data[5], "confirm Password is not entered");
		Reporter.log("confirm password is entered successfully", true);

		WebElement registerButton = driver.findElement(By.id("register-button"));
		registerButton.click();
		softAssert.assertEquals(driver.getTitle(), registerResultPage, "User failed to Register");
		Reporter.log("User Registered successfully", true);
		driver.quit();
		softAssert.assertAll();
	}
}
