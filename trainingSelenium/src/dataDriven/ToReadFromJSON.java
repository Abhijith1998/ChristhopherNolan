package dataDriven;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToReadFromJSON {

	public static void main(String[] args) throws Exception {
	    //create FR object
		FileReader fr=new FileReader("./testData/testData.json");
		
		//create JSON Type object
		JSONParser parser=new JSONParser();
		JSONObject jsonObject	=(JSONObject) parser.parse(fr);
		
		//read methods
		String testUrl=(String) jsonObject.get("url");
		System.out.println(jsonObject.get("carName"));
		System.out.println(jsonObject.get("price"));
		System.out.println(jsonObject.get("flag"));
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(testUrl);
	}
}