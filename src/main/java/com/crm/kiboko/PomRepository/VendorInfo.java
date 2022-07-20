package com.crm.kiboko.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfo {
	WebDriver driver;
	
	public VendorInfo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement Sucessmsg;

	public WebElement getSucessmsg() {
		return Sucessmsg;
	}

	
	
}
