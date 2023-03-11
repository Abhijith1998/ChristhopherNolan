package dataDriven;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class LoginActitimeThroughCsvData {

	public static void main(String[] args) throws IOException, CsvException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// creation of InputStream Object
		FileReader fr=new FileReader("./testData/testData2.csv");
		// creating a properties file Object
		CSVReader reader=new CSVReader(fr);

		// Read Methods of Properties
		List<String[]> allData = reader.readAll();
		
		for(String[] sarr:allData) {
				driver.get(sarr[0]);
				driver.findElement(By.id("username")).sendKeys(sarr[1]);
				driver.findElement(By.name("pwd")).sendKeys(sarr[2]);
				break;
		}
		driver.findElement(By.id("loginButton")).click();
	}
}
