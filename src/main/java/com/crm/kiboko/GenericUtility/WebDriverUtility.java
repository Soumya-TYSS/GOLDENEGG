package com.crm.kiboko.GenericUtility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**This is a Generic class for all WebDriver methods
 *
 * @author Pai
 *
 */
public class WebDriverUtility {
	/**
	 * This method waits for an element in DOM(Implicit Wait)
	 * @author Pai
	 * @param driver
	 *
	 */	
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**This method is used to wait for element in DOM as well as GUI(Explicit Wait)
	 * 
	 * @author Pai
	 */
	public void waitForElement(WebDriver driver, String key)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs(key));
	}
	
	/** This method is used for ExplictWait
	 * 
	 * @param driver
	 * @param element
	 */
	
	public void waitForElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/** This method is used Select an WebElement By Index 
	 * 
	 * @author Pai
	 */
	
	public void selectByIndex(WebElement element, int i)
	{
		Select s=new Select(element);
		s.selectByIndex(i);
	}
	/** This method is used Select an WebElement By Value 
	 * 
	 * @author Pai
	 */
	
	public void selectByValue(WebElement element, String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	/** This method is used Select an WebElement By Visible Text
	 * 
	 * @param element
	 * @param text
	 */
	public void selectByVisibleText(WebElement element, String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	/** This method is used DesSelect an WebElement By Index 
	 * 
	 * @author Pai
	 */
	
	public void deselectByIndex(WebElement element, int i)
	{
		Select s=new Select(element);
		s.deselectByIndex(i);
	}
	
	
	/** This method is used to move the mouse(Mouse hover action)
	 * 
	 * @param driver
	 * @param elemnet
	 */
	
	public void mouseHoverAction(WebDriver driver, WebElement target)
	{
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
	}
	/**This method is used to move the mouse(Mouse hover action)
	 * 
	 * @param driver
	 * @param target
	 */
	
	public void rightClick(WebDriver driver, WebElement target)
	{
		Actions a=new Actions(driver);
		a.contextClick(target).perform();
	}
	/**This method is used to drag and drop of Action Class
	 * 
	 * @param driver
	 * @param target
	 */
	
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target)
	{
		Actions a =new Actions(driver);
		a.dragAndDrop(source, target).perform();;
	}
	/** This method is used for double click using mouse
	 * 
	 * @param driver
	 * @param target
	 */
	public void doubleClick(WebDriver driver, WebElement target)
	{
		Actions a =new Actions(driver);
		a.doubleClick(target).perform();;
	}
	
	
	/**
	 * 	 used to right click  on specified element

	 * @param driver
	 * @param elemnet
	 */
	
	public void rightClickOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}
	
	/** This method is used to Scroll 
	 * 
	 * @param driver
	 * @param javascript
	 */
	public void executeJavaScript(WebDriver driver, String javascript) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeAsyncScript(javascript, null);
		
	}
   /**This method is used to switch windows
    * 
    * @param driver
    * @param PartialTitle
    */
	
	
	public void switchWindows(WebDriver driver, String PartialTitle) 
	{
	   Set<String> set = driver.getWindowHandles();
	   	Iterator<String> it = set.iterator();
	   	while(it.hasNext())
	   	{
	   		String wad = it.next();
	   		driver.switchTo().window(wad);
	   		String currenttitle = driver.getTitle();
	   		if(currenttitle.contains(PartialTitle))
	   			break;
	   	}
	}

}
