package main;

import java.util.*;
import java.io.*;

public class Data {
	
	private Map<String, String> Vocab = new HashMap<>();

	public Map<String, String> getVocab() {
		return Vocab;
	}

	public void setVocab(String key, String value) {
		Vocab.put(key, value);
	}
	
	public Map<String, String> initDict(String file_name){

		try{
			Scanner file = new Scanner(new File(file_name));
			while(file.hasNextLine()){
				String line = file.nextLine();
				String[] s = line.split(" ");
				
				String key = s[0];
				String value = s[1];
				
				setVocab(key, value);			
			}
			file.close();
		}
		catch (IOException e){
			System.out.println(e.getMessage().toString());
		}	
		
		return Vocab;
	}
}
