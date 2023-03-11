package dataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//create object of FIS/FR
		FileInputStream fis=new FileInputStream("./testData/testData.xlsx");
		
		//Object of File type
		Workbook workbook = WorkbookFactory.create(fis);
		
		//read methods
		String testData1 = workbook.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		System.out.println(testData1);
		
		LocalDateTime ldt = workbook.getSheet("Sheet2").getRow(0).getCell(0).getLocalDateTimeCellValue();
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.getMonth());
		System.out.println(ldt.getYear());
	}
}
