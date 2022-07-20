package com.crm.kiboko.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContact {
	
WebDriver driver;
	
	public CreatingNewContact(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement FrsNameTxtBx;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement lookUpIcon;
	
   @FindBy(name="search_text")
   private WebElement searchTxBx;
   
   @FindBy(name="search")
   private WebElement searchBT;

	@FindBy(xpath="//input[@name='lastname']")
	private WebElement LstNameTxtBx;
	
	@FindBy(xpath="//a[@href='javascript:;']/../../../tr[2]/td[1]")
	private WebElement contactText;
	
	
	
	public WebElement getFrsNameTxtBx() {
		return FrsNameTxtBx;
	}


	public WebElement getLstNameTxtBx() {
		return LstNameTxtBx;
	}


	public WebElement getContactText() {
		return contactText;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
	public WebElement getSearchTxBx() {
		return searchTxBx;
	}


	public WebElement getSearchBT() {
		return searchBT;
	}

	   
	public WebElement getLookUpIcon() {
		return lookUpIcon;
	}
   

public void createCnt(String Frstname, String LstName)
   {
	   FrsNameTxtBx.sendKeys(Frstname);
	   LstNameTxtBx.sendKeys(LstName);
	   saveBtn.click();
   }


}
