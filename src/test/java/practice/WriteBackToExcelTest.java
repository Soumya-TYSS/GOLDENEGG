package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteBackToExcelTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./data/vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("Product").getRow(1).createCell(9).setCellValue("Fail");
		FileOutputStream fos=new FileOutputStream("./data/vtiger.xlsx");
		wb.write(fos);
		wb.close();

	}

}
