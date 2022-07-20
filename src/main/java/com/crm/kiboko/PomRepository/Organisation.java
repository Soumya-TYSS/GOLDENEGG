package com.crm.kiboko.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.kiboko.GenericUtility.WebDriverUtility;

public class Organisation extends WebDriverUtility{
	
	WebDriver driver;
	public Organisation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgImage;
	
	public WebElement getCreateOrgImage() {
		return createOrgImage;
	}
	
	

}
