package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.kiboko.GenericUtility.BaseClass;
@Listeners(com.crm.kiboko.GenericUtility.LisImpClss.class)
public class SampleTaksScreenShot extends BaseClass{
	
	@Test
	public void failing()
	{
		System.out.println("========STARTS=======");
		Assert.assertEquals(true, false);
		System.out.println("======FAIL=======");
	}
	

}
