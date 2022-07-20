package com.crm.kiboko.contactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.kiboko.GenericUtility.ExcelUtility;
import com.crm.kiboko.GenericUtility.FileUtility;
import com.crm.kiboko.GenericUtility.JavaUtility;
import com.crm.kiboko.GenericUtility.WebDriverUtility;
import com.crm.kiboko.PomRepository.Contacts;
import com.crm.kiboko.PomRepository.ContactsInfo;
import com.crm.kiboko.PomRepository.CreatingNewContact;
import com.crm.kiboko.PomRepository.Homepage;
import com.crm.kiboko.PomRepository.LoginPage;

public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		int num = jLib.getRandomNumber();
		
		//FileInputStream fis=new FileInputStream("./data/testdata.properties");
		//Properties p=new Properties();
		//p.load(fis);
		//String url =p.getProperty("url");
		String url = fLib.getPropertyKeyValue("url");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	    wLib.waitForPageLoad(driver);
	
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	driver.get(url);
		//String un = p.getProperty("un");
		String un=fLib.getPropertyKeyValue("un");
		//driver.findElement(By.name("user_name")).sendKeys(un);
		//String pwd = p.getProperty("pw");
		String pwd=fLib.getPropertyKeyValue("pw");
		//driver.findElement(By.name("user_password")).sendKeys(pwd);
		//driver.findElement(By.id("submitButton")).click();
		LoginPage l=new LoginPage(driver);
		l.loginToVtiger(url, un, pwd);
		Homepage hp=new Homepage(driver);
		hp.getContactsLink().click();
	    Contacts c=new Contacts(driver);
	    c.getCreateOrgImage().click();
	    String Firstname = eLib.getDataFromExcel("Contact", 1, 1);
	    String LastName = (eLib.getDataFromExcel("Contact", 1, 2))+num;
	    CreatingNewContact cnc=new CreatingNewContact(driver);
		cnc.createCnt(Firstname, LastName);
	    
		//driver.findElement(By.linkText("Contacts")).click();
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//FileInputStream f1=new FileInputStream("./data/lastname.xlsx");
		//Workbook wb = WorkbookFactory.create(f1);
		//String data = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
	//	String data = eLib.getDataFromExcel("Organisation", 1, 0);
		
		//driver.findElement(By.name("lastname")).sendKeys(data);
		//driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		//String lname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		ContactsInfo cf=new ContactsInfo(driver);
		WebElement msg = cf.getSucessMsg();
		String confmMsg = msg.getText();
		System.out.println(confmMsg);
		if(confmMsg.contains(Firstname))
		{
			System.out.println("Contact is successfully created");
			//  WebElement resource = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
				//Actions a =new Actions(driver);
				//a.moveToElement(resource).perform();
				//wLib.mouseHoverAction(driver, resource);
			  //driver.findElement(By.linkText("Sign Out")).click();
		}
		else
			System.out.println("Contact is not successfully created");
		
		 hp.getAdministrator().click();
         hp.getSignOutLink().click();
		
		driver.close();
					
		
	}

}
