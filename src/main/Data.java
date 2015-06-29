package main;

import java.util.*;
import java.io.*;

public class Data {
	
	private Map<String, String> Vocab = new LinkedHashMap<>();

	public Map<String, String> getVocab() {
		return Vocab;
	}

	public void setVocab(String key, String value) {
		Vocab.put(key, value);
	}
	
	public Map<String, String> initDict(String filename){

		fileToDict(filename);
		return Vocab;
	}
	
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
