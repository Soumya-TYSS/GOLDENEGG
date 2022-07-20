package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetDataInExcelTest {

	public static void main(String[] args) throws IOException {
      FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
      Workbook wb=WorkbookFactory.create(fis);
      String series = "Ihone10";
      int rowcount = wb.getSheet("Iphone").getLastRowNum();
      for(int i=0;i<=rowcount ;i++)
      {
    	  String data = wb.getSheet("Iphone").getRow(i).getCell(1).getStringCellValue();
    	  
		if(data.equals(series))
		{
			double price=wb.getSheet("Iphone").getRow(i).getCell(2).getNumericCellValue();
			System.out.println(price); 
			break;
		}
		
		
      }
      
      
	}

}
