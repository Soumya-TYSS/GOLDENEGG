package com.crm.kiboko.campaignTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
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
import com.crm.kiboko.PomRepository.CreatingNewCampaign;
import com.crm.kiboko.PomRepository.Homepage;
import com.crm.kiboko.PomRepository.LoginPage;

public class CreateCampaignWithProductTest {

	public static void main(String[] args) throws Throwable {
     	ExcelUtility eLib=new ExcelUtility();
     	JavaUtility jLib=new JavaUtility();
     	FileUtility fLib=new FileUtility();
     	WebDriverUtility wLib=new WebDriverUtility();
     	WebDriver driver=new ChromeDriver();
     	
		LoginPage lp=new LoginPage(driver);
		String url = fLib.getPropertyKeyValue("url");
		String un = fLib.getPropertyKeyValue("un");
		String pwd = fLib.getPropertyKeyValue("pw");
		lp.loginToVtiger(url, un, pwd);
		wLib.waitForPageLoad(driver);
		driver.manage().window().maximize();
		int num = jLib.getRandomNumber();
		int num1=jLib.getRandomNumber();
		Homepage hp=new Homepage(driver);
        hp.getMoreLink().click();
        hp.getCampaignLink().click();
        Campaign c=new Campaign(driver);
        c.getCreateCmpImage().click();
		CreatingNewCampaign cnc=new CreatingNewCampaign(driver);
		String cmpname = eLib.getDataFromExcel("Campaign", 1, 1);
        cnc.getCmpNameTxBx().sendKeys(cmpname+num);
        cnc.getPrdLookUp().click();
        String partialLink = eLib.getDataFromExcel("Product", 1, 2);
        String prtnWnTitle = driver.getTitle();
        eLib.setDataExcel("Product", 1, 3, prtnWnTitle);
        wLib.switchWindows(driver, partialLink);
		String prdname = eLib.getDataFromExcel("Product", 1, 1);
		cnc.getSelectBx().sendKeys(prdname+num1);
		cnc.getSearchBt().click();
		cnc.getPname().click();
		Thread.sleep(3000);
		wLib.switchWindows(driver, prtnWnTitle);	
		Thread.sleep(5000);
        cnc.getSvBt().click();
		CampaignInfo ci=new CampaignInfo(driver);
		String text = ci.getSucessMsg().getText();
		if(text.contains(cmpname))
			System.out.println("Contact created successfully");
		else
			System.out.println("Contact not created");
		
		hp.getAdministrator().click();
		hp.getSignOutLink().click();
		
		driver.close();
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}