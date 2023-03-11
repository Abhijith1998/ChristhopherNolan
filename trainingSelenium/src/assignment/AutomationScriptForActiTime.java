package assignment;

/***
 * @author Abhijith
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationScriptForActiTime {

	public static void main(String[] args) throws InterruptedException {
		// Test data
		String usernameData = "admin";
		String passwordData = "manager";
		String expectedLoginPageTitle = "actiTIME - Login";
		String expectedHomePageTitle = "actiTIME - Enter Time-Track";
		// Step 1:Open the Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		System.out.println("Chrome Browser is launched succesfully");
		driver.manage().window().maximize();
		System.out.println("Browser is maximized");

		// Step 2: Enter the test URL and click on 'Enter' button
		driver.get("https://demo.actitime.com/login.do");
		String actualLoginPageTitle = driver.getTitle();
		if (expectedLoginPageTitle.equals(actualLoginPageTitle)) {
			System.out.println("Login page is displayed successfully");
		} else {
			System.out.println("Login page is not displayed");
		}

		// Step 3:Click on username Text field and provide the input
		WebElement usernameTextField = driver.findElement(By.name("username"));
		usernameTextField.clear();
		usernameTextField.sendKeys(usernameData);
		String actualDataEnteredInUsenameTextField = usernameTextField.getAttribute("value");
		if (usernameData.equals(actualDataEnteredInUsenameTextField)) {
			System.out.println("username Text field accepted the data");
		} else {
			System.out.println("username Text field failed to accept the data");
		}

		// Step 4:Click on password Text field and provide the input
		WebElement passwordTextField = driver.findElement(By.name("pwd"));
		passwordTextField.clear();
		passwordTextField.sendKeys(passwordData);
		String actualDataEnteredInPasswordTextField = passwordTextField.getAttribute("value");
		if (passwordData.equals(actualDataEnteredInPasswordTextField)) {
			System.out.println("password Text field accepted the data");
		} else {
			System.out.println("password Text field failed to accept the data");
		}
		// Step 5: Click on 'Login' button
		WebElement loginButton = driver.findElement(By.partialLinkText("Login"));
		loginButton.click();
		Thread.sleep(3000);
		String actualHomePageTitle = driver.getTitle();
		if (expectedHomePageTitle.equals(actualHomePageTitle)) {
			System.out.println("Home page is displayed successfully");
		} else {
			System.out.println("Home page is not displayed");
		}
		driver.quit();
	}
}
