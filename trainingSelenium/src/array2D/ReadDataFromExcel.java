package array2D;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		File filepath=new File("C:\\Users\\abhis\\eclipse-workspace\\trainingSelenium\\testData\\ArrayData.xlsx");
		FileInputStream fis=new FileInputStream(filepath);
		
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet1 = workbook.getSheet("Sheet1");
		int rowNum = sheet1.getPhysicalNumberOfRows();
		int colNum = sheet1.getRow(0).getPhysicalNumberOfCells();
		
		String[][] data=new String[rowNum-1][colNum];
		System.out.println(rowNum);
		System.out.println(colNum);
		for(int i=0;i<rowNum-1;i++) {
			for(int j=0;j<colNum;j++) {
				data[i][j]=sheet1.getRow(i+1).getCell(j).toString();
				System.out.print(data[i][j]+",");
			}
			System.out.println();
		}
	}
}
