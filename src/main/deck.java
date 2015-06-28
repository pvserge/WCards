package main;
import java.util.*;
import main.Data;

public class Deck {
	
	private Data Words = new Data();
	private ArrayList<Card> Cards = new ArrayList<Card>();

	public void initDeck(){
		
		Map<String, String> vocab = Words.initDict("data\\test_vocab.txt");
		int i = 0;
		
		for (Map.Entry<String, String> entry: vocab.entrySet()) { 
			String word = entry.getKey(); 
			String translation = entry.getValue();
			Cards.add(new Card(word, translation, i, 0));
			i += 1;
		} 
		
	}

	public ArrayList<Card> getCards() {
		return Cards;
	}

}
