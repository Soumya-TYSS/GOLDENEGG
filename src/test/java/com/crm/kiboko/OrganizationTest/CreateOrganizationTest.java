package com.crm.kiboko.OrganizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.kiboko.GenericUtility.ExcelUtility;
import com.crm.kiboko.GenericUtility.FileUtility;
import com.crm.kiboko.GenericUtility.JavaUtility;
import com.crm.kiboko.GenericUtility.WebDriverUtility;
import com.crm.kiboko.PomRepository.CreatingNewOrganisation;
import com.crm.kiboko.PomRepository.Homepage;
import com.crm.kiboko.PomRepository.LoginPage;
import com.crm.kiboko.PomRepository.Organisation;
import com.crm.kiboko.PomRepository.OrganisationInfo;

public class CreateOrganizationTest {

	//public static void main(String[] args) throws Throwable {
	WebDriverUtility wLib=new WebDriverUtility();
	JavaUtility jLib=new JavaUtility();
	ExcelUtility eLib=new ExcelUtility();
	FileUtility fLib=new FileUtility();

	WebDriver driver;

	@Test
	public void creatingOrgTest() throws Throwable
	{
		
		//Random ran=new Random();
		//int num=ran.nextInt(1000);
		int num = jLib.getRandomNumber();
				//FileInputStream fis=new FileInputStream("./data/testdata.properties");
	//	Properties p=new Properties();
	//	p.load(fis);
		//String url =p.getProperty("url");
		//WebDriver driver=new ChromeDriver();
	//	driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//String url = fLib.getPropertyKeyValue("url");
		//String un = fLib.getPropertyKeyValue("un");
		//String pwd = fLib.getPropertyKeyValue("pw");
		//driver.get(url);
		//String un = p.getProperty("un");
		//driver.findElement(By.name("user_name")).sendKeys(un);
		//String pwd = p.getProperty("pw");
		//driver.findElement(By.name("user_password")).sendKeys(pwd);
		//driver.findElement(By.id("submitButton")).click();
	//	LoginPage lp=new LoginPage(driver);
	//	lp.loginToVtiger(url, un, pwd);
        Homepage hp=new Homepage(driver);
        hp.getOrganisationLink().click();
        Organisation o=new Organisation(driver);
        o.getCreateOrgImage().click();
        CreatingNewOrganisation cno=new CreatingNewOrganisation(driver);
        String orgname = eLib.getDataFromExcel("Organisation", 1, 1);
        cno.createOrg(orgname+num);
        OrganisationInfo oi=new OrganisationInfo(driver);
        WebElement msg = oi.getSucessMsg();
        String confMsg = msg.getText();
        System.out.println(confMsg);
        if(confMsg.contains(orgname))
        	System.out.println("Organisation created suceesfully");
        else
        	System.out.println("Organisation is not created");
        //hp.getAdministrator().click();
        //hp.getSignOutLink().click();
		
      //  driver.close();
		
		
		/*
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		FileInputStream f1=new FileInputStream("./data/lastname.xlsx");
		Workbook wb = WorkbookFactory.create(f1);
		String data = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(data+num);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		String OrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgName.contains(data))
		{
			System.out.println("Organisation is successfully created");
			WebElement resource = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
			Actions a =new Actions(driver);
			a.moveToElement(resource).perform();
			driver.findElement(By.linkText("Sign Out")).click();
	}
	else
		System.out.println("Organisation is not successfully created");
	driver.close();
	
		}

	private static OrganisationInfo OrganisationInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	private static CreatingNewOrganisation CreatingNewOrganisation() {
		// TODO Auto-generated method stub
		return null;
	}
		
	
	}
*/
        
	}

	}
