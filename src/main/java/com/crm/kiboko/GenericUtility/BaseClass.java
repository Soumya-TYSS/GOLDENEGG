package com.crm.kiboko.GenericUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.kiboko.PomRepository.Homepage;
import com.crm.kiboko.PomRepository.LoginPage;

public class BaseClass {

    public WebDriver driver;
	ExcelUtility eLib=new ExcelUtility();
	FileUtility fLib=new FileUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	DataBaseUtility dLib=new DataBaseUtility();
	
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"smoke", "regression"})
	public void configBS() throws SQLException {
		System.out.println("========>CONNECTING TO DATA BASE<===========");
		dLib.connectToDB();
	}
		
	@BeforeClass(groups= {"smoke", "regression"})
	public void configBC() {
		System.out.println("============> LAUNCH THE BROWSER<=============");
	
		/*
		if(Browser.equalsIgnoreCase("chrome"))
		driver=new ChromeDriver();
	else if(Browser.equalsIgnoreCase("FireFox"))
		driver=new FirefoxDriver();
	else if(Browser.equalsIgnoreCase("MicroSoft Edge"))
        driver=new EdgeDriver();
	else
		driver=new ChromeDriver();
	*/
	// wait for page to laod
    
    driver=new ChromeDriver();
    sdriver=driver;
    wLib.waitForPageLoad(driver);
	
	//maximizing the page
	driver.manage().window().maximize();
	
	}
	
	@BeforeMethod(groups= {"smoke", "regression"})
	public void conFigBM() throws Throwable
	{
		//common data
		String url=fLib.getPropertyKeyValue("url");
		String un=fLib.getPropertyKeyValue("un");
		String pw=fLib.getPropertyKeyValue("pw");
	   //login to application using POM class
		LoginPage lp=new LoginPage(driver);
	   lp.loginToVtiger(url, un, pw);
	}
	
	@AfterMethod(groups= {"smoke", "regression"})
	public void conFigAM() {
		//Logout of the application
       Homepage hp=new Homepage(driver);
     hp.logOut();
       // hp.getAdministrator();
        //hp.getSignOutLink().click();
	}
	
	@AfterClass(groups= {"smoke", "regression"})
	public void conFigAC()
	{
		System.out.println("===========> CLOSE THE BROWSER<============");
		driver.quit();
	}
		
	@AfterSuite(groups= {"smoke", "regression"})
	public void conFigAS() throws SQLException
	{
		System.out.println("============> CLOSE DB CONNECTION<===========");
		dLib.closeDB();
	}
		
}
