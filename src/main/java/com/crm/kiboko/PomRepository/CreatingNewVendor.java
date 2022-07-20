package com.crm.kiboko.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewVendor {
	WebDriver driver;
	
	public CreatingNewVendor(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="vendorname")
	private WebElement vendorname;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
     private WebElement savBt;

	public WebElement getVendorname() {
		return vendorname;
	}

	public WebElement getSavBt() {
		return savBt;
	}
	
	public void createVendor(String name)
	{
		vendorname.sendKeys(name);
		savBt.click();
	}
	
}
