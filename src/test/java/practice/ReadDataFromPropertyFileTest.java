package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.j2objc.annotations.Property;

public class ReadDataFromPropertyFileTest {
/*static {
	System.setProperty("webdriver")
}*/
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./data/testdata.properties");
	    	Properties p=new Properties();
	    	p.load(fis);
	    	String browser = p.getProperty("Browser");
	    	String url = p.getProperty("url");
	    	String un=p.getProperty("un");
	    	String pw=p.getProperty("pw");
	    	WebDriver driver=new ChromeDriver();
	    	driver.get(url);
	    	driver.findElement(By.name("user_name")).sendKeys(un);
	    	driver.findElement(By.name("user_password")).sendKeys(pw);
	    	driver.findElement(By.id("submitButton")).click();
	    	driver.close();
	    
	    	
	    	
      
	}

}
