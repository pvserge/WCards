package main;

import java.util.*;
import java.io.*;

public class Data {
	
	// linked hash map Vocab field	
	private Map<String, String> Vocab = new LinkedHashMap<>();

	// getter for Vocab field
	// gets nothing
	// returns Vocab as Linked hash map
	public Map<String, String> getVocab() {
		return Vocab;
	}

	// setter for Vocab field
	// gets key and value as String
	// returns nothing
	public void setVocab(String key, String value) {
		Vocab.put(key, value);
	}
	
	// initialize dictionary by setting values from file to Vocab field
	// gets file name as string (each line is key and value divided by space)
	// returns Vocab as linked hash map
	public Map<String, String> initDict(String filename){

		fileToDict(filename);
		return Vocab;
	}
	
	// load dictionary from file to Vocab
	// gets dictionary's file name
	// returns nothing
	public void fileToDict(String filename){

		try{
			Scanner file = new Scanner(new File(filename), "UTF-8");
			while(file.hasNextLine()){
				String line = file.nextLine();
				String[] s = line.split(" ");
				
				String key = s[0];
				String value = s[1];
				
				setVocab(key, value);			
			}
			file.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage().toString());
		}	
		
	}
	
	// save Vocab to file as dictionary (key and value divided by  
	// gets file name and hash map as fields
	// returns nothing (saved file to hdd, overrides existing)
	public void dictToFile(String filename, Map<String, String> vocab){
		try{
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
			for (Map.Entry<String, String> entry: vocab.entrySet()) { 
				String word = entry.getKey(); 
				String translation = entry.getValue();
				writer.println(word + " " + translation);
			} 	
			writer.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage().toString());
		}
	}
}
