package com.crm.kiboko.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganisation {
	
	WebDriver driver;
	
	public CreatingNewOrganisation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@name='accountname'])[1]")
	private WebElement orgNameTxtBx;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
   public void createOrg(String orgname)
   {
	   orgNameTxtBx.sendKeys(orgname);
	   saveBtn.click();
   }
	
}