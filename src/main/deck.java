package main;
import java.util.*;

import main.Data;

public class Deck {
	
	private Data Words = new Data();
	private ArrayList<Card> Cards = new ArrayList<Card>();

	public void initDeck(String filename){
		
		Map<String, String> vocab = Words.initDict(filename);
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
	
/*	public void putCardToBottom(Card card, ArrayList<Card> cards){*/
	public void putCardToBottom(Card card){
		card.setPosition(Cards.size());
		for(int i = 0; i < Cards.size(); i++){
			Cards.get(i).setPosition(Cards.get(i).getPosition()-1);
		}
	}
	
	public void saveDeckToFile(String filename){
		Map<String, String> vocab = new LinkedHashMap<>();
		ArrayList<Card> crd = Cards;
		for(int i = 0; i < crd.size(); i++){
			for(Card item : crd){
				if(item.getPosition() == i){
					vocab.put(item.getWord(), item.getTranslation());
				}
			}		
		}
		Words.dictToFile(filename, vocab);
	}

}
