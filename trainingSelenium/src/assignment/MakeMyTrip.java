package assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com/");
		FileInputStream fis=new FileInputStream("./testData/MakeMyTripData.xlsx");
		Workbook Workbook = WorkbookFactory.create(fis);
		Sheet sheet1 = Workbook.getSheet("Sheet1");
		String from = sheet1.getRow(1).getCell(0).toString();
		String to = sheet1.getRow(1).getCell(1).toString();
		LocalDateTime date = sheet1.getRow(1).getCell(2).getLocalDateTimeCellValue();
		int day = date.getDayOfMonth();
		int year = date.getYear();
		String month = date.getMonth().toString();
		month=""+month.charAt(0)+month.substring(1, month.length()).toLowerCase();
		double passenger = sheet1.getRow(1).getCell(3).getNumericCellValue();
		int passenger1=(int) passenger;
		driver.findElement(By.xpath("//span[text()='Flights']")).click();
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(from);
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(to);
		driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
		driver.findElement(By.xpath("//div[text()='"+month+" "+year+"']/../..//p[text()='"+day+"']")).click();
		driver.findElement(By.xpath("//label[@for='travellers']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-"+passenger1+"']")).click();
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		driver.findElement(By.partialLinkText("SEARCH")).click();
		driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
		List<WebElement> allFlights = driver.findElements(By.xpath("//div[@class='fli-list  simpleow ']"));
		System.out.println(allFlights.size());
	}
}
