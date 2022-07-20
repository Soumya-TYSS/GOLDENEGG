package com.crm.kiboko.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaign {
	
	WebDriver driver;
	public Campaign(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createCmpImage;
	
	
	
	public WebElement getCreateCmpImage() {
		return createCmpImage;
	}
	
	
	
}
