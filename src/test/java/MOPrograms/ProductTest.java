package MOPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.kiboko.GenericUtility.BaseClass;
import com.crm.kiboko.GenericUtility.ExcelUtility;
import com.crm.kiboko.GenericUtility.JavaUtility;
import com.crm.kiboko.GenericUtility.WebDriverUtility;
import com.crm.kiboko.PomRepository.CreatingNewProduct;
import com.crm.kiboko.PomRepository.Homepage;
import com.crm.kiboko.PomRepository.Product;

public class ProductTest extends BaseClass{
	
	WebDriverUtility wLib=new WebDriverUtility();
	JavaUtility jLib=new JavaUtility();
	ExcelUtility eLib=new ExcelUtility();

	
	@Test
	public void createProductTest() throws Throwable
	{
		Homepage hp=new Homepage(driver);
		hp.getProductsLink().click();
		Product p=new Product(driver);
		p.getCreatePrdImg().click();
		CreatingNewProduct cnp=new CreatingNewProduct(driver);
		String prd = eLib.getDataFromExcel("Product", 1, 1);
		int num = jLib.getRandomNumber();
		cnp.getPrdNameTxtBx().sendKeys(prd+num);
		cnp.getPrdtActCheckBox().click();
		cnp.getStartDate().click();
		WebElement prdcategory = cnp.getPdctCategory();
		wLib.selectByIndex(prdcategory, 2);
		cnp.getVendNamelookUpicon().click();
		String partialTilte = eLib.getDataFromExcel("Vendor", 1, 2);
		wLib.switchWindows(driver, partialTilte);
		WebElement searchBx = cnp.getSearchTxBx();	
		wLib.waitForElement(driver, searchBx);
		String vendorName = eLib.getDataFromExcel("Vendor", 1, 1);
		cnp.getSearchTxBx().sendKeys(vendorName);
		cnp.getSearchBx().click();
		
		
		
	}
}
