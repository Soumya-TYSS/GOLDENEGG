package com.crm.kiboko.PurchaseTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.kiboko.GenericUtility.ExcelUtility;
import com.crm.kiboko.GenericUtility.FileUtility;
import com.crm.kiboko.GenericUtility.JavaUtility;
import com.crm.kiboko.GenericUtility.WebDriverUtility;

public class CreatePurchaseOrderwithItemandAddProduct {

	public static void main(String[] args) throws Throwable {
     WebDriverUtility wLib=new WebDriverUtility();
     ExcelUtility eLib=new ExcelUtility();
     FileUtility fLib=new FileUtility();
     JavaUtility jLib=new JavaUtility();
     
     String url=fLib.getPropertyKeyValue("url");
     String un=fLib.getPropertyKeyValue("un");
     String pw=fLib.getPropertyKeyValue("pw");
     
     WebDriver driver=new ChromeDriver();
     driver.get(url);
     driver.findElement(By.name("user_name")).sendKeys(un);
     driver.findElement(By.name("user_password")).sendKeys(pw);
     driver.findElement(By.id("submitButton")).click();
     driver.findElement(By.linkText("Products")).click();
     driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
     String prdname=eLib.getDataFromExcel("Product", 1, 1);
     int num = jLib.getRandomNumber();
     driver.findElement(By.name("productname")).sendKeys(prdname+num);
     driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
     driver.findElement(By.xpath("//img[@style='padding-left:5px']")).click();
   //  WebElement resource = driver.findElement(By.linkText("More"));
    // wLib.mouseHoverAction(driver, resource);
     driver.findElement(By.name("Purchase Order")).click();
     driver.findElement(By.xpath("//img[@alt='Create Purchase Order...']")).click();
     driver.findElement(By.name("subject")).sendKeys("New Purchase");
     driver.findElement(By.xpath("(//img[@align='absmiddle'])[3]")).click();
     String parentTitle = driver.getTitle();
     eLib.setDataExcel("Title", 1, 1, parentTitle);
     Set<String> set = driver.getWindowHandles();
     Iterator<String> it = set.iterator();
     while(it.hasNext())
     {
    	 String wh = it.next();
    	 driver.switchTo().window(wh);
    	 String currentTitle = driver.getTitle();
    	 if(parentTitle.contains(currentTitle))
    		 break;
     }
     eLib.setDataExcel("Vendor", 1, 1, "Divya"+num);
     String vendname = eLib.getDataFromExcel("Vendor", 1, 1);
     driver.findElement(By.id("search_txt")).sendKeys(vendname);
     driver.findElement(By.xpath("//input[@name='search']")).click();
     
     
     
     
	}

}
