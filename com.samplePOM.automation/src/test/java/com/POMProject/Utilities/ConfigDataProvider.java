package com.POMProject.Utilities;

import java.io.File;
import java.io.FileInputStream;


import java.util.Properties;



public class ConfigDataProvider {

	Properties pro;
	public ConfigDataProvider()
	{
	File src=new File("./Configuration/config.properties");
	try {
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	} 
}

	public  String getDataConfig(String keyToSearch) {
		return pro.getProperty(keyToSearch);
	}

public  String getBrowser() {
	return pro.getProperty("Browser");
}

public  String getExcelpath() {
	return pro.getProperty("ExcelPath");
}
public String getChromePath() {
	return pro.getProperty("ChromePath");
}
public  String getAppURL() {
	return pro.getProperty("URL");
}
}
