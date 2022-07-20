package com.crm.kiboko.contactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.properties.PropertiesFactory;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.kiboko.GenericUtility.ExcelUtility;
import com.crm.kiboko.GenericUtility.FileUtility;
import com.crm.kiboko.GenericUtility.JavaUtility;
import com.crm.kiboko.GenericUtility.WebDriverUtility;
import com.crm.kiboko.PomRepository.Contacts;
import com.crm.kiboko.PomRepository.ContactsInfo;
import com.crm.kiboko.PomRepository.CreatingNewContact;
import com.crm.kiboko.PomRepository.CreatingNewOrganisation;
import com.crm.kiboko.PomRepository.Homepage;
import com.crm.kiboko.PomRepository.LoginPage;

public class CreateAndDeleteContactTest {

	public static void main(String[] args) throws Throwable {
    
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
			JavaUtility jLib=new JavaUtility();
			int num = jLib.getRandomNumber();
	 //  FileInputStream fis=new FileInputStream("./data/testdata.properties");
      //Properties p=new Properties();
      //p.load(fis);
      //String url = p.getProperty("url");
		String url=fLib.getPropertyKeyValue("url");
		WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //driver.get(url);
     // String un = p.getProperty("un");
      //String un=fLib.getPropertyKeyValue("un");
      //driver.findElement(By.name("user_name")).sendKeys(un);
      //String pwd = p.getProperty("pw");
     // String pwd=fLib.getPropertyKeyValue("pw");
      //driver.findElement(By.name("user_password")).sendKeys(pwd);
      //driver.findElement(By.id("submitButton")).click();
      String un = fLib.getPropertyKeyValue("un");
      String pwd=fLib.getPropertyKeyValue("pw");
      LoginPage lp=new LoginPage(driver);
      lp.loginToVtiger(url, un, pwd);
      Homepage hp=new Homepage(driver);
      hp.getContactsLink().click();
      Contacts c=new Contacts(driver);
      c.getCreateOrgImage().click();
      CreatingNewContact cnc=new CreatingNewContact(driver);
      String Firstname = eLib.getDataFromExcel("Contact", 1, 1);
      String Lastname = eLib.getDataFromExcel("Contact", 1, 2);
         cnc.createCnt(Firstname, Lastname+num);
         ContactsInfo ci=new ContactsInfo(driver);
        // WebElement msg = ci.getSucessMsg();
         String confmMsg = ci.getSucessMsg().getText();
         if(confmMsg.equals(Firstname))
        	 System.out.println("Contact is created successfully");
         else
        	 System.out.println("contact is not created");
         hp.getAdministrator().click();
         hp.getSignOutLink();
         
         driver.close();
              
           
     // driver.findElement(By.linkText("Contacts")).click();
     // driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
      //FileInputStream f1=new FileInputStream("./data/lastname.xlsx");
      //Workbook wb = WorkbookFactory.create(f1);
      //String data = wb.getSheet("Sheet1").getRow(1).getCell(0).toString();
      //String data=eLib.getDataFromExcel("Contact", 1, 1);
      //driver.findElement(By.name("lastname")).sendKeys(data);
      //driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
      //driver.findElement(By.xpath("(//input[@name='Delete'])[1]")).click();
      //driver.switchTo().alert().accept();
      //driver.findElement(By.xpath("(//input[@class='txtBox'])[1]")).sendKeys(data);
      //WebElement ContId = driver.findElement(By.xpath("(//select[@id='bas_searchfield'])[1]"));
      //Select s=new Select(ContId);
      //s.selectByValue("lastname");
      //wLib.selectByValue(ContId, "lastname");
      //driver.findElement(By.xpath("(//input[@class='crmbutton small create'])[1]")).click();
     // String text = driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).getText();
      //String msg="No Contact Found";
      //boolean dis = driver.findElement(By.xpath("//td[contains(text(),'You can Create a')]")).isDisplayed();
      //if(dis==true)
    	//  System.out.println("Successfully deleted");
     /* else
    	  System.out.println("Not deleted");
      WebElement resource = driver.findElement(By.xpath("(//td[@class='small'])[22]"));
     // Actions a =new Actions(driver);
	//	a.moveToElement(resource).perform();
		wLib.mouseHoverAction(driver, resource);
      driver.findElement(By.linkText("Sign Out")).click();
      
      */
    		  
	}

}
