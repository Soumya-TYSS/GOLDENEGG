package com.crm.kiboko.GenericUtility;

import java.util.Random;

/**This is a Generic class for all java methods 
 * 
 * @author Pai
 *
 */
public class JavaUtility {
	/** This is a Generic method to get Random Number
	 * 
	 * @return number
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		int num = r.nextInt(1000);
		return num;
		
	}
}
