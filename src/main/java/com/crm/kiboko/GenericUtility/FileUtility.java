package com.crm.kiboko.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;
/**This is a Generic class for PropertyFile
 * 
 * @author Pai
 *
 */
public class FileUtility implements Iconstants{
	
		/** its used to read the data from commonData.properties File based on Key which you pass as an argument
		 * @param key
		 * @throws Throwable 
		 */
	    public String getPropertyKeyValue(String key) throws Throwable {
	    	 FileInputStream fis = new FileInputStream(PropertyFilePath);
	    	 Properties p = new Properties();
	    	 p.load(fis);
	    	 String value = p.getProperty(key);
			return value;
	    	
	    }
	}


