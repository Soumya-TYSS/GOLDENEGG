package com.crm.kiboko.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vendor {
   WebDriver driver;
   
   public Vendor(WebDriver driver)
   {
	  this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
	
		
     @FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
     private WebElement createVenimg;

	public WebElement getCreateVenimg() {
		return createVenimg;
	}
     
		
		
		
	}


