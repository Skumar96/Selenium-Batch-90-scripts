package abcpack;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataExport_POI {
	@Test
	public void dataExport() throws Exception
	{
		FileOutputStream fos=new FileOutputStream("E:\\Selenium_Scripts_Mar18\\Results\\DataExport.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet ws1=wb.createSheet("Results1");
		XSSFSheet ws2=wb.createSheet("Results2");
		Row r=ws1.createRow(0);
		r.createCell(0).setCellValue("Selenium");
		r.createCell(1).setCellValue("Appium");
		wb.write(fos);
		fos.close();
		
	}

}
