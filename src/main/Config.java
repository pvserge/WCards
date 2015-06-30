package main;

import java.util.*;
import java.io.*;

public class Config {
	
	private String dataFile;
	
	public String get_dataFile(){
		return dataFile;
	}
	
	public void readConfig(){
		try{
			//read config file 
			Properties props = new Properties();
			FileInputStream fis = new FileInputStream("config\\config.xml");
			
			//get properties from file
			props.loadFromXML(fis);
			
			//reading properties
			dataFile = props.getProperty("data_file");
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage().toString());
		}
	}
	
}
