package org.tyss.ProvidenceSMS.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	Properties property;

	public void initializePropertyFile(String propertyPath) {
		FileInputStream fisProperty = null;
		try {
			fisProperty = new FileInputStream(propertyPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		property = new Properties();
		try {
			property.load(fisProperty);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method consists of the code to fetch data from Property file
	 * @param key
	 * @return
	 */
	public String getDataFromPropertyFile(String key) {

		return property.getProperty(key).trim();
	}
}
