package assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Agoda {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		FileInputStream fis1 = new FileInputStream("./testData/AgodaData.properties");
		Properties prop = new Properties();
		prop.load(fis1);
		String testUrl = (String) prop.get("url");

		FileInputStream fis2 = new FileInputStream("./testData/AgodaData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis2);
		Sheet sheet1 = workbook.getSheet("Sheet1");
		String from = sheet1.getRow(1).getCell(0).getStringCellValue();
		String to = sheet1.getRow(1).getCell(1).getStringCellValue();
		LocalDateTime date = sheet1.getRow(1).getCell(2).getLocalDateTimeCellValue();
		int day = date.getDayOfMonth();
		int year = date.getYear();

		String month = date.getMonth().toString();
		month = "" + month.charAt(0) + month.substring(1, month.length()).toLowerCase();
		System.out.println(month);

		double passengerDouble = sheet1.getRow(1).getCell(3).getNumericCellValue();
		int passenger = (int) passengerDouble;

		driver.get(testUrl);
		driver.findElement(By.xpath("//button[@class='ab-close-button']")).click();
		driver.findElement(By.xpath("//h6[text()='Flights']")).click();
		driver.findElement(By.id("flight-origin-search-input")).sendKeys(from);
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='Popup__content']/ul/li[2]"))).click();
		
		driver.findElement(By.id("flight-destination-text-search")).sendKeys(to);
		driver.findElement(By.xpath("//span[@class='Suggestion__text']")).click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.getElementById('flight-departure').click()");
//		driver.findElement(By.xpath("//div[text()='"+month+" "+year+"']/..//span[text()='"+day+"']"));
//
//		driver.findElement(By.xpath("//i[@data-selenium='arrow-down-icon']")).click();
//		String passengerNumber = driver.findElement(By.cssSelector("span[data-component=\"flight-occupancy-adult-number\"]")).getText();
//		driver.findElement(By.cssSelector("span[data-element-name=\"flight-occupancy-adult-increase\"]")).click();

	}

}
