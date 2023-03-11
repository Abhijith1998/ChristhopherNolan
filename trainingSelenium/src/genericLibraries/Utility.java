package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	
	public String[][] readDataFromExcel(String fileName,String sheetName) throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream("./testData/"+fileName+".xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowNum=sheet.getPhysicalNumberOfRows();
		int colNum=sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] data=new String[rowNum-1][colNum];
		for(int i=0;i<rowNum-1;i++) {
			for(int j=0;j<colNum;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	public static int readDataInNumberFromat(String fileName,String sheetName ,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/"+fileName+".xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		return (int) sheet.getRow(rowIndex).getCell(colIndex).getNumericCellValue();
	}
	
	public static boolean readDataInBooleaFromat(String fileName,String sheetName ,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/"+fileName+".xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		return (boolean) sheet.getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
	}
	
	public static LocalDateTime readDataInDateFromat(String fileName,String sheetName ,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/"+fileName+".xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		return sheet.getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
	}
	public static String readDataInStringFromat(String fileName,String sheetName ,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/"+fileName+".xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}
}

