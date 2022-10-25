package com_crm_generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_utility {
	
	/*
	 * this method is used to launch the application
	 * parameter key
	 * return
	 * throws throwable
	 * author manjunath
	 */

	public String getPropertyKeyValue(String Key) throws Throwable {
		
		//FileInputStream fis = new FileInputStream("./common_data.properties");
		FileInputStream fis = new FileInputStream(ipathConstatnts.PROPERTYFILE_PATH);
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		
		return value;

	}

}
