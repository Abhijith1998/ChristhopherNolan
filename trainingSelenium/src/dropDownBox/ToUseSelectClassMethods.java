package dropDownBox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ToUseSelectClassMethods {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://demoapp.skillrary.com/");
		WebElement dropDown = driver.findElement(By.id("cars"));
	
		Select priceSelect=new Select(dropDown);
		System.out.println(priceSelect.isMultiple());
		priceSelect.selectByVisibleText("INR 100 - INR 199 ( 16 ) ");
		priceSelect.selectByIndex(0);
		priceSelect.selectByValue("500");
		
		List<WebElement> allPrices = priceSelect.getOptions();
		for(WebElement list:allPrices) {
			System.out.println(list.getText());
		}
		
		
		WebElement firstSelected = priceSelect.getFirstSelectedOption();
		System.out.println(firstSelected.getText());
		
		List<WebElement> selectedOptions = priceSelect.getAllSelectedOptions();
		for(WebElement list:selectedOptions) {
			System.out.println(list.getText());
		}
		
		priceSelect.deselectByIndex(0);
		priceSelect.deselectByValue("199");
//		priceSelect.deselectAll();
	}
}
