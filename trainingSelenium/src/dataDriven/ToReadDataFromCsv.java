package dataDriven;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ToReadDataFromCsv {

	public static void main(String[] args) throws IOException, CsvException {
		// creation of FileReader Object
		FileReader fr = new FileReader("./testData/testData2.csv");

		// creation of file type object
		CSVReader reader = new CSVReader(fr);

		// read methods
		// to read single line

		String[] firstLineData = reader.readNext();
		for (String data : firstLineData) {
			System.out.println(data);
		}

		// to read all data

		/*
		 * List<String[]> allData = reader.readAll(); for (String[] sarr : allData) {
		 * for (String arr : sarr) { System.out.println(arr); } }
		 */

	}
}