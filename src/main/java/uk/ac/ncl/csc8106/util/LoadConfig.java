package uk.ac.ncl.csc8106.util;

import java.io.IOException;
import java.util.Properties;

public class LoadConfig {
	
	private static LoadConfig instance = null;
	
	private LoadConfig() {}
	
	public static LoadConfig getInstance() {
		if(instance == null) {
			instance = new LoadConfig();
		}
		return instance;
	}
	
	public String getFilePath() {
		String filePath = "";
		
		Properties prop = new Properties();
		try {
			prop.load(LoadConfig.class.getResourceAsStream("config.properties"));
			filePath = prop.getProperty("filePath");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}
	
	public static void main(String[] args) {
		System.out.println(LoadConfig.getInstance().getFilePath());
	}
}
