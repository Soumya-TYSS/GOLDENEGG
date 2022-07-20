package com.crm.kiboko.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProduct {
	
	WebDriver driver;
	public CreatingNewProduct(WebDriver driver)
	{ 
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement prdNameTxtBx;
	
	@FindBy(id="jscal_trigger_sales_start_date")
	private WebElement startDate;
	
	public WebElement getVendNamelookUpicon() {
		return VendNamelookUpicon;
	}

	public WebElement getPdctCategory() {
		return pdctCategory;
	}

	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement VendNamelookUpicon;
	
	@FindBy(name="discontinued")
	private WebElement PrdtActCheckBox;
	
	@FindBy(name="manufacturer")
	private WebElement manufacturer;
	
	@FindBy(name="unit_price")
	private WebElement currencyTxtBx;
	
	@FindBy(id="commissionrate")
	private WebElement commisnRtTxBx;
	
	@FindBy(name="productcategory")
	private WebElement pdctCategory;
	
	@FindBy(id="search_txt")
	private WebElement searchTxBx;
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement SearchBx;
	
	
	
	
	
	public WebElement getSearchTxBx() {
		return searchTxBx;
	}

	public WebElement getSearchBx() {
		return SearchBx;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPrdNameTxtBx() {
		return prdNameTxtBx;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getPrdtActCheckBox() {
		return PrdtActCheckBox;
	}

	public WebElement getManufacturer() {
		return manufacturer;
	}

	public WebElement getCurrencyTxtBx() {
		return currencyTxtBx;
	}

	public WebElement getCommisnRtTxBx() {
		return commisnRtTxBx;
	}

	public WebElement getVatChBx() {
		return vatChBx;
	}

	public WebElement getSalesChBx() {
		return salesChBx;
	}

	public WebElement getServiceChBx() {
		return serviceChBx;
	}

	public WebElement getHandlerRdBt() {
		return HandlerRdBt;
	}

	public WebElement getChooseFile() {
		return chooseFile;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(id="tax1_check")
	private WebElement vatChBx;
	
	@FindBy(id="tax2_check")
	private WebElement salesChBx;
	
	@FindBy(id="tax3_check")
	private WebElement serviceChBx;
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement HandlerRdBt;
	
	@FindBy(id="my_file_element")
	private WebElement chooseFile;
	
	@FindBy(xpath="(//input[@name='productname'])[1]")
	private WebElement saveBtn;
	
	public void createNewPrd(String prdname)
	{
		prdNameTxtBx.sendKeys(prdname);
		saveBtn.click();
	}

}
