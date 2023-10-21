package utilities.store.sprig;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilClass {
	
	public static String getCellValue(String xl, String sheet, int r, int c) {
		
		try {
			File f = new File(xl);
			FileInputStream fi = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			
			XSSFCell cell = (XSSFCell) wb.getSheet(sheet).getRow(r).getCell(c);
			if(cell.getCellType() == CellType.STRING) {
				return cell.getStringCellValue();
			}
			else {
				return cell.getRawValue();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return "";
		} 
		
	}
	
	
	public static int getRowCount(String xl, String sheet) {
		try {
			File f = new File(xl);
			FileInputStream fi = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			
			return wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		
	}

}
