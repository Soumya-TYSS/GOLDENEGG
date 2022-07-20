package practice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ExampleRetryAnalyser implements IRetryAnalyzer{

	public boolean retry(ITestResult arg0) {
    int count=0;
    int retrylimit=4;
		
    if(count<retrylimit)
    	{
    	count++;
    	return true;
    	}
		return false;
	}

	
}
