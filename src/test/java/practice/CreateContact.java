package practice;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.kiboko.GenericUtility.BaseClass;
import com.crm.kiboko.GenericUtility.ExcelUtility;
import com.crm.kiboko.GenericUtility.JavaUtility;
import com.crm.kiboko.GenericUtility.WebDriverUtility;
import com.crm.kiboko.PomRepository.Contacts;
import com.crm.kiboko.PomRepository.ContactsInfo;
import com.crm.kiboko.PomRepository.CreatingNewContact;
import com.crm.kiboko.PomRepository.Homepage;
@Listeners(com.crm.kiboko.GenericUtility.LisImpClss.class)
public class CreateContact extends BaseClass{
   
	WebDriverUtility wLib=new WebDriverUtility();
	JavaUtility jLib=new JavaUtility();
	ExcelUtility eLib=new ExcelUtility();
	
	@Test
	public void createContactWithNameTest() throws Throwable
	{   
		Homepage hp=new Homepage(driver);
		hp.getContactsLink().click();
		Contacts c=new Contacts(driver);
		c.getCreateOrgImage().click();
		wLib.waitForPageLoad(driver);
		CreatingNewContact cc=new CreatingNewContact(driver);
		String firstname = eLib.getDataFromExcel("Contact", 1, 1);
		String Lastname = eLib.getDataFromExcel("Contact", 1, 2);
		cc.createCnt(firstname, Lastname);
		ContactsInfo cf=new ContactsInfo(driver);
		String confMsg = cf.getSucessMsg().getText();
	//	SoftAssert sa=new SoftAssert();
		//sa.assertTrue(confMsg.contains(firstname));
	}
		/*		
		if(confMsg.contains(firstname))
			System.out.println("Contact created successfully");
		else 
			System.out.println("COntact not created");
		*/
/*	
	@Test
	public void createContactWithOrgNameTest() throws Throwable
	{
		Homepage hp=new Homepage(driver);
		hp.getContactsLink().click();
		Contacts c=new Contacts(driver);
		c.getCreateOrgImage().click();
		wLib.waitForPageLoad(driver);
		CreatingNewContact cc=new CreatingNewContact(driver);
		String firstname = eLib.getDataFromExcel("Contact", 1, 1);
		String Lastname = eLib.getDataFromExcel("Contact", 1, 2);
		cc.getLookUpIcon().click();
		String partialTitle = eLib.getDataFromExcel("Organisation", 1, 2);
		String pwh = driver.getWindowHandle();
		wLib.switchWindows(driver, partialTitle);
		Thread.sleep(3000);
		String orgn = eLib.getDataFromExcel("Organisation", 1, 1);
		cc.getSearchTxBx().sendKeys("orgn");
		cc.getSearchBT();
		cc.getContactText().click();
		Thread.sleep(3000);
		//wLib.switchWindows(driver, partialTitle);
		driver.switchTo().window(pwh);
        cc.getSaveBtn().click();
        ContactsInfo ci=new ContactsInfo(driver);
        String text = ci.getSucessMsg().getText();
        if(text.contains(Lastname))
        	System.out.println("contact created");
        else
        	System.out.println("contact not creted");
		
		}

*/
}

	
	