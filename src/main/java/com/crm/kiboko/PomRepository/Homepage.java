package com.crm.kiboko.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.kiboko.GenericUtility.WebDriverUtility;

public class Homepage extends WebDriverUtility{
	
	WebDriver driver;
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(linkText="Organizations")
	private WebElement OrganisationLink;
	
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement ContactsLink;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLink;
	
	@FindBy(linkText="Purchase Order")
	private WebElement PurchaseLink;
	
	@FindBy(xpath="(//a[@class='drop_down_usersettings'])[2]")
	private WebElement SignOutLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement CampaignLink;
	
	@FindBy(linkText="More")
     private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Administrator;
	
     @FindBy(linkText="Vendors")
     private WebElement Vendor;
	
	public WebElement getVendor() {
		return Vendor;
	}

	public WebElement getAdministrator() {
		return Administrator;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getOrganisationLink() {
		return OrganisationLink;
	}

	public WebElement getCampaignLink() {
		return CampaignLink;
	}

	public void setOrganisationLink(WebElement organisationLink) {
		OrganisationLink = organisationLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getPurchaseLink() {
		return PurchaseLink;
	}
	
	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	public void clickOnMoreLink()
	{
		mouseHoverAction(driver, moreLink);
	}
	
	
	public void logOut()
	{
		mouseHoverAction(driver, Administrator);
		SignOutLink.click();
	}
	
	

}
