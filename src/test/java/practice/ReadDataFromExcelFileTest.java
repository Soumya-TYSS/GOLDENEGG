package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFileTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowcount = wb.getSheet("Invalid Login").getLastRowNum();
		for(int i=1; i<=rowcount; i++)
		{
		    double slno = wb.getSheet("Invalid Login").getRow(i).getCell(0).getNumericCellValue();
		    int sl=(int)slno; //downcasting.
		String un = wb.getSheet("Invalid Login").getRow(i).getCell(1).getStringCellValue();
		String pw = wb.getSheet("Invalid Login").getRow(i).getCell(2).toString();
		System.out.println(sl + "\t" + un + "\t" + pw);
		}
		
		
	/*	for(int i=0; i<rowcount; i++)
		{
			String un = wb.getSheet("Invalid Login").getRow(i).getCell(1).getStringCellValue();
			
		} */
		
	}

}
