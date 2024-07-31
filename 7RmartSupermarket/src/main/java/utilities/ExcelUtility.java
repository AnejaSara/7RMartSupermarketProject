package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtility {


	public static XSSFWorkbook wb;
		public static XSSFSheet sh;
		public static FileInputStream f;

		public static ArrayList<String> getString(String file_path, String sheet) {

			try {
				f = new FileInputStream(System.getProperty(file_path));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				wb = new XSSFWorkbook(f);
			} catch (IOException e) {

				e.printStackTrace();
			}
			sh = wb.getSheet(sheet);
			ArrayList<String> ExcelRows = new ArrayList<String>();
			int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
			for (int i = 0; i <= rowCount; i++) {
				Row row = sh.getRow(i);
				int cellCount = row.getLastCellNum();
				for (int j = 0; j < cellCount; j++) {
					ExcelRows.add(row.getCell(j).getStringCellValue());
				}
			}
			return ExcelRows;
		}
		public static String getString(int i, int j, String file_path, String sheet) {

			try {
				f = new FileInputStream(file_path);
				System.out.println("filestream::"+f);
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			try {
				wb = new XSSFWorkbook(f);
				System.out.println("workbook::"+wb);
			} catch (IOException e) {

				e.printStackTrace();
			}
			sh = wb.getSheet(sheet);
			System.out.println("sheet::"+sh);
			Row r = sh.getRow(i);
			Cell c = r.getCell(j);
			System.out.println("string value::"+c.getStringCellValue());
			return c.getStringCellValue();
		}
		public static String getString(int i, int j, String sheet) {
			String file_path = ConstantsFile.TESTDATAFILE;
			try {
				f = new FileInputStream(file_path);
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			try {
				wb = new XSSFWorkbook(f);
				
			} catch (IOException e) {

				e.printStackTrace();
			}
			sh = wb.getSheet(sheet);
			
			Row r = sh.getRow(i);
			Cell c = r.getCell(j);
			return c.getStringCellValue();
		}
}