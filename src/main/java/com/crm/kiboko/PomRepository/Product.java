package com.crm.kiboko.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {

	WebDriver driver;
	
	public Product(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createPrdImg;

	public WebElement getCreatePrdImg() {
		return createPrdImg;
	}
	
	
	
}
