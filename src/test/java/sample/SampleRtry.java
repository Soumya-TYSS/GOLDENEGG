package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.kiboko.GenericUtility.BaseClass;

public class SampleRtry extends BaseClass{
	
	@Test(retryAnalyzer = practice.ExampleRetryAnalyser.class)
	public void amazon() {
		
		Assert.assertEquals(true, false);
	}

}
