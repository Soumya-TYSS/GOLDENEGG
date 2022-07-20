package com.crm.kiboko.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class LisImpClss implements ITestListener {

	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
        File src = edriver.getScreenshotAs(OutputType.FILE);
        String date=new Date().toString().replaceAll(":", "_");
        try {
        	FileUtils.copyFile(src, new File("./screenshot/"+testName+date+".png"));
        }
		catch(IOException e)
        {
			e.printStackTrace();
        }
		
	}
	
	

}
