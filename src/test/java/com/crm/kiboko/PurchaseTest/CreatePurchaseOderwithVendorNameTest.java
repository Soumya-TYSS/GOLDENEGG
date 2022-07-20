package com.crm.kiboko.PurchaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import com.crm.kiboko.PomRepository.Campaign;
import com.crm.kiboko.PomRepository.CampaignInfo;
import com.crm.kiboko.PomRepository.Contacts;
import com.crm.kiboko.PomRepository.ContactsInfo;
import com.crm.kiboko.PomRepository.CreatingNewCampaign;
import com.crm.kiboko.PomRepository.CreatingNewContact;
import com.crm.kiboko.PomRepository.CreatingNewVendor;
import com.crm.kiboko.PomRepository.Homepage;
import com.crm.kiboko.PomRepository.LoginPage;
import com.crm.kiboko.PomRepository.Purchase;
import com.crm.kiboko.PomRepository.Vendor;
import com.crm.kiboko.PomRepository.VendorInfo;

public class CreatePurchaseOderwithVendorNameTest {


	public static void main(String[] args) throws Throwable {
	
   WebDriverUtility wLib=new WebDriverUtility();
   JavaUtility jLib=new JavaUtility();
   FileUtility fLib=new FileUtility();
   ExcelUtility eLib=new ExcelUtility();
   
   WebDriver driver=new ChromeDriver();
   LoginPage lp=new LoginPage(driver);
   String url = fLib.getPropertyKeyValue("url");
   String un = fLib.getPropertyKeyValue("un");
   String pw = fLib.getPropertyKeyValue("pw");
   lp.loginToVtiger(url, un, pw);
   Homepage hp=new Homepage(driver);
   // creating contact
   hp.getContactsLink().click();
   Contacts c=new Contacts(driver);
   	c.getCreateOrgImage().click();
   	CreatingNewContact cnc=new CreatingNewContact(driver);
   	int numC = jLib.getRandomNumber();
   	String Firstname = eLib.getDataFromExcel("Contact", 1, 1);
   	String Lastname = eLib.getDataFromExcel("Contact", 1, 2);
   	cnc.createCnt(Firstname, Lastname+numC);
   	ContactsInfo cf=new ContactsInfo(driver);
   	String CnctMsg = cf.getSucessMsg().getText();
   	if(CnctMsg.contains(Lastname+numC))
   		System.out.println("Contact created successfully");
   	else
   		System.out.println("contact not created");
   	
   	// creating vendor
   	hp.getMoreLink().click();
    hp.getVendor().click();
    Vendor v=new Vendor(driver);
    v.getCreateVenimg().click();
    CreatingNewVendor cnv=new CreatingNewVendor(driver);
    String vndrname = eLib.getDataFromExcel("Vendor", 1, 1);
    int numV = jLib.getRandomNumber();
    cnv.createVendor(vndrname+numV);
    VendorInfo vi=new VendorInfo(driver);
    String VndrMsg = vi.getSucessmsg().getText();
    if(VndrMsg.contains(vndrname+numV))
    	System.out.println("Vendor successfully created");
    else
    	System.out.println("Vendor not created");
   
    //creating purchase order with vendor, item and contact
   	hp.getMoreLink().click();
	hp.getPurchaseLink().click();
	
	Purchase p=new Purchase(driver);
	p.getCrtePurchaseImg().click();
	
	
	}

}
