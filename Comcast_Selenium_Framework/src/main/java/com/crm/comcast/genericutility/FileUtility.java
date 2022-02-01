package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This is the genric class for data driver testing
 * @author Shiv
 *
 */
public class FileUtility 
{
	/**
	 * This is the generic method to read the data from commonData.properties File based on key which you pass as an argument
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyKeyValue(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.propertyPath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
