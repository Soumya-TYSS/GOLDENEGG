package com.crm.kiboko.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.kiboko.GenericUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{
	
	WebDriver driver;
	
	// constructor to initialise the elements
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//location un text box
	@FindBy(name="user_name")
	private WebElement untxtbx;
	
	//locating pw text box
	@FindBy(name="user_password")
	private WebElement pwtxtbx;
	
	//locating login button
	@FindBy(id="submitButton")
	private WebElement loginbtn;

	// to give read access to un text box
	public WebElement getUntxtbx() {
		return untxtbx;
	}

	// to give read access to pw text box
	public WebElement getPwtxtbx() {
		return pwtxtbx;
	}
	
	//method to login to vtiger aplication
	public void loginToVtiger(String url, String un, String pw )
	{
		driver.get(url);
	    untxtbx.sendKeys(un);
	    pwtxtbx.sendKeys(pw);
	    loginbtn.click();
	}
	
	

}
