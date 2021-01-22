package com.selenium.InsuranceProject.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class RegDataHandling {

	public static  String getpropertiesvalues(String Key) throws Exception {
		Properties prop  = new Properties();
		InputStream input = new FileInputStream("C:\\Users\\ravil\\eclipse-workspace\\com.selenium.InsuranceProjectFrameWork\\src\\main\\java\\RegTestData\\regtestdata.properties");
		prop.load(input);
		return prop.getProperty(Key);
	}
}
