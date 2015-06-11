package main;

import java.util.*;

public class Data {
	
	private Map<String, String> Vocab = new HashMap<>();

	public Map<String, String> getVocab() {
		return Vocab;
	}

	public void setVocab(String key, String value) {
		Vocab.put(key, value);
	}
	
	public Map<String, String> initDict(){
		setVocab("key", "ключ");
		setVocab("look", "смотреть");
		return Vocab;
	}

}
