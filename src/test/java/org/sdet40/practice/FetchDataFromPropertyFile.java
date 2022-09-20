package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//convert the Physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		//create the object for the properties
		Properties property = new Properties();
		//load all the keys
		property.load(fis);
		//fetch the data
		String url = property.getProperty("url").trim();
		String usna = property.getProperty("usna").trim();
		String pwd = property.getProperty("pwd").trim();
		
		System.out.println(url);
		System.out.println(usna);
		System.out.println(pwd);
		
		

	}

}
