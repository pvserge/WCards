package main;

import java.util.*;
import java.io.*;

public class Config {
	
	// String field to keep path to dictionary
	private String dataFile;
	
	// getter for dataFile field
	// gets nothing
	// returns dataFile (string value with path to dictionary) 
	public String getDataFile(){
		return dataFile;
	}
	
	// methods to read path from configuration file ("config\\config.xml")
	// and save it to dataFile class field
	// gets nothing
	// returns nothing
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
