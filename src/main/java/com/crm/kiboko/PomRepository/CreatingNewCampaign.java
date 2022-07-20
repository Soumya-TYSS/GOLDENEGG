package com.crm.kiboko.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaign {
WebDriver driver;
	
	public CreatingNewCampaign(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement cmpNameTxBx;
	
	@FindBy(xpath="//input[@value='U']")
	private WebElement assgTo_U;
	
	//@FindBy(xpath="//input[@value='T']")
	//private WebElement assgTo_G;
	
	@FindBy(id="search_txt")
	private WebElement selectBx;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement svBt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement prdLookUp;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBx;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement searchBt;
	
	@FindBy(xpath="//a[text()='Product Name ']/../../../tr[2]/td[1]/a")
	private WebElement Pname;
	
	public WebElement getPname() {
		return Pname;
	}

	public WebElement getCmpNameTxBx() {
		return cmpNameTxBx;
	}

	public WebElement getAssgTo_U() {
		return assgTo_U;
	}

	public WebElement getSearchBx() {
		return searchBx;
	}

	public WebElement getSearchBt() {
		return searchBt;
	}

	public WebElement getSelectBx() {
		return selectBx;
	}

	public WebElement getSvBt() {
		return svBt;
	}

	public WebElement getPrdLookUp() {
		return prdLookUp;
	}

	public void createCmp(String cmpname)
	   {
       cmpNameTxBx.sendKeys(cmpname);
		   svBt.click();
	   }

	
}
