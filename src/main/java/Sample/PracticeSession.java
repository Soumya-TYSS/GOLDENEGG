package Sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class PracticeSession {
	
		public static void main(String [ ] arg) throws EncryptedDocumentException, IOException  
		{
			FileInputStream fis=new FileInputStream("./data/vtiger.xlsx");
		    Workbook wb = WorkbookFactory.create(fis);
		    String data = wb.getSheet("Organisation").getRow(1).getCell(1).getStringCellValue();
		    
			System.out.println(data);
			
			
			
			
		}
}
