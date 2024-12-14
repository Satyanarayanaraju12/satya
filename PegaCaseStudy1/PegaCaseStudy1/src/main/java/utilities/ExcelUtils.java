package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import setUp.setup;

public class ExcelUtils extends setup {
	// Inserting the Name stored in Excel File.
	@SuppressWarnings("resource")
	public String comLogin(int r, int c) throws IOException {

		FileInputStream file = new FileInputStream(new File(".//LoginCredentials.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(r);
		Cell cell = row.getCell(c);
		String value = cell.getStringCellValue();
		return value;

	}

	public String PDNlogin(int r, int c) throws IOException {

		FileInputStream file = new FileInputStream(new File(".//LoginCredentials.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(1);
		Row row = sheet.getRow(r);
		Cell cell = row.getCell(c);
		String value1 = cell.getStringCellValue();
		wb.close();
		return value1;
		

	}

}
