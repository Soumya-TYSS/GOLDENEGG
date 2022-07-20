package com.crm.kiboko.campaignTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.kiboko.GenericUtility.BaseClass;
import com.crm.kiboko.GenericUtility.ExcelUtility;
import com.crm.kiboko.GenericUtility.FileUtility;
import com.crm.kiboko.GenericUtility.JavaUtility;
import com.crm.kiboko.GenericUtility.WebDriverUtility;
import com.crm.kiboko.PomRepository.Campaign;
import com.crm.kiboko.PomRepository.CampaignInfo;
import com.crm.kiboko.PomRepository.CreatingNewCampaign;
import com.crm.kiboko.PomRepository.Homepage;

public class CreateCampaignTest extends BaseClass{

	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	JavaUtility jLib=new JavaUtility();
	
	@Test
	public void CreateCmpgTest() throws Throwable
	{
		Homepage hp=new Homepage(driver);
       hp.clickOnMoreLink();
     //  hp.getMoreLink().click();
        hp.getCampaignLink().click();
        Campaign c=new Campaign(driver);
	    c.getCreateCmpImage().click();
	    String data = eLib.getDataFromExcel("Campaign", 1, 1);
        CreatingNewCampaign cno=new CreatingNewCampaign(driver);
        int num = jLib.getRandomNumber();
        cno.createCmp(data+num);
	      CampaignInfo ci=new CampaignInfo(driver);
	      WebElement msgElement = ci.getSucessMsg();
	      String confirmMsg = msgElement.getText();
         if(confirmMsg.contains(data))
	       	  System.out.println("Campaign is sucessfully created");
         else
      	   System.out.println("Campaign is not created");
	      

         
	}
	
	
	
	
	/*public static void main(String[] args) throws Throwable {
		
		String url=fLib.getPropertyKeyValue("url");
		String un = fLib.getPropertyKeyValue("un");
	    String pwd = fLib.getPropertyKeyValue("pw");  
		WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	   wLib.waitForPageLoad(driver);
	    // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      LoginPage l=new LoginPage(driver);
	      l.loginToVtiger(url, un, pwd);
	      Homepage hp=new Homepage(driver);
          hp.getMoreLink().click();
          hp.getCampaignLink().click();
          Campaign c=new Campaign(driver);
	      c.getCreateCmpImage().click();
	        
	      
	      
	      //driver.get(url);
	     // driver.findElement(By.name("user_name")).sendKeys(un);
	      //driver.findElement(By.name("user_password")).sendKeys(pwd);
	      //driver.findElement(By.id("submitButton")).click();
	      
	      //Actions a =new Actions(driver);
	      //a.moveToElement(resource).perform();
	      //driver.findElement(By.linkText("Campaigns")).click();
	      //driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	      //FileInputStream f1=new FileInputStream("./data/lastname.xlsx");
	      //Workbook wb = WorkbookFactory.create(f1);
	      //String data = wb.getSheet("Campaign").getRow(1).getCell(1).toString();
	      String data = eLib.getDataFromExcel("Campaign", 1, 1);
           CreatingNewCampaign cno=new CreatingNewCampaign(driver);
           int num = jLib.getRandomNumber();
           cno.createCmp(data+num);
           
	      //	      driver.findElement(By.name("campaignname")).sendKeys(data);
	      //driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	      //WebElement we = driver.findElement(By.name("assigned_group_id"));
	      //Select s2=new Select(we);
	      //s2.selectByVisibleText("Team Selling");
	      //wLib.selectByVisibleText(we,"Team Selling");
	      //driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	      //String ConfirmMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	      CampaignInfo ci=new CampaignInfo(driver);
	      WebElement msgElement = ci.getSucessMsg();
	      String confirmMsg = msgElement.getText();
           if(confirmMsg.contains(data))
	       	  System.out.println("Campaign is sucessfully created");
	    	 // WebElement res = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
				//Actions a1 =new Actions(driver);
				//a1.moveToElement(res).perform();
	    	 // wLib.mouseHoverAction(driver, res);
				//driver.findElement(By.linkText("Sign Out")).click();
           else
        	   System.out.println("Campaign is not created");
	      
           hp.getAdministrator().click();
           hp.getSignOutLink().click();
	      
    driver.close();
	*/
	}


