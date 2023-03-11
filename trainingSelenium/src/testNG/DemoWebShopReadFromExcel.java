package testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class DemoWebShopReadFromExcel {
	@DataProvider
	public String[][] data() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/demoWebshopdataProvider.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet1 = workbook.getSheet("Sheet1");
		int rowNum=sheet1.getPhysicalNumberOfRows();
		int colNum=sheet1.getRow(0).getPhysicalNumberOfCells();
		String[][] data=new String[rowNum-1][colNum];
		for(int i=0;i<rowNum-1;i++) {
			for(int j=0;j<colNum;j++) {
				data[i][j]=sheet1.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}
	@Test(dataProvider = "data")
	public void register(String[] data) {
		//test data
		String homePageTitle = "";
		String registerPageTitle = "";
		String registerResultPage="";
		
		//step 1:open the browser enter the url
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		Reporter.log("Browser launched successfully", true);
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Browser maximized successfully", true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demowebshop.tricentis.com/");
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(driver.getTitle(), homePageTitle, "Failed to navigate to home page");
		
		//step2:click on Register link 
		driver.findElement(By.linkText("Register")).click();
		softAssert.assertEquals(driver.getTitle(), registerPageTitle, "Failed to navigate to register page");
		
		//step 3:Enter the data to the fields
		WebElement radioButton = driver.findElement(By.id("gender-"+data[0]+""));
		radioButton.click();
		softAssert.assertEquals(radioButton.isSelected(), true, ""+data[0]+"radio button is not selected");
		Reporter.log(""+data[0]+"radio button is selected", true);
		
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
		confirmPassword.sendKeys(data[4]);
		softAssert.assertEquals(confirmPassword.getAttribute("value"), data[4], "confirm Password is not entered");
		Reporter.log("confirm password is entered successfully", true);
		
		WebElement registerButton = driver.findElement(By.id("register-button"));
		registerButton.click();	
		softAssert.assertEquals(driver.getTitle(), registerResultPage, "User failed to Register");
		Reporter.log("User Registered successfully", true);
		driver.quit();
		softAssert.assertAll();
	}
}
